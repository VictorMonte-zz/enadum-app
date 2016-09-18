package br.com.navi.enadumapp.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import br.com.navi.enadumapp.Controller.LoginController;
import br.com.navi.enadumapp.LoginActivity;
import br.com.navi.enadumapp.Request.LoginRequest;
import br.com.navi.enadumapp.models.Aluno;

/**
 * Created by Danilo on 18/09/2016.
 */

public class EnviaUsuarioTask extends AsyncTask<Object, Object, Aluno>{

    private Context context;
    private LoginRequest loginRequest;
    private ProgressDialog progress;
    private LoginController controller = new LoginController(context);

    public EnviaUsuarioTask(Context context, LoginRequest loginRequest) {
        this.context = context;
        this.loginRequest = loginRequest;
    }

    @Override
    protected Aluno doInBackground(Object... params) {
        getAluno(loginRequest);
        return null;
    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(context, "Aguarde...",
                "Envio de dados para a web", true, true);
    }

    @Override
    protected void onPostExecute(Aluno aluno) {
        progress.dismiss();
    }

    void getAluno(LoginRequest loginRequest){
        controller.login(loginRequest);
    }
}
