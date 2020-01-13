package br.com.digitalhouse;

import java.util.Objects;

public abstract class Professor {
    //Attributes
    private String nome;
    private String sobrenome;
    private Integer tempoDeCasa;
    private Integer codigoProfessor;

    //Constructor
    public Professor(String nome, String sobrenome, Integer codigoProfessor) {
        setNome(nome);
        setSobrenome(sobrenome);

        setCodigoProfessor(codigoProfessor);
    }

    //Getters and Setters
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

    public Integer getTempoDeCasa() {
        return tempoDeCasa;
    }

    public void setTempoDeCasa(Integer tempoDeCasa) {
        this.tempoDeCasa = tempoDeCasa;
    }

    public Integer getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(Integer codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(getNome(), professor.getNome()) &&
                Objects.equals(getSobrenome(), professor.getSobrenome()) &&
                Objects.equals(getTempoDeCasa(), professor.getTempoDeCasa()) &&
                Objects.equals(getCodigoProfessor(), professor.getCodigoProfessor());
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", tempoDeCasa=" + tempoDeCasa +
                ", codigoProfessor=" + codigoProfessor +
                '}';
    }
}


