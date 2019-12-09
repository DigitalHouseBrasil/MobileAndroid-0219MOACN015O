public class Aula {
    private Materia materia;
    private int horarioInicio;
    private int horarioTermino;


    public Aula(Materia materia, int horarioInicio, int horarioTermino) {
        this.materia = materia;
        this.horarioInicio = horarioInicio;
        this.horarioTermino = horarioTermino;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(int horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public int getHorarioTermino() {
        return horarioTermino;
    }

    public void setHorarioTermino(int horarioTermino) {
        this.horarioTermino = horarioTermino;
    }
}
