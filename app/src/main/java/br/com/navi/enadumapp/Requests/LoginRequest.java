package br.com.navi.enadumapp.Requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Victor Monte on 06/08/2016.
 */
public class LoginRequest extends StringRequest {
    private static final String URL = "";
    private Map<String,String> params;

    public LoginRequest(String rm, String cpf, String instituicao, Response.Listener<String> listener){
        super(Method.POST, URL, listener, null);
        params = new HashMap<>();
        params.put("rm", rm);
        params.put("cpf", cpf);
        params.put("instituicao", instituicao);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
