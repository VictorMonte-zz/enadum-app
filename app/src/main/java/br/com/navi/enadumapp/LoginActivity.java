package br.com.navi.enadumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import br.com.navi.enadumapp.Controller.LoginController;
import br.com.navi.enadumapp.Helper.LoginHelper;
import br.com.navi.enadumapp.Request.LoginRequest;

public class LoginActivity extends AppCompatActivity {

    LoginController controller = new LoginController(this);

    private LoginHelper helper;
    private LoginRequest loginRequest;

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
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            }
        });
    }

    void getAluno(LoginRequest loginRequest){
        controller.login(loginRequest);
    }

}
