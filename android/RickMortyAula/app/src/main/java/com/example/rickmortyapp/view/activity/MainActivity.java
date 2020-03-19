package com.example.rickmortyapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rickmortyapp.R;
import com.example.rickmortyapp.model.Result;
import com.example.rickmortyapp.view.adapter.AdapterCharacters;
import com.example.rickmortyapp.viewmodel.CharactersViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CharactersViewModel charactersViewModel;
    private List<Result> results = new ArrayList<>();
    private AdapterCharacters  adapterCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapterCharacters);

        charactersViewModel.getListCharacters();

        charactersViewModel.listLiveData.observe(this, results1 -> adapterCharacters.setUpdate(results1));

    }

    public void initViews(){
        recyclerView = findViewById(R.id.recycler_list);
        charactersViewModel = ViewModelProviders.of(this).get(CharactersViewModel.class);
        adapterCharacters = new AdapterCharacters(results);
    }
}
