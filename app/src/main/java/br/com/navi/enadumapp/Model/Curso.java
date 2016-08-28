package br.com.navi.enadumapp.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danilo on 27/08/2016.
 */
public class Curso implements Serializable {

    private String nome;
    private Long id;
    private List<Turma> turmas = new ArrayList<Turma>();

    public Curso(String nome, Long id){
        this.id = id;
        this.nome = nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
