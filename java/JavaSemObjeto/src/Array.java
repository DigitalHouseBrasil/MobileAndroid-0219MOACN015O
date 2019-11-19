import java.util.ArrayList;
import java.util.List;

public class Array {

    //criando uma lista e adicionando um item a ela
    public static void main(String[] args){
        List<String> textos = new ArrayList<>();
        String texto = "Hello, World";
        textos.add(texto);
        System.out.println(textos.get(0));

    }
}
