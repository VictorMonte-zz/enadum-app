package br.com.navi.enadumapp.Request;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

import br.com.navi.enadumapp.models.DTO.AlunoDTO;
import br.com.navi.enadumapp.models.DTO.RespostaDTO;
import br.com.navi.enadumapp.models.DTO.SimuladoDTO;

/**
 * Created by Danilo on 19/09/2016.
 */

public class ResultadoRequest {

    @SerializedName("simulado")
    private SimuladoDTO simulado;

    @SerializedName("aluno")
    private AlunoDTO aluno;

    @SerializedName("respostas")
    private List<RespostaDTO> respostas = new LinkedList<RespostaDTO>();

    public SimuladoDTO getSimulado() {
        return simulado;
    }

    public void setSimulado(SimuladoDTO simulado) {
        this.simulado = simulado;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public List<RespostaDTO> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaDTO> respostas) {
        this.respostas = respostas;
    }
}
