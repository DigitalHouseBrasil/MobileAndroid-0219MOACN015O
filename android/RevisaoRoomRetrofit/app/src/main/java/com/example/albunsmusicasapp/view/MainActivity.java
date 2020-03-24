package com.example.albunsmusicasapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.albunsmusicasapp.R;
import com.example.albunsmusicasapp.model.Album;
import com.example.albunsmusicasapp.view.adapter.ArtistaAdapter;
import com.example.albunsmusicasapp.viewmodel.ArtistaViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    private RecyclerView recyclerView;
    private ArtistaAdapter adapter;
    private ArtistaViewModel viewModel;
    private SearchView searchViewPesquisa;
    private ProgressBar loading;
    private List<Album> listaAlbum = new ArrayList<>();
    private String nomeBanda = "Aerosmith";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        viewModel.getAlbuns(nomeBanda);

        viewModel.liveDataAlbum.observe(this, albumList -> {
            if (albumList != null && !albumList.isEmpty()) {
                adapter.atualizaLista(albumList);
            } else {
                Toast.makeText(this, "Album não encontrado", Toast.LENGTH_LONG).show();
            }
        });

        viewModel.liveDataLoading.observe(this, loadingBoolean -> {
                    if (loadingBoolean) {
                        loading.setVisibility(View.VISIBLE);
                    } else {
                        loading.setVisibility(View.INVISIBLE);
                    }
                }
        );

        viewModel.liveDataErro.observe(this, error -> {
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        });

        searchViewPesquisa.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String novoTexto) {
                nomeBanda = novoTexto;
                adapter.limpaListaAdapter();
                viewModel.getAlbuns(nomeBanda);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String novoTexto) {
                return false;
            }
        });
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ArtistaAdapter(listaAlbum);
        viewModel = ViewModelProviders.of(this).get(ArtistaViewModel.class);
        searchViewPesquisa = findViewById(R.id.searchView);
        loading = findViewById(R.id.progress_bar);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
