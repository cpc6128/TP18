package fr.formation.tp18.listener;

import android.support.v4.view.ViewPager;

import fr.formation.tp18.listener.i.OnUserSelectedListener;

/**
 * Created by ronan on 19/10/2017.
 */

public class ViewPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {

    OnUserSelectedListener usersList;

    public ViewPagerOnPageChangeListener(OnUserSelectedListener usersList) {
        this.usersList = usersList;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
       usersList.setSelectedItem(position);
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
