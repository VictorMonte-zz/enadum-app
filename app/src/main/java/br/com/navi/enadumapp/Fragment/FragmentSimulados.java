package br.com.navi.enadumapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.HashMap;
import java.util.List;

import br.com.navi.enadumapp.Adapter.ExpandableListSimuladosAdapter;
import br.com.navi.enadumapp.Controller.SimuladoController;
import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.Request.SimuladoRequest;
import br.com.navi.enadumapp.Utils.SessionRepository;
import br.com.navi.enadumapp.models.Aluno;
import br.com.navi.enadumapp.models.Curso;
import br.com.navi.enadumapp.models.SimuladoEnade;

/**
 * Created by Victor Monte on 17/08/2016.
 */
public class FragmentSimulados extends Fragment {

    private SimuladoController controller;

    private Aluno aluno;
    private List<Curso> listDataHeader;
    private HashMap<Curso, List<SimuladoEnade>> listDataChild;

    private ExpandableListView elvSimulados;
    private ExpandableListSimuladosAdapter listAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        controller = new SimuladoController(getActivity());

        View layoutSimulados = inflater.inflate(R.layout.fragment_simulados,container,false);

        elvSimulados = (ExpandableListView) layoutSimulados.findViewById(R.id.elvSimulados);

        listDataHeader = SessionRepository.aluno.getCursos();

        listDataChild = new HashMap<Curso, List<SimuladoEnade>>();
        for(Curso curso : SessionRepository.aluno.getCursos()) {
            listDataChild.put(curso, curso.getCursoMEC().getSimuladosEnade());
        }

        listAdapter = new ExpandableListSimuladosAdapter(getActivity(), listDataHeader, listDataChild);

        elvSimulados.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Curso curso  = (Curso) elvSimulados.getItemAtPosition(groupPosition);

                controller.obterSimulado(curso.getCursoMEC().getSimuladosEnade().get(childPosition).getId());

                return false;
            }
        });

        // setting list adapter
        elvSimulados.setAdapter(listAdapter);

        return layoutSimulados;
    }

}
