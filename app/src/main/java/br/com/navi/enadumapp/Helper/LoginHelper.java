package br.com.navi.enadumapp.Helper;

import android.app.Activity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.navi.enadumapp.LoginActivity;
import br.com.navi.enadumapp.Model.Aluno;
import br.com.navi.enadumapp.Model.Instituicao;
import br.com.navi.enadumapp.R;

/**
 * Created by Victor Monte on 06/08/2016.
 */
public class LoginHelper {

    private final EditText campoRM;
    private final EditText campoCPF;
    private final Spinner campoInstituicao;
    private RequestQueue requestQueue;

    public LoginHelper(Activity activity){
        campoRM = (EditText)activity.findViewById(R.id.txtRM);
        campoCPF = (EditText)activity.findViewById(R.id.txtCPF);
        campoInstituicao =(Spinner) activity.findViewById(R.id.spinner);
    }

    public Aluno obterAluno(){
        return new Aluno(
                campoRM.getText().toString(),
                campoCPF.getText().toString(),
                campoInstituicao.getSelectedItem().toString()
        );
    }

    public boolean temRM() {
        return !campoRM.getText().toString().isEmpty();
    }


    public void mostraErroRM() {
        campoRM.setError("empty");
    }

    public boolean temCPF() {
        return !campoCPF.getText().toString().isEmpty();
    }

    public void mostraErroCPF() {
        campoCPF.setError("empty");
    }

    public List<Instituicao> LoadInstituicoes(Activity activity){

        final List<Instituicao> instituicoes = new ArrayList<Instituicao>();

        requestQueue = Volley.newRequestQueue(activity);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "", (JSONObject) null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("instituicoes");

                            for (int i = 0;i < jsonArray.length(); i++){
                                Instituicao instituicao = new Instituicao();
                                JSONObject inst = jsonArray.getJSONObject(i);

                                String id = inst.getString("id");
                                instituicao.setId(Integer.parseInt(id));

                                String nome = inst.getString("nome");
                                instituicao.setNome(nome);

                                instituicoes.add(instituicao);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("VOLLEY","LoadInstituicoes Error");
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);

        return instituicoes;
    }
}
