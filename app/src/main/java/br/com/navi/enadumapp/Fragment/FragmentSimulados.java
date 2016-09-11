package br.com.navi.enadumapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.navi.enadumapp.Model.Disciplina;
import br.com.navi.enadumapp.Model.Questao;
import br.com.navi.enadumapp.Model.Resposta;
import br.com.navi.enadumapp.Model.Simulado;
import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.SimuladoActivity;
import br.com.navi.enadumapp.Utils.SessionRepository;

/**
 * Created by Victor Monte on 17/08/2016.
 */
public class FragmentSimulados extends Fragment {

    private ListView listViewDisciplinas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layoutSimulados = inflater.inflate(R.layout.fragment_simulados,container,false);

        this.listViewDisciplinas = (ListView) layoutSimulados.findViewById(R.id.lista_simulados_listview);


        //ToDO:Quando tiver conexao com um servidor apagar as linha de baixo e ativar a chamada do metodo que faz a
        // requisicao de todas as disciplinas
        Disciplina disciplina1 = new Disciplina("Banco de Dados I",new Long(1));
        Disciplina disciplina2 = new Disciplina("Tecnicas de Programacao I", new Long(2));
        Disciplina disciplina3 = new Disciplina("Sistemas de Informacao", new Long(3));

        List<Disciplina> disciplinas = Arrays.asList(disciplina1,disciplina2, disciplina3);

        this.listViewDisciplinas.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, disciplinas));

        this.listViewDisciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Disciplina selecionada  = (Disciplina) adapterView.getItemAtPosition(i);

                SessionRepository.simulado = gerarSimulado(selecionada);
                Intent fazerSimulado  = new Intent(getActivity(), SimuladoActivity.class);
                startActivity(fazerSimulado);

                //Toast.makeText(getActivity(), "Disciplina selecionada: " +  selecionada, Toast.LENGTH_SHORT).show();
            }
        });

        return layoutSimulados;
    }

    public Simulado gerarSimulado(Disciplina disciplina){

        Simulado simulado = new Simulado();

        simulado.setDisciplina(disciplina);
        simulado.setEnadeOuProfessor("Enade");
        simulado.setId((long) 1);

        for (int i = 0; i < 3; i ++){
            Questao questao = new Questao();

            questao.setEnunciado("Enunciado " + disciplina.getNome() + " " + i);
            questao.setId((long) i);

            for (int j = 0; j < 5; j++){
                Resposta resposta = new Resposta();
                resposta.setId((long) j);

                resposta.setSenteca("Resposta do enum " + i + " numero " + j);
                if (j<4) {
                    resposta.setCorreta(false);
                }else{
                    resposta.setCorreta(true);
                }

                questao.addResposta(resposta);
                Log.v("Fragment Simulado", "Resposta criada e adicionada" + i);
            }

            simulado.addQuestao(questao);

        }

        return simulado;
    }
}
