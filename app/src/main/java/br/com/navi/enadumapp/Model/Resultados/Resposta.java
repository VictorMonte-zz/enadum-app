package br.com.navi.enadumapp.Model.Resultados;

import java.io.Serializable;

/**
 * Created by Danilo on 27/08/2016.
 */
public class Resposta implements Serializable{

    private Long id;
    private String conteudo;
    private boolean correta;

    public Resposta(){
    }

    public Resposta(String conteudo, boolean correta) {
        this.conteudo = conteudo;
        this.correta = correta;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.conteudo;
    }
}
