package br.com.navi.enadumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import br.com.navi.enadumapp.Controller.LoginController;
import br.com.navi.enadumapp.Helper.LoginHelper;
import br.com.navi.enadumapp.Request.LoginRequest;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.Aluno;

public class LoginActivity extends AppCompatActivity {

    LoginController controller = new LoginController(this);

    private LoginHelper helper;
    private LoginRequest loginRequest;
    private Aluno aluno = new Aluno();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogar = (Button) findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                helper = new LoginHelper(LoginActivity.this);

                loginRequest = helper.obterLoginRequest();
                getAluno(loginRequest);
                SessionRepository.aluno = aluno;
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }

    void getAluno(LoginRequest loginRequest){
        controller.login(loginRequest);
    }

    public void setUpAluno(Aluno aluno){
        this.aluno = aluno;
    }
}
