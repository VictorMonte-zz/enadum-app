package br.com.navi.enadumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.navi.enadumapp.Helpers.LoginHelper;
import br.com.navi.enadumapp.Model.Aluno;

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

                //Valida
                if (aluno.getRm().equals("123"))
                {
                    //Logar
                    Intent intentAcessarRestrito = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intentAcessarRestrito);
                }
                else
                {
                    //Falha
                    Toast.makeText(LoginActivity.this, "RM ou CPF inválidos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
