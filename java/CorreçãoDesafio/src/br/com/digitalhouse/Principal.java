package br.com.digitalhouse;

public class Principal {
    public static void main(String[] args) {
        DigitalHouseManager digitalHouseManager = new DigitalHouseManager();
        digitalHouseManager.registrarProfessorTitular("Jessica", "Milena", 14, "Skatetista");
        digitalHouseManager.registrarProfessorAdjunto("João Felipe", "Camargo", 22, 8);

        digitalHouseManager.registrarCurso("Full Stack", 20001, 3);
        digitalHouseManager.registrarCurso("Android", 20002, 2);

        digitalHouseManager.alocarProfessores(20001, 14, 22);

        digitalHouseManager.registrarAluno("Naruto", "Uzumaki", 1);
        digitalHouseManager.registrarAluno("Sakura", "Haruno", 2);

        digitalHouseManager.matricularAluno(1, 20002);
        digitalHouseManager.matricularAluno(2, 20002);

        digitalHouseManager.excluirCurso(20001);
        digitalHouseManager.excluirProfessor(14);
    }
}

