package fr.formation.tp18;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import fr.formation.tp18.adapter.RecyclerViewAdapter;
import fr.formation.tp18.fragment.UsersListFragment;
import fr.formation.tp18.listener.i.OnUserSelectedListener;

public class MainActivity extends Activity implements OnUserSelectedListener {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            // petit écran  :
            UsersListFragment usersList = new UsersListFragment();
            usersList.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, usersList).commit();
        }

    }

    @Override
    public void setSelectedItem(int position) {
        // Mise à jour de l'utilisateur selectionné dans la liste

        UsersListFragment list = (UsersListFragment)
                    getFragmentManager().findFragmentById(R.id.liste_fragment);
        if ( list != null) {
            ((RecyclerViewAdapter) list.getAdapter()).setSelectedItem(position);
        }

    }
}