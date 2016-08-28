package br.com.navi.enadumapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.navi.enadumapp.Model.Questao;
import br.com.navi.enadumapp.Model.Resposta;
import br.com.navi.enadumapp.R;

/**
 * Created by Danilo on 28/08/2016.
 */
public class FragmentQuestao extends Fragment {

    private Questao questao;
    private TextView enunciado;
    private ListView listaDeSentencas;
    private List<Resposta> respostas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup conteiner, Bundle savedInstanceState) {

        View layoutQuestao = inflater.inflate(R.layout.fragment_questao, conteiner, false);

        if (getArguments() != null){
            this.questao = (Questao) getArguments().getSerializable("questao");
        }
        buscaComponentes(layoutQuestao);
        populaCamposComDados(questao);

        return layoutQuestao;
    }

    private void buscaComponentes(View layout){
        this.enunciado = (TextView) layout.findViewById(R.id.questao_enunciado);
        this.listaDeSentencas = (ListView) layout.findViewById(R.id.questao_sentecas_list);
    }

    public void populaCamposComDados(Questao questao){
        if(questao != null){
            this.enunciado.setText(questao.getEnunciado());

            this.respostas = questao.getAnswers();
            ArrayAdapter<Resposta> adapter = new ArrayAdapter<Resposta>(getActivity(),android.R.layout.simple_list_item_single_choice,respostas);
            listaDeSentencas.setAdapter(adapter);
        }
    }
}
