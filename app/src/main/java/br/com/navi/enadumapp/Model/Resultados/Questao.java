package br.com.navi.enadumapp.Model.Resultados;

/**
 * Created by Victor Monte on 20/08/2016.
 */
public class Questao {
    private String conteudo;
    private boolean correta;

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
}
