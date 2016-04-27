package com.apps.contenidos.raalzate.airtravel.views;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.apps.contenidos.raalzate.airtravel.R;
import com.apps.contenidos.raalzate.airtravel.presenters.QueryServiceViewPresenter;
import com.apps.contenidos.raalzate.airtravel.views.fragments.TabQueryTimeFragment;
import com.apps.contenidos.raalzate.airtravel.views.interfaces.IQueryServiceView;

import java.util.ArrayList;


/**
 * Created by MyMac on 26/04/16.
 */
public class QueryServiceView extends ServiceView implements IQueryServiceView, TabLayout.OnTabSelectedListener{

    private QueryServiceViewPresenter queryServiceViewPresenter;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter adapter;

    public QueryServiceView(LayoutInflater inflater, ViewGroup container, FragmentManager fragmentManager) {
        super(R.layout.fragment_query_for_time, inflater, container, fragmentManager);
        queryServiceViewPresenter = new QueryServiceViewPresenter(this);
        initViews();
    }

    @Override
    public void addTab(String title, Fragment fragment){
        tabLayout.addTab(tabLayout.newTab().setText(title));
        adapter.addFragment(fragment);
        adapter.notifyDataSetChanged();
    }

    private void initViews() {
        tabLayout = (TabLayout)view.findViewById(R.id.tab_layout);
        viewPager = (ViewPager)view.findViewById(R.id.pager);

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        adapter = new PagerAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
        tabLayout.setOnTabSelectedListener(this);

        queryServiceViewPresenter.loadContentTab();
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
        ArrayList<Fragment> fragments;

        public PagerAdapter(FragmentManager fm) {
            super(fm);
            this.fragments = new ArrayList<>();
        }

        public void addFragment(Fragment fragment){
            this.fragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
                return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}
