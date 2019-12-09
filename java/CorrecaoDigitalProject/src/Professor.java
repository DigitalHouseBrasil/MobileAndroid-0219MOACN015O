import java.util.List;

public class Professor {
    private String nome;
    private String RD;

    public void darAulas(){
        System.out.println("Dando aula " + this.nome);
    }

    public void chamadaDosAlunos(List<Aluno> listAlunos, int registroAluno1){
        for (int i = 0; i < listAlunos.size(); i++) {
            if(listAlunos.get(i).getRA() == registroAluno1){
                System.out.println("O aluno está presente: " + listAlunos.get(i).getNome());
            }
        }

    }

    public Professor(String nome, String RD) {
        this.nome = nome;
        this.RD = RD;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRD() {
        return RD;
    }

    public void setRD(String RD) {
        this.RD = RD;
    }
}
