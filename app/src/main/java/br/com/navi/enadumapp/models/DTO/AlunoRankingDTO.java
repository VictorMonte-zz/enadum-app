package br.com.navi.enadumapp.models.DTO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Danilo on 03/10/2016.
 */

public class AlunoRankingDTO {

    @SerializedName("nome")
    private String nome;

    @SerializedName("exp")
    private Double experiencia;

    @SerializedName("instituicao")
    private String instituicao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Double experiencia) {
        this.experiencia = experiencia;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
