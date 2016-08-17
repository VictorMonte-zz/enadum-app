package br.com.navi.enadumapp.Model;

/**
 * Created by Victor Monte on 06/08/2016.
 */
public class Aluno {
    private String rm;
    private String cpf;
    private String instituicao;

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getRm() {
        return rm;
    }

    public void setRm(String rm) {
        this.rm = rm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Aluno(String rm, String cpf, String instituicao){
        setRm(rm);
        setCpf(cpf);
        setInstituicao(instituicao);
    }
}
