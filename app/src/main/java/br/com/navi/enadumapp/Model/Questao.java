package br.com.navi.enadumapp.Model;

import java.util.ArrayList;

/**
 * Created by Victor Monte on 20/08/2016.
 */
public class Questao {
    private String enunciado;
    private boolean correta;
    private Long id;
    private ArrayList<Resposta> respostas = new ArrayList<Resposta>();

    public Questao(){}

    public Questao(String enunciado, boolean correta){
        this.setEnunciado(enunciado);
        this.setCorreta(correta);
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public ArrayList<Resposta> getAnswers(){
        return respostas;
    }

    public void setAnswers(ArrayList<Resposta> answers){
        this.respostas = answers;
    }
}
