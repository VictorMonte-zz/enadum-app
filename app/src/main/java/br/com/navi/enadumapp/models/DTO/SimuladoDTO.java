package br.com.navi.enadumapp.models.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo on 19/09/2016.
 */

public class SimuladoDTO {

    @SerializedName("simulado")
    private SimuladoDTO2 simulado;

    @SerializedName("aluno")
    private AlunoDTO alunoDTO;

    @SerializedName("respostas")
    private List<RespostaDTO> respostasDTO = new LinkedList<RespostaDTO>();

    @SerializedName("tempo")
    private int tempo;

    public SimuladoDTO2 getSimulado() {
        return simulado;
    }

    public void setSimulado(SimuladoDTO2 simulado) {
        this.simulado = simulado;
    }

    public AlunoDTO getAlunoDTO() {
        return alunoDTO;
    }

    public void setAlunoDTO(AlunoDTO alunoDTO) {
        this.alunoDTO = alunoDTO;
    }

    public List<RespostaDTO> getRespostasDTO() {
        return respostasDTO;
    }

    public void setRespostasDTO(List<RespostaDTO> respostasDTO) {
        this.respostasDTO = respostasDTO;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}
