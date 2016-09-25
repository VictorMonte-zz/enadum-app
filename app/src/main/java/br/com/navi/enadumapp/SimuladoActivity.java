package br.com.navi.enadumapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.List;

import br.com.navi.enadumapp.Fragment.FragmentQuestaoEnade;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.Resposta;
import br.com.navi.enadumapp.models.SimuladoEnade;

public class SimuladoActivity extends AppCompatActivity {

    private TextView materia;
    private TextView fonte;
    private Chronometer cronometro;
    private SimuladoEnade simulado;
    private Button btnNext;
    private Button btnPrev;
    private static int posicao;
    private List<Resposta>  respostas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulado);

        this.simulado = SessionRepository.simulado;

        this.materia = (TextView) findViewById(R.id.simulado_materia);
        this.fonte = (TextView) findViewById(R.id.simulado_fonte);
        this.cronometro = (Chronometer) findViewById(R.id.simulado_timer);
        this.btnNext = (Button) findViewById(R.id.questao_button_proxima);
        this.btnPrev = (Button) findViewById(R.id.questao_button_anterior);

        this.materia.setText(simulado.getTitulo());
        this.fonte.setText("Enade");
        this.cronometro.start();

        FragmentQuestaoEnade fragmentQuestaoEnade = new FragmentQuestaoEnade();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.questoes,fragmentQuestaoEnade);
        transaction.addToBackStack(null);
        transaction.commit();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posicao += 1;
                FragmentQuestaoEnade fragmentQuestaoEnade = new FragmentQuestaoEnade();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.questoes,fragmentQuestaoEnade);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

//        btnPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                posicao -= 1;
//                FragmentQuestaoEnade fragmentQuestaoEnade = new FragmentQuestaoEnade();
//
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.questoes,fragmentQuestaoEnade);
//                transaction.addToBackStack(null);
//                transaction.commit();
//            }
//        });


    }

    public SimuladoEnade getSimulado(){
        return this.simulado;
    }

    public int getPosicao(){
        return this.posicao;
    }

    public void addResposta(Resposta resposta){
        this.respostas.add(resposta);
    }


}
