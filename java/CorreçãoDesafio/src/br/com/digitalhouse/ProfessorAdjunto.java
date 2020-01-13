package br.com.digitalhouse;

public class ProfessorAdjunto extends Professor{
    //Attributes
    private Integer horasMonitoria;

    //Constructor
    public ProfessorAdjunto(String nome, String sobrenome, Integer codigoProfessor,Integer horasMonitoria) {
        super(nome, sobrenome, codigoProfessor);
        this.horasMonitoria = horasMonitoria;
    }

    //Getters and Setters
    public Integer getHorasMonitoria() {
        return horasMonitoria;
    }

    public void setHorasMonitoria(Integer horasMonitoria) {
        this.horasMonitoria = horasMonitoria;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public String getSobrenome() {
        return super.getSobrenome();
    }

    @Override
    public void setSobrenome(String sobrenome) {
        super.setSobrenome(sobrenome);
    }

    @Override
    public Integer getTempoDeCasa() {
        return super.getTempoDeCasa();
    }

    @Override
    public void setTempoDeCasa(Integer tempoDeCasa) {
        super.setTempoDeCasa(tempoDeCasa);
    }

    @Override
    public Integer getCodigoProfessor() {
        return super.getCodigoProfessor();
    }

    @Override
    public void setCodigoProfessor(Integer codigoProfessor) {
        super.setCodigoProfessor(codigoProfessor);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
