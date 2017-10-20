/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.formation.tp18.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.formation.tp18.R;
import fr.formation.tp18.adapter.UserPagerAdapter;
import fr.formation.tp18.listener.ViewPagerOnPageChangeListener;


public class UserFragment extends Fragment {
    public final static String ARG_POSITION = "position";
    private int mCurrentPosition = -1;
    private ViewPager pager;
    private UsersListFragment usersListe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        View view = inflater.inflate(R.layout.fragment_user, container, false);
        pager = (ViewPager) view.findViewById(R.id.viewPager);
        pager.setAdapter(new UserPagerAdapter(getChildFragmentManager()));
        pager.setCurrentItem(mCurrentPosition);

        usersListe = (UsersListFragment) getFragmentManager().findFragmentById(R.id.liste_fragment);

        pager.addOnPageChangeListener(new ViewPagerOnPageChangeListener(usersListe));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        pager.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position) {
        if (pager != null) {
            pager.setCurrentItem(position);
            mCurrentPosition = position;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }

    public ViewPager getPager() {
        return pager;
    }
}