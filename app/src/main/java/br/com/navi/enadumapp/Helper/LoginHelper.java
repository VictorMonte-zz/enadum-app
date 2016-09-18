package br.com.navi.enadumapp.Helper;

import android.app.Activity;
import android.widget.EditText;
import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.Request.LoginRequest;

/**
 * Created by Victor Monte on 06/08/2016.
 */
public class LoginHelper {

    private final EditText campoRM;
    private final EditText campoCPF;

    public LoginHelper(Activity activity){
        campoRM = (EditText)activity.findViewById(R.id.txtRM);
        campoCPF = (EditText)activity.findViewById(R.id.txtCPF);
    }

    public LoginRequest obterLoginRequest(){
        return new LoginRequest(
                campoRM.getText().toString(),
                campoCPF.getText().toString()
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

}
