package br.digitalhouse.menuscardview.home.contato.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.digitalhouse.menuscardview.R;
import br.digitalhouse.menuscardview.home.contato.model.Contato;

import static br.digitalhouse.menuscardview.home.HomeFragment.CONTATO_CHAVE;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContatosFragment extends Fragment {
    private TextView textViewNome;
    private TextView textViewTelefone;

    public ContatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contatos, container, false);

        textViewNome = view.findViewById(R.id.text_view_nome_contato);
        textViewTelefone = view.findViewById(R.id.text_view_nome_telefone);

        //verificação se o arguments nao está nulo
        if (getArguments() != null){

            //passando os dados do arguments para o bundle
            Bundle bundle = getArguments();
            //passando o contato que está chegando para a variavel do tipo contato
            Contato contato = bundle.getParcelable(CONTATO_CHAVE);

            //Passando os dados do contato nas respectivas views
            textViewNome.setText(contato.getNome());
            textViewTelefone.setText(contato.getTelefone());
        }

        return view;
    }

}
