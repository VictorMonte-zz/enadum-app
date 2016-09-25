package br.com.navi.enadumapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.HashMap;
import java.util.List;

import br.com.navi.enadumapp.Adapter.ExpandableListResultadosEnadeAdapter;
import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.Resposta;
import br.com.navi.enadumapp.models.ResultadoEnade;
import br.com.navi.enadumapp.models.SimuladoEnade;

/**
 * Created by Danilo on 25/09/2016.
 */

public class FragmentResultadosEnade extends Fragment {

    ExpandableListResultadosEnadeAdapter listAdapter;
    ExpandableListView expListView;
    List<ResultadoEnade> listDataHeader;
    HashMap<ResultadoEnade, List<Resposta>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resultados, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        expListView = (ExpandableListView) getView().findViewById(R.id.elvResultados);

        listDataHeader = SessionRepository.aluno.getResultadosEnade();

//        List<ResultadoEnade> resultadosEnade = SessionRepository.aluno.getResultadosEnade();
//        for(ResultadoEnade resultado : resultadosEnade){
//            Log.d("teste", resultado.getId().toString());
//        }
        listDataChild = new HashMap<ResultadoEnade, List<Resposta>>();
        for(ResultadoEnade resultadoEnade : SessionRepository.aluno.getResultadosEnade()){
            listDataChild.put(resultadoEnade, resultadoEnade.getRespostas());
        }
        listAdapter = new ExpandableListResultadosEnadeAdapter(getActivity(), listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
    }
}
