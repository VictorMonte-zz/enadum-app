package br.com.navi.enadumapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import br.com.navi.enadumapp.Model.Simulado;
import br.com.navi.enadumapp.Utils.SessionRepository;

public class SimuladoActivity extends AppCompatActivity {

    private TextView materia;
    private TextView fonte;
    private Chronometer cronometro;
    private Simulado simulado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulado);

        this.simulado = SessionRepository.simulado;

        this.materia = (TextView) findViewById(R.id.simulado_materia);
        this.fonte = (TextView) findViewById(R.id.simulado_fonte);
        this.cronometro = (Chronometer) findViewById(R.id.simulado_timer);

        this.materia.setText(simulado.getDisciplina().getNome());
        this.fonte.setText("Enade");
        this.cronometro.start();

    }

}
