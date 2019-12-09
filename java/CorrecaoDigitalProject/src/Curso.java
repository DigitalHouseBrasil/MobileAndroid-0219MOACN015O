import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private List<Aula> conjuntoDeAulas;
    private List<Aluno> listaAlunos;
    private Professor professor;

    public Curso(String nome, List<Aula> conjuntoDeAulas, List<Aluno> listaAlunos, Professor professor) {
        this.nome = nome;
        this.conjuntoDeAulas = conjuntoDeAulas;
        this.listaAlunos = listaAlunos;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aula> getConjuntoDeAulas() {
        return conjuntoDeAulas;
    }

    public void setConjuntoDeAulas(List<Aula> conjuntoDeAulas) {
        this.conjuntoDeAulas = conjuntoDeAulas;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}