package br.com.navi.enadumapp.Controller;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import br.com.navi.enadumapp.Fragment.FragmentSimulados;
import br.com.navi.enadumapp.HomeActivity;
import br.com.navi.enadumapp.SimuladoEnadeActivity;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.API.HttpAPI;
import br.com.navi.enadumapp.models.API.ServiceGenerator;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.DTO.SimuladoDTO;
import br.com.navi.enadumapp.models.SimuladoEnade;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pichau on 25/09/2016.
 */

public class SimuladoController {

    FragmentSimulados fragment;
    Context context;

    public SimuladoController(Context context) { this.context = context; }

    public void obterSimulado(int id)
    {
        final ProgressDialog mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        HttpAPI api = ServiceGenerator.createService(HttpAPI.class);
        Call<SimuladoEnade> call = api.getSimuladoEnade(id);
        call.enqueue(new Callback<SimuladoEnade>() {
            @Override
            public void onResponse(Call<SimuladoEnade> call, Response<SimuladoEnade> response) {
                if(response.isSuccessful())
                {

                    Log.d("logLevel", response.body().getTitulo());
                    SessionRepository.simulado = response.body();
                    context.startActivity(new Intent(context, SimuladoEnadeActivity.class));

                    if (mProgressDialog.isShowing())
                    {
                        mProgressDialog.dismiss();
                    }
                }
                else
                {
                    Log.d("Status", "message: " + response.message());
                    Log.d("Status", "body: " + response.errorBody());
                    Log.d("Status", "raw: " + response.raw());
                    Log.d("Status", "Response NOT OK");

                    if (mProgressDialog.isShowing()){
                        mProgressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<SimuladoEnade> call, Throwable t) {
                Log.d("Status", "FAIL: " + t.getMessage());

                if (mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                }
            }
        });

    }

    public void finnishSimulado(SimuladoDTO simuladoDTO){

        Log.d("logLevel", "called simuladoController");
        final ProgressDialog mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setCancelable(false);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        HttpAPI api = ServiceGenerator.createService(HttpAPI.class);
        Call<Aluno> call = api.postResultado(simuladoDTO);
        call.enqueue(new Callback<Aluno>() {

            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                Log.d("LogLevel", "onResponse is called");
                Log.d("Status", "OK");
                if (response.isSuccessful()) {
                    Log.d("Status", "Response raw(): " + response.raw());
                    Log.d("Status", "Response body(): " + response.body());

                    if (mProgressDialog.isShowing()){
                        mProgressDialog.dismiss();
                    }

                } else {
                    Log.d("Status", "message: " + response.message());
                    Log.d("Status", "body: " + response.errorBody());
                    Log.d("Status", "raw: " + response.raw());
                    Log.d("Status", "Response NOT OK");

                    if (mProgressDialog.isShowing()){
                        mProgressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                Log.d("Status", "FAIL: " + t.getMessage());

                if (mProgressDialog.isShowing()){
                    mProgressDialog.dismiss();
                }
            }

        });
    }

}
