package br.com.navi.enadumapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.navi.enadumapp.Helper.LoginHelper;
import br.com.navi.enadumapp.Model.Aluno;
import br.com.navi.enadumapp.Model.Instituicao;
import br.com.navi.enadumapp.Request.LoginRequest;
import br.com.navi.enadumapp.Utils.AlertManager;
import br.com.navi.enadumapp.Utils.SessionRepository;

public class LoginActivity extends AppCompatActivity {

    private LoginHelper helper;
    private Aluno aluno;
    private List<Instituicao> instituicoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //TODO: habilitar a linha abaixo quando o servico que fornece as instituicoes estiver pronto
        //this.loadSpinner();

        Button btnLogar = (Button) findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                helper = new LoginHelper(LoginActivity.this);

                //Obter dados do aluno
                aluno = helper.obterAluno();

                //---------------------------------------
                //--USUARIO MOCK (ABAIXO APENAS PARA TESTE)
                //---------------------------------------
                aluno.setNome("Victor Monte");
                aluno.setCurso("Sistemas de Informação");
                aluno.setInstituicao("FIAP");
                SessionRepository.aluno = aluno;
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                //---------------------------------------
                //--NÃO FUNCIONA SEM O ENDPOINT DO WS
                //---------------------------------------
                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonResponse = null;
                        try {
                            jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");

                            //TODO: Verificar com o Cassio o que o WS vai retornar em caso de sucesso

                            //TODO: Obter dados de retorno do ws e colocar em sessao
                            //aluno.setNome();
                            //aluno.setCurso();
                            SessionRepository.aluno = aluno;

                            if (sucesso) {
                                // Acessar área restrita do Enadum
                                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                            }
                            else{
                                AlertManager.Alertar(LoginActivity.this, "Usuário ou senha inválido", null);
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

    private void loadSpinner() {

        instituicoes = helper.LoadInstituicoes(LoginActivity.this);

        List<String> spinnerArray = new ArrayList<String>();
        for (Instituicao instituicao : instituicoes){
            spinnerArray.add(instituicao.getNome());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        //teste
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);
    }
}
