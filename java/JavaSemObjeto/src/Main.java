public class Main {
    public static void main(String[] args){
        //criando variavel inteira
        int numeroA = 10;

        //criando uma variavel double
        double numeroB = 1.0;

        //printando no console a variavel numeroA
        System.out.println(numeroA);

        //criando uma variavel booleana
        boolean bool = false;

        //utilizando o metodo somarDoisNumeros e printando o resultado
        System.out.println(somarDoisNumeros(10, 5));

    }

    //criando um metodo que soma dois numeros
    public static int somarDoisNumeros(int numeroA, int numeroB){
        return numeroA + numeroB;
    }

}
