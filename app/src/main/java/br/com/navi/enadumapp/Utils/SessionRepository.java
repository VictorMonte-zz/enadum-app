package br.com.navi.enadumapp.Utils;



import java.util.List;

import br.com.navi.enadumapp.Request.LoginRequest;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.DTO.SimuladoDTO;
import br.com.navi.enadumapp.models.SimuladoEnade;

/**
 * Created by Victor Monte on 19/08/2016.
 */
public class SessionRepository {
    public static Aluno aluno = null;
    public static SimuladoEnade simulado = null;
    public static SimuladoDTO simuladoDTO = null;
    public static LoginRequest loginRequest = null;
}
