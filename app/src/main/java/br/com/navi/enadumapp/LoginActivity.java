package br.com.navi.enadumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.navi.enadumapp.Helpers.LoginHelper;
import br.com.navi.enadumapp.Model.Aluno;
import br.com.navi.enadumapp.Requests.LoginRequest;

public class LoginActivity extends AppCompatActivity {

    private LoginHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogar = (Button) findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                helper = new LoginHelper(LoginActivity.this);

                //Obter dados do aluno
                Aluno aluno = helper.obterAluno();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonResponse = null;
                        try {
                            jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");

                            //TODO: Verificar com o Cassio o que o WS vai retornar em caso de sucesso
                            //TODO: Colocar dados em Sessão

                            // Acessar área restrita do Enadum
                            Intent intentIrAreaRestrita = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intentIrAreaRestrita);

                            if (sucesso) {
                                //TODO: Alerta de Erro
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                };

                LoginRequest loginRequest = new LoginRequest(
                        aluno.getRm(),
                        aluno.getCpf(),
                        aluno.getInstituicao(),
                        responseListener
                        );

            }
        });
    }
}
