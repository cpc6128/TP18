package fr.formation.tp18.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.formation.tp18.R;
import fr.formation.tp18.modele.User;

/**
 * Created by ronan on 12/06/2017.
 */

public class UserPagerFragment extends Fragment {

    public static final String DATA = "data";

    public static UserPagerFragment newInstance(User user) {
        UserPagerFragment f = new UserPagerFragment();
        Bundle b = new Bundle();
        b.putParcelable(DATA, user);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pager_user, container, false);
        TextView tv = (TextView) v.findViewById(R.id.fragmentUser);
        User user = getArguments().getParcelable(DATA);
        tv.setText(user.getDetail());
        return v;
    }

}
