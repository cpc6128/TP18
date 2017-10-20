package fr.formation.tp18.listener;

import android.support.v4.view.ViewPager;

import fr.formation.tp18.adapter.RecyclerViewAdapter;
import fr.formation.tp18.fragment.UsersListFragment;

/**
 * Created by ronan on 19/10/2017.
 */

public class ViewPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {

    UsersListFragment usersList;

    public ViewPagerOnPageChangeListener(UsersListFragment usersList) {
        this.usersList = usersList;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        // Mise à jour de l'utilisateur selectionné dans la liste
        if (usersList != null)
            ((RecyclerViewAdapter) usersList.getAdapter()).setSelectedItem(position);
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
