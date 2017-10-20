package fr.formation.tp18.adapter;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import fr.formation.tp18.fragment.UserPagerFragment;
import fr.formation.tp18.tools.DataBase;

/**
 * Created by ronan on 19/10/2017.
 */


public class UserPagerAdapter extends FragmentPagerAdapter {

    public UserPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos) {
        return UserPagerFragment.newInstance(
                DataBase.users.get(pos)
        );
    }

    @Override
    public int getCount() {
        return DataBase.users.size();
    }
}