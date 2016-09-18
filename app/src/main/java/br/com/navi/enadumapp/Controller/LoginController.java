package br.com.navi.enadumapp.Controller;

import android.util.Log;

import br.com.navi.enadumapp.LoginActivity;
import br.com.navi.enadumapp.models.API.HttpAPI;
import br.com.navi.enadumapp.models.API.ServiceGenerator;
import br.com.navi.enadumapp.Request.LoginRequest;
import br.com.navi.enadumapp.models.Aluno;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Danilo on 17/09/2016.
 */

public class LoginController {

    LoginActivity activity;

    public LoginController(LoginActivity activity){
        this.activity = activity;
    }

    public void login(LoginRequest loginRequest){
        Log.d("logLevel", "called loginController");

        HttpAPI api = ServiceGenerator.createService(HttpAPI.class);
        Call<Aluno> call = api.getAluno(loginRequest);
        call.enqueue(new Callback<Aluno>() {

            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                Log.d("LogLevel", "onResponse is called");
                Log.d("Status", "OK");
                if (response.isSuccessful()) {
                    Log.d("Status", "Response: " + response.raw());
                    Log.d("Status", "Response: " + response.body());
                    activity.setUpAluno(response.body());
                } else {
                    Log.d("Status", "" + response.message());
                    Log.d("Status", "" + response.errorBody());
                    Log.d("Status", "" + response.raw());
                    Log.d("Status", "Response NOT OK");
                }
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                Log.d("Status", "FAIL: " + t.getMessage());
            }
        });
    }

}
