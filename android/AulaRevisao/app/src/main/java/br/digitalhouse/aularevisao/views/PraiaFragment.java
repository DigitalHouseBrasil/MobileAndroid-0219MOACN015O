package br.digitalhouse.aularevisao.views;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.digitalhouse.aularevisao.R;
import br.digitalhouse.aularevisao.model.Praia;


/**
 * A simple {@link Fragment} subclass.
 */
public class PraiaFragment extends Fragment {
    private ImageView imagem;
    private TextView nome;

    public PraiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_praia, container, false);

        imagem = view.findViewById(R.id.imagemPraia);
        nome = view.findViewById(R.id.textoNomePraia);


        Bundle bundle = getArguments();

        if (bundle != null) {

            Praia praia = bundle.getParcelable("PRAIA");

            nome.setText(praia.getNomePraia());

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = getContext().getDrawable(praia.getImagem());

                imagem.setImageDrawable(drawable);
            }

        }
        return view;
    }

}
