package br.com.navi.enadumapp.Model;

import java.io.Serializable;

/**
 * Created by Danilo on 27/08/2016.
 */
public class Resposta implements Serializable{

    private Long id;
    private String senteca;
    private boolean correta;

    public Resposta(){
    }

    public Resposta(String senteca, boolean correta) {
        this.senteca = senteca;
        this.correta = correta;
    }

    public String getSenteca() {
        return senteca;
    }

    public void setSenteca(String senteca) {
        this.senteca = senteca;
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
        return this.senteca;
    }
}
