package br.digitalhouse.comunicacaofragments.views;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import br.digitalhouse.comunicacaofragments.R;
import br.digitalhouse.comunicacaofragments.interfaces.Comunicador;
import br.digitalhouse.comunicacaofragments.model.SistemaOperacional;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrimeiroFragment extends Fragment {
    //Declaração do atributo do mesmo tipo da nossa interface
    private Comunicador comunicador;

    //Declaração dos componentes
    private Button botaoAndroid;
    private Button botaoIos;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        //tratamento da inicialização do atributo com try catch para caso haja uma exceção
        try {

            //inicialização do atributo recebendo um contexto que seja do tipo Comunicados(interface)
            //Nesse caso o contexto é a MainActivity que implementa a interface
            comunicador = (Comunicador) context;
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public PrimeiroFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_primeiro, container, false);

        //chamada do metodo que inicializa nossas views
        initViews(view);

        //click do botão android
        botaoAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criação do objeto do tipo SistemaOperacional passando os valores
                //pelo construtor
                SistemaOperacional so = new SistemaOperacional(
                        "ANDROID", R.drawable.android_imagem);

                //através do nosso atributo do tipo da interface invocamos o método que envia os dados
                //passando o objeto que acabou de ser criado com os dados de android
                comunicador.envioDadosSistemaOperacional(so);

            }
        });

        //click do botão ios
        botaoIos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Criação do objeto do tipo SistemaOperacional passando os valores
                //pelo construtor
                SistemaOperacional so = new SistemaOperacional(
                        "IOS", R.drawable.ios);

                //através do nosso atributo do tipo da interface invocamos o método que envia os dados
                //passando o objeto que acabou de ser criado com os dados de ios
                comunicador.envioDadosSistemaOperacional(so);
            }
        });

        return view;
    }

    private void initViews(View view){
        botaoAndroid = view.findViewById(R.id.botaoAndroid);
        botaoIos = view.findViewById(R.id.botaoIos);
    }

}
