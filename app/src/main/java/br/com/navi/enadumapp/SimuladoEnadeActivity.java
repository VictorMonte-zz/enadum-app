package br.com.navi.enadumapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import br.com.navi.enadumapp.Fragment.FragmentQuestaoEnade;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.SimuladoEnade;

/**
 * Created by Danilo on 18/09/2016.
 */

public class SimuladoEnadeActivity extends AppCompatActivity {

    private TextView curso;
    private Chronometer cronometro;
    private SimuladoEnade simulado;
    private Button btnNext;
    private Button btnPrev;
    private static int posicao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulado_enade);

        this.simulado = SessionRepository.simulado;
        this.curso = (TextView) findViewById(R.id.simulado_curso);
        this.cronometro = (Chronometer) findViewById(R.id.chronometer2);
        this.btnNext = (Button) findViewById(R.id.simulado_btn_next);
        this.btnPrev = (Button) findViewById(R.id.simulado_btn_previous);

        this.curso.setText(simulado.getTitulo());
        this.cronometro.start();

        FragmentQuestaoEnade fragmentQuestaoEnade = new FragmentQuestaoEnade();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmento,fragmentQuestaoEnade);
        transaction.addToBackStack(null);
        transaction.commit();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posicao += 1;
                FragmentQuestaoEnade fragmentQuestaoEnade = new FragmentQuestaoEnade();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmento,fragmentQuestaoEnade);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posicao -= 1;
                FragmentQuestaoEnade fragmentQuestaoEnade = new FragmentQuestaoEnade();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmento,fragmentQuestaoEnade);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    public SimuladoEnade getSimulado(){
        return this.simulado;
    }

    public int getPosicao(){
        return this.posicao;
    }
}
