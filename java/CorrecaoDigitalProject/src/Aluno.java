public class Aluno {
    private int RA;
    private String nome;
    private String sobrenome;


    public void assistirAula(){
        System.out.println("Assistindo Aula " + this.nome);
    }

    public void fazendoLicao(){
        System.out.println("Fazendo lição " + this.nome);
    }

    public Aluno(int RA, String nome, String sobrenome) {
        this.RA = RA;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public int getRA() {
        return RA;
    }

    public void setRA(int RA) {
        this.RA = RA;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
