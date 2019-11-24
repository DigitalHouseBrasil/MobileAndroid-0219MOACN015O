import java.util.ArrayList;
import java.util.List;

public class PrimeirosCemPositivos {

    public static void main(String[] args) {

        List<Integer> listaNumeros = new ArrayList<>();

        for (int i =0; i<  100; i++){
            listaNumeros.add(i);
        }

        listaDePrimeirosCemPositivos(listaNumeros);
    }
    public static List<Integer> listaDePrimeirosCemPositivos(List<Integer> listaNumeros){
        for (int i = 0; i < listaNumeros.size(); i++ ){
            if(i%2 ==0){
                System.out.println(listaNumeros.get(i));
            }
        }
        return listaNumeros;
    }
}
