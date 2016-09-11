package br.com.navi.enadumapp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danilo on 28/08/2016.
 */
public class Simulado implements Serializable{

    private Disciplina disciplina;
    private Double pontos;
    private Long id;
    private String enadeOuProfessor;
    private ArrayList<Questao> questoes = new ArrayList<Questao>();

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(ArrayList<Questao> questoes) {
        this.questoes = questoes;
    }

    public Double getPontos() {
        return pontos;
    }

    public void setPontos(Double pontos) {
        this.pontos = pontos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnadeOuProfessor() {
        return enadeOuProfessor;
    }

    public void setEnadeOuProfessor(String enadeOuProfessor) {
        this.enadeOuProfessor = enadeOuProfessor;
    }

    public void addQuestao (Questao questao){
        questoes.add(questao);
    }
}
