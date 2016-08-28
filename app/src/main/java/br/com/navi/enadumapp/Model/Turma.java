package br.com.navi.enadumapp.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danilo on 27/08/2016.
 */
public class Turma {

    private Long id;
    private String name;
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Disciplina> getDisciplinas(){ return disciplinas; }

    public int getDisciplinasCount(){ return disciplinas.size(); }
}
