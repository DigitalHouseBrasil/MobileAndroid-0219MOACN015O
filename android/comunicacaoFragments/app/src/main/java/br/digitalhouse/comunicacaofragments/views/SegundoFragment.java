package br.digitalhouse.comunicacaofragments.views;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.digitalhouse.comunicacaofragments.R;
import br.digitalhouse.comunicacaofragments.model.SistemaOperacional;

import static br.digitalhouse.comunicacaofragments.views.MainActivity.SISTEMA_OPERACIONAL;


/**
 * A simple {@link Fragment} subclass.
 */
public class SegundoFragment extends Fragment {
    private ImageView imagem;
    private TextView nomeSistema;


    public SegundoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_segundo, container, false);

        initViews(view);

        //verifica se o arguments que está chegando não é nulo
        if (getArguments() != null){

            //criamos um bandle que recebe os dados que esão chegando
            Bundle bundle = getArguments();

            //cria um objeto do tipo SistemOperacional que está recebendo o
            //objeto que está chegando atraves do getParcelable passando a chave de identificação
            SistemaOperacional so = bundle.getParcelable(SISTEMA_OPERACIONAL);

            //Inserindo o valor do nome que chegou para o textview
            nomeSistema.setText(so.getNomeSistema());

            //Nova instancia de um objeto drawable
            Drawable drawable = getResources().getDrawable(so.getImagem());

            //Setando a imagem que chegou para o componente imageView
            imagem.setImageDrawable(drawable);
        }

        return view;
    }

    private void initViews(View view){
        imagem = view.findViewById(R.id.imagem);
        nomeSistema = view.findViewById(R.id.textoNome);
    }

}
