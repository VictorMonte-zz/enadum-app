package br.com.navi.enadumapp.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import br.com.navi.enadumapp.R;
import br.com.navi.enadumapp.models.Curso;
import br.com.navi.enadumapp.models.SimuladoEnade;

/**
 * Created by Victor on 18/09/2016.
 */
public class ExpandableListSimuladosAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<Curso> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<Curso, List<SimuladoEnade>> _listDataChild;

    public ExpandableListSimuladosAdapter(Context context, List<Curso> listDataHeader,
                                           HashMap<Curso, List<SimuladoEnade>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public int getGroupCount() {
        return _listDataHeader.size();
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
    public Object getChild(int groupPosition, int childPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        Curso curso = (Curso) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.header_simulados, null);
        }

        TextView lblCurso = (TextView) convertView
                .findViewById(R.id.lblCurso_Simulado);

        lblCurso.setTypeface(null, Typeface.NORMAL);
        lblCurso.setText(curso.getNome());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final SimuladoEnade simulado = (SimuladoEnade) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.item_simulados, null);
        }

        TextView lblSimuladoEnade = (TextView) convertView
                .findViewById(R.id.lblSimuladoEnade);

        lblSimuladoEnade.setText(simulado.getTitulo());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
