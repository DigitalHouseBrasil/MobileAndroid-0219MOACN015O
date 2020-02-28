package br.digitalhouse.menuscardview.galeria.view;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import br.digitalhouse.menuscardview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumFragment extends Fragment {
    private ImageView imagemAlbum;
    public static final String NOME_BANDA = "nome";
    public static final String IMAGEM_BANDA = "imagem";

    public AlbumFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(String nome, int imagem) {

        Fragment fragment = new AlbumFragment();

        Bundle bundle = new Bundle();

        bundle.putString(NOME_BANDA, nome);
        bundle.putInt(IMAGEM_BANDA, imagem);

        fragment.setArguments(bundle);

        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album, container, false);

        imagemAlbum = view.findViewById(R.id.imagemAlbum);

        if (getArguments() != null){

            Bundle bundle = getArguments();
            String nome = bundle.getString(NOME_BANDA);

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = getResources().getDrawable(bundle.getInt(IMAGEM_BANDA));

                imagemAlbum.setImageDrawable(drawable);

            }
        }

        return view;
    }

}
