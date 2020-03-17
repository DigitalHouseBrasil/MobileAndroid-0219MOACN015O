package com.example.animesjson.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.animesjson.R;
import com.example.animesjson.model.Anime;
import com.example.animesjson.view.adapter.AdapterAnimes;
import com.example.animesjson.viewmodel.AnimesListViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private AnimesListViewModel viewModel;
    private List<Anime> noticias = new ArrayList<>();
    private AdapterAnimes adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        initViews();


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel.renderizaAnimes();

        viewModel.retornaAnimeMutable().observe(this, animeList ->{
            adapter.update(animeList);
        });

        viewModel.retornaValorLoading().observe(this, loading ->{
            if(loading){
                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.GONE);
            }
        });
    }


    private void initViews(){
        recyclerView = findViewById(R.id.recycler_animes);
        progressBar = findViewById(R.id.progressBar);
        adapter = new AdapterAnimes(noticias);
        viewModel = ViewModelProviders.of(this).get(AnimesListViewModel.class);
    }
}
