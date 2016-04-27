package com.apps.contenidos.raalzate.airtravel.views;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.apps.contenidos.raalzate.airtravel.R;



/**
 * Created by MyMac on 26/04/16.
 */
public class QueryServiceView extends ServiceView implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    public QueryServiceView(LayoutInflater inflater, ViewGroup container, FragmentManager fragmentManager) {
        super(R.layout.fragment_query_for_time, inflater, container, fragmentManager);
        initViews();


    }

    private void initViews() {
        tabLayout = (TabLayout)view.findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addTab(tabLayout.newTab().setText("Horarios de vuelos"));
        tabLayout.addTab(tabLayout.newTab().setText("Tarifas de vuelos"));
        tabLayout.addTab(tabLayout.newTab().setText("Estado del vuelos"));

        viewPager = (ViewPager)view.findViewById(R.id.pager);
        adapter = new PagerAdapter(fragmentManager, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {
                return new TabQueryTimeFragment();
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }
}
