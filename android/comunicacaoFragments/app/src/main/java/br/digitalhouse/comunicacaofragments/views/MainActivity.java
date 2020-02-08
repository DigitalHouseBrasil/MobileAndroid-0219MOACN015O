package br.digitalhouse.comunicacaofragments.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import br.digitalhouse.comunicacaofragments.R;
import br.digitalhouse.comunicacaofragments.interfaces.Comunicador;
import br.digitalhouse.comunicacaofragments.model.SistemaOperacional;

public class MainActivity extends AppCompatActivity implements Comunicador {
    //Declaração de constante. Uma constante sempre será static pois ela não precisa de nenhuma
    //instancia para ser referenciada, e final pois o valor nunca será mudado
    public static final String SISTEMA_OPERACIONAL = "SO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //método que irá recarregar o conteúdo do Primeiro fragmento
        replaceFragments(R.id.container2, new PrimeiroFragment());
    }

    @Override
    public void envioDadosSistemaOperacional(SistemaOperacional so) {
        //criação do bundle
        Bundle bundle = new Bundle();

        //Inserindo para o bundle a chave que é a nossa constante, e o objeto
        //Sempre que você quiser mandar um objeto para uma activity ou fragmento usa-se o putParcelable
        bundle.putParcelable(SISTEMA_OPERACIONAL, so);

        //Criando a instancia do segundo fragmento
        Fragment segundoFragmento = new SegundoFragment();

        //inseriondo através do setArguments os dados que serão enviados junto com o segundo fragmento
        segundoFragmento.setArguments(bundle);

        //chamada do método que irá recarregar o segundo fragmento no container 1 da activity
        replaceFragments(R.id.container1, segundoFragmento);
    }

    //Método que faz o replace do fragmento recebendo o id do container que será recarregado, e o fragmento
    private void replaceFragments(int container, Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }
}
