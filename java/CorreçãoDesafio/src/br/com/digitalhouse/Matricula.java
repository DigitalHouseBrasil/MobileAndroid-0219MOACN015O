package br.com.digitalhouse;

import java.util.Date;
import java.util.Objects;
import java.util.PrimitiveIterator;

public class Matricula {
    //Attributes
    private Aluno aluno;
    private Curso curso;
    private Date dataDoDia;

    //Constructor
    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getDataDoDia() {
        return dataDoDia;
    }

    public void setDataDoDia(Date dataDoDia) {
        this.dataDoDia = dataDoDia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matricula)) return false;
        Matricula matricula = (Matricula) o;
        return Objects.equals(getAluno(), matricula.getAluno()) &&
                Objects.equals(getCurso(), matricula.getCurso()) &&
                Objects.equals(getDataDoDia(), matricula.getDataDoDia());
    }

    @Override
    public String toString() {
        return "Matricula{" +
                "aluno=" + aluno +
                ", curso=" + curso +
                ", dataDoDia=" + dataDoDia +
                '}';
    }
}
