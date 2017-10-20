package fr.formation.tp18;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import fr.formation.tp18.fragment.UsersListFragment;

public class MainActivity extends Activity {

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

}