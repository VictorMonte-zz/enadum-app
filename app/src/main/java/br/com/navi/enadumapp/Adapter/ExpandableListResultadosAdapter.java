package br.com.navi.enadumapp.Adapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;



import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.models.Disciplina;
import br.com.navi.enadumapp.models.Questao;

public class ExpandableListResultadosAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<Disciplina> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<Disciplina, List<Questao>> _listDataChild;

    public ExpandableListResultadosAdapter(Context context, List<Disciplina> listDataHeader,
                                           HashMap<Disciplina, List<Questao>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final Questao questao = (Questao) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_resultados, null);
        }

        CheckBox cbCorreta = (CheckBox) convertView
                .findViewById(R.id.cbQuestaoResultado);

        cbCorreta.setText(questao.getEnunciado());
        cbCorreta.setEnabled(false);

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        Disciplina disciplina = (Disciplina) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.header_resultados, null);
        }

        TextView lblDisciplina = (TextView) convertView
                .findViewById(R.id.lblDisciplina);
        TextView lblPontuacao = (TextView) convertView
                .findViewById(R.id.lblPontuacao);

        lblDisciplina.setTypeface(null, Typeface.NORMAL);
        lblDisciplina.setText(disciplina.getNome());


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}