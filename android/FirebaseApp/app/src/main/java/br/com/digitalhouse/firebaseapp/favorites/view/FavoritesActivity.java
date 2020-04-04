package br.com.digitalhouse.firebaseapp.favorites.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.firebaseapp.R;
import br.com.digitalhouse.firebaseapp.adapters.FavoritesViewAdapter;
import br.com.digitalhouse.firebaseapp.interfaces.FavoriteItemClick;
import br.com.digitalhouse.firebaseapp.model.Result;
import br.com.digitalhouse.firebaseapp.util.AppUtil;

public class FavoritesActivity extends AppCompatActivity implements FavoriteItemClick {
    private RecyclerView recyclerView;
    private FavoritesViewAdapter adapter;

    // Pegamos a instancia do firebase, objeto necessario para salvar no banco de dados
    FirebaseDatabase database;

    // pegamos a referencia para onde no firebase queremos salvar nossos dados
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new FavoritesViewAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(adapter);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference(AppUtil.getIdUsuario(getApplication()) + "/favorites");

        carregarFavoritos();
    }

    private void carregarFavoritos() {
        // Adicionamos o loistener par pegar os resultados do firebase
        reference.orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Lista vazia pra pegar os resultados do firebase
                List<Result> results = new ArrayList<>();

                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Result result = child.getValue(Result.class);
                    results.add(result);
                }

                adapter.update(results);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void removeFavoriteClickListener(Result result) {
        // Adicionamos o listener par pegar os resultados do firebase
        reference.orderByKey().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    if (child.getValue(Result.class).getId().equals(result.getId())) {
                        child.getRef().removeValue();
                        adapter.removeItem(result);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
