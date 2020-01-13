package br.com.digitalhouse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Curso {

    //Attributes
    private String nomeCurso;
    private Integer codigoCurso;
    private Professor professorTitular;
    private ProfessorAdjunto professorAdjunto;
    private Integer quantidadeMaximaDeAlunos;
    private List<Aluno> alunosMatriculados = new ArrayList<>(40);

    public Curso(String nomeCurso, Integer codigoCurso, Integer quantidadeMaximaDeAlunos) {
        this.nomeCurso = nomeCurso;
        this.codigoCurso = codigoCurso;
        this.quantidadeMaximaDeAlunos=quantidadeMaximaDeAlunos;
    }

    public Curso(Integer codigoCurso, Integer codigo) {
    }

    //Methods
    public boolean adicionarUmAluno(Aluno umAluno) {
        for (Aluno aluno : alunosMatriculados) {
            if ((!aluno.equals(umAluno)) && (quantidadeMaximaDeAlunos <= 40)) {
                return true;
            }
        }
        return false;
    }

    public void excluirAluno(Aluno umAluno) {
        for (Aluno aluno : alunosMatriculados) {
            if (aluno.equals(umAluno)) {
                alunosMatriculados.remove(umAluno);
                System.out.println("Aluno " + umAluno.getNome() + umAluno.getSobrenome() +
                        " removido do curso " + getNomeCurso() + " com sucesso");
            } else {
                System.out.println("Aluno não encontrado");
            }
        }
    }

    //Getters and setter
    public Professor getProfessorTitular() {
        return professorTitular;
    }

    public void setProfessorTitular(ProfessorTitular professorTitular) {
        this.professorTitular = professorTitular;
    }

    public ProfessorAdjunto getProfessorAdjunto() {
        return professorAdjunto;
    }

    public void setProfessorAdjunto(ProfessorAdjunto professorAdjunto) {
        this.professorAdjunto = professorAdjunto;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso)) return false;
        Curso curso = (Curso) o;
        return Objects.equals(getNomeCurso(), curso.getNomeCurso()) &&
                Objects.equals(getCodigoCurso(), curso.getCodigoCurso());
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nomeCurso='" + nomeCurso + '\'' +
                ", codigoCurso=" + codigoCurso +
                '}';
    }

}
