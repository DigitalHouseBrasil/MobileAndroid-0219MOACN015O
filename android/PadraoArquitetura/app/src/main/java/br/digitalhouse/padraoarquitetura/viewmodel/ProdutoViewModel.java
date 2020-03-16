package br.digitalhouse.padraoarquitetura.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import br.digitalhouse.padraoarquitetura.model.Produto;
import br.digitalhouse.padraoarquitetura.repository.ProdutoRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

//Diferença entre ViewModel e AndroidViewModel:
// ViewModel nao retorna contexto
//AndroidViewModel te da acesso a um contexto
public class ProdutoViewModel extends AndroidViewModel {

    //instancia da classe repository
    private ProdutoRepository repository = new ProdutoRepository();

    //atributo do tipo MutableLiveData que é uma lista de produtos
    //Lembrando que o MutableLiveData é para escrita e leitura de valores
    private MutableLiveData<List<Produto>> mutableProduto = new MutableLiveData<>();

    //atributo do tipo LiveData que é uma lista de produtos
    //Lembrando que o LiveData é apenas para leitura de valores
    public LiveData<List<Produto>> liveDataProduto = mutableProduto;

    //atributo do tipo CompositeDisposable para gerenciamento das threads
    private CompositeDisposable disposable = new CompositeDisposable();

    private MutableLiveData<String> errorMutable = new MutableLiveData<>();
    public LiveData<String> erro = errorMutable;

    public ProdutoViewModel(@NonNull Application application) {
        super(application);
    }

    //Método que pega todos os itens do banco de dados
    public void getTodosProdutos() {
        //Adicionamos a ação ao disposable
        disposable.add(
                //fazemos a chamada do repository para fazer a ação de consulta do banco de dados
                repository.getAllProdutos(getApplication().getApplicationContext())
                        //determina em qual thread acontecerá a emissão de dados
                        .subscribeOn(Schedulers.newThread())
                        //determina em qual thread irá voltar apos a emissao de dados
                        .observeOn(AndroidSchedulers.mainThread())
                        //Observer o que irá acontecer após o recebimento dos dados
                        .subscribe(produtos -> {
                                    //Em caso de sucesso passamos a lista de produtos emitida para o mutableProduto
                                    mutableProduto.setValue(produtos);
                                },
                                //em caso de erro atribuimos a mensagem da exceção em uma variavel
                                //que será exibida na view
                                throwable -> {
                                    errorMutable.setValue(throwable.getMessage());
                                })
        );
    }

    //método que insere um produto no bd
    public void insereProduto(Produto produto, Context context) {
        //iniciamos uma nova thread
        new Thread((() -> {
            if (produto != null) {
                //fazemos a chamada do repository para fazer a ação de insert do banco de dados
                repository.insereProduto(produto, context);
            }
        }
        )).start();
    }

    //método que apaga um produto no bd
    public void apagaProduto(String nome) {
        new Thread(() -> {
            if (!nome.isEmpty()) {
                //fazemos a chamada do repository para fazer uma consulta que retorna um objeto do tipo Produto
                Produto produto = repository.retornaProdutoPorNome(nome, getApplication().getApplicationContext());
                if (produto != null) {
                    //fazemos a chamada do repository para fazer a ação de delete do banco de dados
                    repository.apagaProduto(produto, getApplication().getApplicationContext());
                }
            }
        }).start();
    }

    public void recuperaProdutosArquivo() {
        disposable.add(
                repository.getProdutosDoArquivo(getApplication())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(produtoResult ->
                                        mutableProduto.setValue(produtoResult.getProdutos()),
                                throwable -> {
                                    errorMutable.setValue(throwable.getMessage());
                                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        //limpamos o disposable apos o uso
        disposable.clear();
    }
}
