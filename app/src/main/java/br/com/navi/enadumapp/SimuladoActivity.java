package br.com.navi.enadumapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.com.navi.enadumapp.Model.Simulado;

/**
 * Created by Danilo on 28/08/2016.
 */
public class SimuladoActivity extends AppCompatActivity {

    private Simulado simulado;
    private TextView nomeDaDisiplina;
    private TextView enadeOuProfessor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulado);

        Intent intent = this.getIntent();
        this.simulado = (Simulado) intent.getSerializableExtra("simulado");

        this.nomeDaDisiplina = (TextView) findViewById(R.id.simulado_nome_da_disciplina);
        this.enadeOuProfessor = (TextView) findViewById(R.id.simulado_enade_ou_professor);

        nomeDaDisiplina.setText(simulado.getDisciplina().getNome());
        enadeOuProfessor.setText(simulado.getEnadeOuProfessor());
    }
}
