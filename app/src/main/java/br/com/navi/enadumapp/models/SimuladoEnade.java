package br.com.navi.enadumapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Danilo on 17/09/2016.
 */
public class SimuladoEnade {

    @SerializedName("titulo")
    private String titulo;

    @SerializedName("id")
    private Integer id;

    @SerializedName("questoes")
    private List<QuestaoEnade> questoes = new LinkedList<QuestaoEnade>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<QuestaoEnade> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<QuestaoEnade> questoes) {
        this.questoes = questoes;
    }

    public QuestaoEnade getQuestao(int posicao) {
        return this.questoes.get(posicao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
