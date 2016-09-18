package br.com.navi.enadumapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Danilo on 17/09/2016.
 */
public class Questao {

    @SerializedName("id")
    private Integer id;

    @SerializedName("enunciado")
    private String enunciado;

    @SerializedName("respostas")
    private List<Resposta> respostas = new LinkedList<Resposta>();

    @SerializedName("respostaCorreta")
    private String respostaCorreta;

    public Integer getId() {
        return id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
}
