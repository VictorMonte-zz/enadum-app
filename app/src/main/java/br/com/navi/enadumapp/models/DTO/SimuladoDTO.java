package br.com.navi.enadumapp.models.DTO;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Danilo on 19/09/2016.
 */

public class SimuladoDTO {

    @SerializedName("id")
    private Integer id;

    @SerializedName("aluno")
    private AlunoDTO alunoDTO;

    @SerializedName("respostas")
    private List<RespostaDTO> respostasDTO = new LinkedList<RespostaDTO>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
