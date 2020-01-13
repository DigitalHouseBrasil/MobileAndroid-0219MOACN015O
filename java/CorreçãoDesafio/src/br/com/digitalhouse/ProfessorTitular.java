package br.com.digitalhouse;

import java.util.Objects;

public class ProfessorTitular extends Professor {
    //Attributos
    private String especialidade;

    //Constructor
    public ProfessorTitular(String nome, String sobrenome, Integer codigoProfessor, String especialidade) {
        super(nome, sobrenome, codigoProfessor);
        this.especialidade = especialidade;
    }

    //Getters and Setters
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProfessorTitular)) return false;
        if (!super.equals(o)) return false;
        ProfessorTitular that = (ProfessorTitular) o;
        return Objects.equals(getEspecialidade(), that.getEspecialidade());
    }

    @Override
    public String toString() {
        return "ProfessorTitular{" +
                "especialidade='" + especialidade + '\'' +
                '}';
    }


}
