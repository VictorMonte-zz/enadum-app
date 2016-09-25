package br.com.navi.enadumapp.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.models.Resposta;
import br.com.navi.enadumapp.models.ResultadoEnade;

/**
 * Created by Danilo on 25/09/2016.
 */

public class ExpandableListResultadosEnadeAdapter extends BaseExpandableListAdapter{

    private Context _context;
    private List<ResultadoEnade> _listDataHeader;
    private HashMap<ResultadoEnade, List<Resposta>> _listDataChild;

    public ExpandableListResultadosEnadeAdapter(Context context, List<ResultadoEnade> listDataHeader,
                                                HashMap<ResultadoEnade, List<Resposta>> listDataChild) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listDataChild;
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

        final Resposta resposta = (Resposta) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_resultados, null);
        }

        CheckBox cbCorreta = (CheckBox) convertView
                .findViewById(R.id.cbQuestaoResultado);

        cbCorreta.setChecked(resposta.isCorreta());
        cbCorreta.setText(resposta.getSenteca());
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

        ResultadoEnade resultadoEnade = (ResultadoEnade) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.header_resultados, null);
        }

        TextView lblDisciplina = (TextView) convertView
                .findViewById(R.id.lblSimulado);
        TextView lblPontuacao = (TextView) convertView
                .findViewById(R.id.lblPontuacao);

        lblDisciplina.setTypeface(null, Typeface.NORMAL);
        lblDisciplina.setText(resultadoEnade.getId().toString());


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
