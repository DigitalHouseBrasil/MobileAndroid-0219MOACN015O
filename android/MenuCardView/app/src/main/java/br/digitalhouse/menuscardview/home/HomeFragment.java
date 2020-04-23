package br.digitalhouse.menuscardview.home;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.digitalhouse.menuscardview.R;
import br.digitalhouse.menuscardview.home.contato.adapter.ContatoRecyclerViewAdapter;
import br.digitalhouse.menuscardview.home.contato.interfaces.ContatoListener;
import br.digitalhouse.menuscardview.home.contato.model.Contato;
import br.digitalhouse.menuscardview.home.contato.view.ContatosFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ContatoListener {
    //Declaração do componente recyclerview que foi adicionado no layout do fragment
    private RecyclerView recyclerViewContatos;
    //Declaração do adapter
    private ContatoRecyclerViewAdapter adapter;

    //Declaração da contante
    public static final String CONTATO_CHAVE = "contato";

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Inicialização do componente recyclerview
        recyclerViewContatos = view.findViewById(R.id.recycler_view_contatos);

        //Inicialização do adapter passando passando pelo construtor da classe o método que retorna uma lista de contatos
        adapter = new ContatoRecyclerViewAdapter(getListaContatos(), this );

        //Adicionamos ao componente o adapter
        recyclerViewContatos.setAdapter(adapter);

        //Definimos o layout que será apresentado o recyclerView

        //Layout em mosaico passando a quantidade de colunas, e se será Horizontal ou Vertical
        //recyclerViewContatos.setLayoutManager(new StaggeredGridLayoutManager(3, GridLayoutManager.HORIZONTAL));

        //Layout em Linear passando Vertical e o contexto
       recyclerViewContatos.setLayoutManager(new LinearLayoutManager(getContext()));

        //Layout em Linear passando que será Horizontal
        //recyclerViewContatos.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));

        //Layout em grid passando contexto e a quantidade de colunas
        //recyclerViewContatos.setLayoutManager(new GridLayoutManager(getContext(), 3));

        return view;
    }

    private List<Contato> getListaContatos() {
        List<Contato> contatos = new ArrayList<>();

        contatos.add(new Contato("Karol", "1111-1111"));
        contatos.add(new Contato("Henrique", "2111-1111"));
        contatos.add(new Contato("Sol", "3111-1111"));
        contatos.add(new Contato("Ingrid", "4111-1111"));
        contatos.add(new Contato("Adelania", "5111-1111"));
        contatos.add(new Contato("Erica", "6111-1111"));
        contatos.add(new Contato("Guilherme", "7111-1111"));
        contatos.add(new Contato("Leandro", "8111-1111"));
        contatos.add(new Contato("Leonardo", "9111-1111"));
        contatos.add(new Contato("Bruno", "0111-1111"));
        contatos.add(new Contato("Aruan", "2211-1111"));
        contatos.add(new Contato("Camille", "3311-1111"));

        return contatos;
    }

    //Sobrescrita do metodo da interface que irá enviar o contato clicado para o fragmento de contato
    @Override
    public void enviaContato(Contato contato) {
        Fragment fragment = new ContatosFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(CONTATO_CHAVE, contato);
        fragment.setArguments(bundle);

        replaceFragment(fragment);


    }

    private void replaceFragment(Fragment fragment){
        getActivity().getSupportFragmentManager()
                .beginTransaction().replace(R.id.container, fragment)
                .commit();
    }
}
