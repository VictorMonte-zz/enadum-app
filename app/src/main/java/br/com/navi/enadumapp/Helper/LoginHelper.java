package br.com.navi.enadumapp.Helper;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Spinner;

import br.com.navi.enadumapp.Model.Aluno;
import br.com.navi.enadumapp.R;

/**
 * Created by Victor Monte on 06/08/2016.
 */
public class LoginHelper {

    private final EditText campoRM;
    private final EditText campoCPF;
    private final Spinner campoInstituicao;

    public LoginHelper(Activity activity){
        campoRM = (EditText)activity.findViewById(R.id.txtRM);
        campoCPF = (EditText)activity.findViewById(R.id.txtCPF);
        campoInstituicao =(Spinner) activity.findViewById(R.id.spinner);
    }

    public Aluno obterAluno(){
        return new Aluno(
                campoRM.getText().toString(),
                campoCPF.getText().toString(),
                campoInstituicao.getSelectedItem().toString()
        );
    }
}
