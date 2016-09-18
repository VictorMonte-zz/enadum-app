package br.com.navi.enadumapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Danilo on 17/09/2016.
 */
public class Curso {

    @SerializedName("id")
    private Integer id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("cursoMEC")
    private CursoMEC cursoMEC;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CursoMEC getCursoMEC() {
        return cursoMEC;
    }

    public void setCursoMEC(CursoMEC cursoMEC) {
        this.cursoMEC = cursoMEC;
    }

}
