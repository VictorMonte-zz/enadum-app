package br.com.navi.enadumapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.navi.enadumapp.Adapter.ExpandableListResultadosAdapter;
import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.models.Disciplina;
import br.com.navi.enadumapp.models.Questao;

/**
 * Created by Pichau on 17/08/2016.
 */
public class FragmentResultados extends Fragment {

    ExpandableListResultadosAdapter listAdapter;
    ExpandableListView expListView;
    List<Disciplina> listDataHeader;
    HashMap<Disciplina, List<Questao>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resultados, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // get the listview
        expListView = (ExpandableListView) getView().findViewById(R.id.elvResultados);

        // preparing list data
//        gerarMockQuestoesDisciplinas();

        //listAdapter = new ExpandableListResultadosAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        //expListView.setAdapter(listAdapter);

    }

    /*
         * Preparing the list data
         */
//    private void gerarMockQuestoesDisciplinas() {
//        listDataHeader = new ArrayList<Disciplina>();
//        listDataChild = new HashMap<Disciplina, List<Questao>>();
//
//        // Adding child data
//        listDataHeader.add(new Disciplina("Gestão de Projetos", "2/5"));
//        listDataHeader.add(new Disciplina("Inteligencia Empresarial", "4/5"));
//        listDataHeader.add(new Disciplina("Banco de Dados III", "1/5"));
//
//        // Adding child data
//        List<Questao> mock1 = new ArrayList<Questao>();
//        mock1.add(new Questao("Questao 1", true));
//        mock1.add(new Questao("Questao 2", true));
//        mock1.add(new Questao("Questao 3", false));
//        mock1.add(new Questao("Questao 4", false));
//        mock1.add(new Questao("Questao 5", false));
//
//
//        List<Questao> mock2 = new ArrayList<Questao>();
//        mock2.add(new Questao("Questao 1", true));
//        mock2.add(new Questao("Questao 2", true));
//        mock2.add(new Questao("Questao 3", true));
//        mock2.add(new Questao("Questao 4", true));
//        mock2.add(new Questao("Questao 5", false));
//
//        List<Questao> mock3 = new ArrayList<Questao>();
//        mock3.add(new Questao("Questao 1", true));
//        mock3.add(new Questao("Questao 2", false));
//        mock3.add(new Questao("Questao 3", false));
//        mock3.add(new Questao("Questao 4", false));
//        mock3.add(new Questao("Questao 5", false));
//
//        listDataChild.put(listDataHeader.get(0), mock1); // Header, Child data
//        listDataChild.put(listDataHeader.get(1), mock2);
//        listDataChild.put(listDataHeader.get(2), mock3);
//    }
}
