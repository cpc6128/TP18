package fr.formation.tp18.tools;

import android.os.AsyncTask;

import java.util.List;

import fr.formation.tp18.R;
import fr.formation.tp18.fragment.UserFragment;
import fr.formation.tp18.fragment.UsersListFragment;
import fr.formation.tp18.modele.User;

/**
 * Created by ronan on 19/10/2017.
 */

public class UsersLoader extends AsyncTask<String, Void, List<User>> {

    UsersListFragment usersListFragment;

    public UsersLoader(UsersListFragment usersListFragment) {
        this.usersListFragment = usersListFragment;
    }

    @Override
    protected List<User> doInBackground(String... url) {
        Json sh = new Json();
        String json = sh.getJsonFrom(url[0]);
        List<User> users = sh.jsonToUsers(json);
        return users;
    }

    @Override
    protected void onPostExecute(List<User> users) {
        DataBase.users.addAll(users);

        // Mise à jour de la liste :
        usersListFragment.getAdapter().notifyDataSetChanged();
        UserFragment utilisateurFragment = (UserFragment)
                usersListFragment.getFragmentManager().findFragmentById(R.id.article_fragment);
        // Et du pager s'il est visible :
        if (utilisateurFragment != null) {
            utilisateurFragment.getPager().getAdapter().notifyDataSetChanged();
        }
    }
}