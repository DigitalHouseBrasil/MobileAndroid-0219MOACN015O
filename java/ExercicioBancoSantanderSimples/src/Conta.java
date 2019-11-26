public class Conta {

    private int numeroDaConta;
    private double saldo;
    private Cliente titular;

    public void depositar(double valor){
        saldo = saldo + valor;
        System.out.println("Valor depositado com sucesso, saldo Atual: " + saldo);
    }

    public double saque(double valor){
        if(saldo >= valor){
            double saldoAtualizado = saldo - valor;
            System.out.println("Saque realizado com sucesso, valor retirado: " + valor);
            return saldoAtualizado;
        } else {
            System.out.println("Saldo insuficiente");
            return saldo;
        }
    }

    public void consultarDados(Conta conta){
        System.out.println("----------------------- Dados da conta --------------------------------------");
        System.out.println( "Numero da conta: " + conta.numeroDaConta);
        System.out.println("Titular da conta: " + conta.titular.getNome());
        System.out.println("Saldo atual: " + conta.saldo);
    }

    public Conta(int numeroDaConta, double saldo, Cliente titular) {
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
        this.titular = titular;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }


}
