import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(0, "Karol", "Saraiva");
        Aluno aluno2 = new Aluno(1, "Adelania", "Sousa");
        Aluno aluno3 = new Aluno(2, "Jimmy", "Apara");
        Aluno aluno4 = new Aluno(3, "Camile", "Roberta");
        Aluno aluno5 = new Aluno(4, "Guilherme", "Santos");

        List<Aluno> listaAlunos = new ArrayList<>();
        listaAlunos.add(aluno1);
        listaAlunos.add(aluno2);
        listaAlunos.add(aluno3);
        listaAlunos.add(aluno4);
        listaAlunos.add(aluno5);

        Professor professor = new Professor("João", "324151");

        Materia materia1 = new Materia("Orientação a Objeto");
        Materia materia2 = new Materia("Interface");
        Materia materia3 = new Materia("GITHUB");

        Aula aula1 = new Aula(materia1, 19, 22);
        Aula aula2 = new Aula(materia2, 19, 22);
        Aula aula3 = new Aula(materia3, 19, 22);

        List<Aula> aulas = new ArrayList<>();
        aulas.add(aula1);
        aulas.add(aula2);
        aulas.add(aula3);

        Curso curso = new Curso("Mobile Android", aulas, listaAlunos, professor);

        Turma turma = new Turma("Turma05MobileAndroid", curso);

        professor.chamadaDosAlunos(listaAlunos, 0);
        professor.darAulas();
        aluno1.assistirAula();
        aluno1.fazendoLicao();
        System.out.println("--------------------------------------------------------------------------------------------");
        //FIM DA RESOLUÇÃO 1
        turma.getCurso().getProfessor().chamadaDosAlunos(listaAlunos, 0);
        turma.getCurso().getProfessor().chamadaDosAlunos(listaAlunos, 1);
        turma.getCurso().getProfessor().chamadaDosAlunos(listaAlunos, 2);
        turma.getCurso().getProfessor().chamadaDosAlunos(listaAlunos, 3);
        turma.getCurso().getProfessor().chamadaDosAlunos(listaAlunos, 4);
        turma.getCurso().getProfessor().darAulas();
        for (int i = 0; i < turma.getCurso().getListaAlunos().size(); i++) {
            turma.getCurso().getListaAlunos().get(i).assistirAula();
            turma.getCurso().getListaAlunos().get(i).fazendoLicao();
        }
        //FIM RESOLUÇÃO 2
    }
}
