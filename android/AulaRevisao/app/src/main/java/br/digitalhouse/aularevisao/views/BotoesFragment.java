package br.digitalhouse.aularevisao.views;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.digitalhouse.aularevisao.R;
import br.digitalhouse.aularevisao.interfaces.Comunicador;
import br.digitalhouse.aularevisao.model.Praia;


/**
 * A simple {@link Fragment} subclass.
 */
public class BotoesFragment extends Fragment {
    private Button botaoAlmada;
    private Button botaoJusta;
    private Comunicador comunicador;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        comunicador = (Comunicador) context;
    }

    public BotoesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_botoes, container, false);

        botaoAlmada = view.findViewById(R.id.btnPraiaAlmada);
        botaoJusta = view.findViewById(R.id.btnPraiaJusto);

        botaoAlmada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Praia almada = new Praia(R.drawable.almada, "Almada");
                comunicador.enviarPraia(almada);
            }
        });

        botaoJusta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Praia justa = new Praia(R.drawable.justa, "Justa");
                comunicador.enviarPraia(justa);
            }
        });



        return view;
    }

}
