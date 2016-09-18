package br.com.navi.enadumapp.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.navi.enadumapp.Model.Simulado;
import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.SimuladoActivity;
import br.com.navi.enadumapp.models.Questao;
import br.com.navi.enadumapp.models.QuestaoEnade;
import br.com.navi.enadumapp.models.Resposta;
import br.com.navi.enadumapp.models.SimuladoEnade;

/**
 * Created by Danilo on 11/09/2016.
 */
public class FragmentQuestao extends Fragment {

    private QuestaoEnade questaoEnade;
    private TextView enunciado;
    private ListView listaDeRespostas;
    private List<Resposta> respostas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questao,container, false);

        this.listaDeRespostas = (ListView) view.findViewById(R.id.questao_lista_de_respostas);
        this.enunciado = (TextView) view.findViewById(R.id.questao_enunciado);

        SimuladoActivity activity = (SimuladoActivity) getActivity();
        SimuladoEnade simuladoEnade = activity.getSimulado();

        this.questaoEnade = simuladoEnade.getQuestao(activity.getPosicao());
        this.enunciado.setText(questaoEnade.getEnunciado());
        this.respostas = questaoEnade.getRespostas();

        ArrayAdapter<Resposta> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_single_choice, respostas);
        this.listaDeRespostas.setAdapter(adapter);

        return view;
    }
}
