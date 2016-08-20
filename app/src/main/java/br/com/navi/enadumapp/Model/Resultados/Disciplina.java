package br.com.navi.enadumapp.Model.Resultados;

/**
 * Created by Victor Monte on 20/08/2016.
 */
public class Disciplina {
    private String nome;
    private String pontuacao;

    public  Disciplina(){}

    public  Disciplina(String nome, String pontuacao){
        this.setNome(nome);
        this.setPontuacao(pontuacao);
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
}
