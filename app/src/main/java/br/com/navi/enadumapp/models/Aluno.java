package br.com.navi.enadumapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo on 17/09/2016.
 */

public class Aluno {

    @SerializedName("id")
    private Integer id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("usuario")
    private Usuario usuario = new Usuario();

    @SerializedName("instituicao")
    private Instituicao instituicao = new Instituicao();

    @SerializedName("cursos")
    List<Curso> cursos = new LinkedList<Curso>();

    @SerializedName("simuladosEnade")
    List<SimuladoEnade> simuladosEnade = new LinkedList<SimuladoEnade>();

    @SerializedName("experiencia")
    private Double experiencia;

    @SerializedName("resultadosEnade")
    private List<ResultadoEnade> resultadosEnade = new LinkedList<ResultadoEnade>();

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<SimuladoEnade> getSimuladosEnade() {
        return simuladosEnade;
    }

    public void setSimuladosEnade(List<SimuladoEnade> simuladosEnade) {
        this.simuladosEnade = simuladosEnade;
    }

    public Double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Double experiencia) {
        this.experiencia = experiencia;
    }

    public List<ResultadoEnade> getResultadosEnade() {
        return resultadosEnade;
    }

    public void setResultadosEnade(List<ResultadoEnade> resultadosEnade) {
        this.resultadosEnade = resultadosEnade;
    }
}
