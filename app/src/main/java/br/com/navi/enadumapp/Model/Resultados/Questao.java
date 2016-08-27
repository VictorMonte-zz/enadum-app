package br.com.navi.enadumapp.Model.Resultados;

import java.util.ArrayList;

/**
 * Created by Victor Monte on 20/08/2016.
 */
public class Questao {
    private String conteudo;
    private boolean correta;
    private Long id;
    private ArrayList<Resposta> respostas = new ArrayList<Resposta>();

    public Questao(){}

    public Questao(String conteudo, boolean correta){
        this.setConteudo(conteudo);
        this.setCorreta(correta);
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
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
