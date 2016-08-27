package br.com.navi.enadumapp.Model.Resultados;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Victor Monte on 20/08/2016.
 */
public class Disciplina {
    private String nome;
    private String pontuacao;
    private Long id;
    private List<Questao> questoes = new ArrayList<Questao>();

    public  Disciplina(){}

    public  Disciplina(String nome, String pontuacao){
        this.setNome(nome);
        this.setPontuacao(pontuacao);
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public String getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(String pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
