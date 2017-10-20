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
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fr.formation.tp18.R;
import fr.formation.tp18.adapter.RecyclerViewAdapter;
import fr.formation.tp18.tools.UsersLoader;

public class UsersListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_users_list, container, false);
        recyclerView = (RecyclerView) view;
        adapter = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Chargement des utilisateurs :
        new UsersLoader(this).execute("https://www.jobsathome.fr/offres/profils/monde/ressources-humaines/json");
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }


    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

}