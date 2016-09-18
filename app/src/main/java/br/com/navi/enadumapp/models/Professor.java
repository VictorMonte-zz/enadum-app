package br.com.navi.enadumapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo on 17/09/2016.
 */
public class Professor {

    @SerializedName("id")
    private Integer id;

    @SerializedName("nome")
    private String nome;

    @SerializedName("usuario")
    private Usuario usuario;

    @SerializedName("disciplinas")
    private List<Disciplina> disciplinas = new LinkedList<Disciplina>();

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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
