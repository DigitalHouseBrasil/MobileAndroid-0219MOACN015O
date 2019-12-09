public class Cliente extends Pessoa {

    private int codigo;

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Código do cliente: " + codigo);
    }

}
