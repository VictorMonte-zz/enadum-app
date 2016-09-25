package br.com.navi.enadumapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo on 20/09/2016.
 */

public class ResultadoEnade {

    @SerializedName("id")
    private Integer id;

    @SerializedName("respostas")
    private List<Resposta> respostas = new LinkedList<Resposta>();

    public Integer getId() {
        return id;
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
}
