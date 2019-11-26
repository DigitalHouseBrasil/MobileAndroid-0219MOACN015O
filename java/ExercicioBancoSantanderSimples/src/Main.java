public class Main {

    public static void main(String[] args){
        Cliente cliente1 = new Cliente("João", "Camargo");
        Cliente cliente2 = new Cliente("Jessica", "Milena");

        Conta conta1 = new Conta(155, 0.0, cliente1);
        Conta conta2 = new Conta(255, 0.0, cliente2);

        conta1.depositar(100);
        conta1.saque(50);
        conta1.consultarDados(conta1);

        conta2.depositar(200);
        conta2.consultarDados(conta2);
        conta2.saque(250);

    }
}
;