package br.com.navi.enadumapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import br.com.navi.enadumapp.Controller.LoginController;
import br.com.navi.enadumapp.Controller.SimuladoController;
import br.com.navi.enadumapp.Fragment.FragmentQuestaoEnade;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.DTO.AlunoDTO;
import br.com.navi.enadumapp.models.DTO.RespostaDTO;
import br.com.navi.enadumapp.models.DTO.SimuladoDTO;
import br.com.navi.enadumapp.models.Resposta;
import br.com.navi.enadumapp.models.SimuladoEnade;

public class SimuladoEnadeFinalActivity extends AppCompatActivity {

    private TextView nomeSimuladoEnade;
    private Chronometer cronometro;
    private SimuladoEnade simulado;
    private Button btnNext;
    private ListView listaDeRespostas;
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
        setContentView(R.layout.activity_simulado_final);

        this.simulado = SessionRepository.simulado;
        this.nomeSimuladoEnade = (TextView) findViewById(R.id.simulado_curso_final);
        this.cronometro = (Chronometer) findViewById(R.id.chronometer3);


    }
}
