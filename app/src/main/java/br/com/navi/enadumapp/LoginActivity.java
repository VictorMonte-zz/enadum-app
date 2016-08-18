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
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.navi.enadumapp.Helpers.LoginHelper;
import br.com.navi.enadumapp.Model.Aluno;
import br.com.navi.enadumapp.Model.Instituicao;
import br.com.navi.enadumapp.Requests.LoginRequest;

public class LoginActivity extends AppCompatActivity {

    private LoginHelper helper;
    private static String ENADUM_PREFS = "ENADUM_PREFS";
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
                final SharedPreferences sharedpreferences = getSharedPreferences(ENADUM_PREFS, Context.MODE_PRIVATE);

                //Obter dados do aluno
                aluno = helper.obterAluno();

                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonResponse = null;
                        try {
                            jsonResponse = new JSONObject(response);
                            boolean sucesso = jsonResponse.getBoolean("sucesso");

                            //TODO: Verificar com o Cassio o que o WS vai retornar em caso de sucesso

                            //TODO: Colocar dados em Sessão
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putString("rm", aluno.getRm());
                            editor.putString("cpf", aluno.getCpf());
                            editor.putString("instuicao", aluno.getInstituicao());
                            editor.apply();

                            if (sucesso) {
                                // Acessar área restrita do Enadum
                                Intent intentIrAreaRestrita = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(intentIrAreaRestrita);

                            }
                            else{
                                // Construtor de Mensagem
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage(jsonResponse.getString("mensagem"))
                                        .setCancelable(false)
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener(){

                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.cancel();
                                            }
                                        });

                                //Mensagem
                                AlertDialog alert = builder.create();
                                alert.setTitle("Enadum Informa");
                                alert.show();

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
