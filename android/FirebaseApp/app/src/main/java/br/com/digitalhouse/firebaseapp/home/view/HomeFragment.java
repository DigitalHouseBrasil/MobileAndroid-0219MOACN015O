package br.com.digitalhouse.firebaseapp.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.login.LoginManager;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.adapters.RecyclerViewAdapter;
import br.com.digitalhouse.firebaseapp.favorites.view.FavoritesActivity;
import br.com.digitalhouse.firebaseapp.home.viewmodel.HomeViewModel;
import br.com.digitalhouse.firebaseapp.interfaces.FavoriteItemClick;
import br.com.digitalhouse.firebaseapp.interfaces.RecyclerViewClick;
import br.com.digitalhouse.firebaseapp.model.Result;

public class HomeFragment extends Fragment implements RecyclerViewClick, FavoriteItemClick {

    private RecyclerView recyclerView;
    private List<Result> results = new ArrayList<>();
    private HomeViewModel viewModel;
    private ProgressBar progressBar;
    private RecyclerViewAdapter adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        initViews(view);

        //recyclerView em modo Grid
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(adapter);

        //setando a nova lista para o adapter do recyclerView
        viewModel.buscarFilmes();
        viewModel.filmesLiveData.observe(getViewLifecycleOwner(), results -> adapter.setResult(results));

        //mudando a visibilidade da barra de progresso de acordo com o retorno do isLoading
        viewModel.isLoading.observe(getViewLifecycleOwner(), (Boolean loading) -> {
            if (loading) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        });

        viewModel.favoriteAdded.observe(getViewLifecycleOwner(), result -> {
            if (result != null) {
                Snackbar.make(recyclerView, result.getTitle() + " Adicionado as favoritos", Snackbar.LENGTH_LONG).show();
            }
        });
    }


    // Inicializa as Views
    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerview);
        progressBar = view.findViewById(R.id.progress_bar);
        adapter = new RecyclerViewAdapter(results, this, this);
        viewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
    }

    @Override
    public void clickListener(Result result) {
        Toast.makeText(getContext(), "ID " + result.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void removeFavoriteClickListener(Result result) {
        viewModel.salvarFavorito(result);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_favoritos) {
            startActivity(new Intent(getContext(), FavoritesActivity.class));
            return true;
        }

        if (id == R.id.action_logout) {
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    private void logout() {
        LoginManager.getInstance().logOut();
        FirebaseAuth.getInstance().signOut();
        NavHostFragment.findNavController(this).popBackStack();
    }
}
