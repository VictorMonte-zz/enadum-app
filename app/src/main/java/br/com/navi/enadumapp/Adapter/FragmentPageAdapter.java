package br.com.navi.enadumapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import br.com.navi.enadumapp.Fragment.FragmentRanking;
import br.com.navi.enadumapp.Fragment.FragmentResultadosEnade;
import br.com.navi.enadumapp.Fragment.FragmentSimulados;

/**
 * Created by Victor Monte on 17/08/2016.
 */
public class FragmentPageAdapter extends FragmentPagerAdapter {

    private String[] mTabTitles;

    public FragmentPageAdapter(FragmentManager manager, String[] mTabTitles){
        super(manager);
        this.mTabTitles = mTabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentSimulados();
            case 1:
                return new FragmentResultadosEnade();
            case 2:
                return new FragmentRanking();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.mTabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.mTabTitles[position];
    }
}
