package br.com.navi.enadumapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ResponseCache;
import java.util.LinkedList;
import java.util.List;

import br.com.navi.enadumapp.Controller.LoginController;
import br.com.navi.enadumapp.Controller.SimuladoController;
import br.com.navi.enadumapp.Fragment.FragmentLoading;
import br.com.navi.enadumapp.Fragment.FragmentQuestaoEnade;
import br.com.navi.enadumapp.Request.ResultadoRequest;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.DTO.AlunoDTO;
import br.com.navi.enadumapp.models.DTO.RespostaDTO;
import br.com.navi.enadumapp.models.DTO.SimuladoDTO;
import br.com.navi.enadumapp.models.Resposta;
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
    private ResultadoRequest resultadoRequest;
    private SimuladoDTO simuladoDTO;
    private AlunoDTO alunoDTO;
    private List<RespostaDTO> respostasDTO;
    private List<Resposta> respostas = new LinkedList<Resposta>();
    FragmentQuestaoEnade fragmentQuestaoEnade;
    SimuladoController simuladoController = new SimuladoController(this);
    LoginController loginController = new LoginController(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulado_enade);

        this.simulado = SessionRepository.simulado;

        this.curso = (TextView) findViewById(R.id.simulado_curso);
        this.cronometro = (Chronometer) findViewById(R.id.chronometer2);
        this.btnNext = (Button) findViewById(R.id.simulado_btn_next);
//        this.btnPrev = (Button) findViewById(R.id.simulado_btn_previous);

        this.curso.setText(simulado.getTitulo());
        this.cronometro.start();

        simuladoDTO = new SimuladoDTO();
        simuladoDTO.setId(simulado.getId());
        alunoDTO = new AlunoDTO();
        alunoDTO.setId(SessionRepository.aluno.getId());
        simuladoDTO.setAlunoDTO(alunoDTO);
        respostasDTO = new LinkedList<RespostaDTO>();

        moveQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (posicao == simulado.getQuestoes().size() - 1){
                    fragmentQuestaoEnade.onDestroyView();
                    Log.d("Teste", "depois do destroi");

                    cronometro.stop();
                    btnNext.setVisibility(View.INVISIBLE);

                    for(Resposta resposta : respostas){
                        RespostaDTO respostaDTO = new RespostaDTO();
                        respostaDTO.setId((int)(long)resposta.getId());
                        respostasDTO.add(respostaDTO);
                    }

                    simuladoDTO.setRespostasDTO(respostasDTO);
                    SessionRepository.simuladoDTO = simuladoDTO;

                    simuladoController.finnishSimulado(simuladoDTO);

                    callLoading();

                    posicao = 0;

                    loginController.login(SessionRepository.loginRequest);

                    Toast.makeText(SimuladoEnadeActivity.this,"Final do Simulado", Toast.LENGTH_SHORT).show();
                } else {
                    posicao += 1;
                    moveQuestion();
                }
            }
        });



//        btnPrev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                RespostaDTO respostaDTO = new RespostaDTO();
//                respostaDTO.setId(fragmentQuestaoEnade.getId()) ;
//                if (respostaDTO.getId() != null){
//                    respostasDTO.add(respostaDTO);
//                }
//                if (posicao == 0){
//                    Toast.makeText(SimuladoEnadeActivity.this,"Deseja sair do simulado",Toast.LENGTH_SHORT).show();
//                } else {
//                    posicao -= 1;
//                    moveQuestion();
//                }
//            }
//        });
    }



    private void callLoading() {
        FragmentLoading fragmentLoading = new FragmentLoading();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmento, fragmentLoading);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void moveQuestion() {
        fragmentQuestaoEnade = new FragmentQuestaoEnade();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmento,fragmentQuestaoEnade);
        transaction.addToBackStack(null);
        transaction.commit();
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

    @Override
    public void onBackPressed() {
    }
}
