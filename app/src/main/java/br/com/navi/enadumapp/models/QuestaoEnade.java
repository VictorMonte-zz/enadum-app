package br.com.navi.enadumapp.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Danilo on 17/09/2016.
 */
public class QuestaoEnade extends Questao{

    @SerializedName("cursoMec")
    private CursoMEC cursoMec;

    public CursoMEC getCursoMec() {
        return cursoMec;
    }

    public void setCursoMec(CursoMEC cursoMec) {
        this.cursoMec = cursoMec;
    }

}
