package fr.formation.tp18.adapter;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.formation.tp18.R;
import fr.formation.tp18.fragment.UserFragment;
import fr.formation.tp18.fragment.UsersListFragment;
import fr.formation.tp18.tools.DataBase;

/**
 * Created by ronan on 19/10/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private int selectedItem;

    private UsersListFragment usersListFragment;

    public RecyclerViewAdapter(UsersListFragment usersListFragment) {
        this.usersListFragment = usersListFragment;
    }

    public void setSelectedItem(int selectedItem) {
        notifyItemChanged(this.selectedItem);
        this.selectedItem = selectedItem;
        notifyItemChanged(this.selectedItem);
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_utilisateur, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, final int position) {

        holder.mContentView.setText(DataBase.users.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserFragment articleFrag = (UserFragment)
                        usersListFragment.getFragmentManager().findFragmentById(R.id.article_fragment);

                if (articleFrag != null) {
                    articleFrag.updateArticleView(position);

                } else {
                    UserFragment newFragment = new UserFragment();
                    Bundle args = new Bundle();
                    args.putInt(UserFragment.ARG_POSITION, position);
                    newFragment.setArguments(args);
                    FragmentTransaction transaction = usersListFragment.getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

                setSelectedItem(position);
            }
        });

        holder.mView.setTag(holder);
        // Gestion de la surbrillance.
        holder.itemView.setSelected(position == selectedItem);
        if (selectedItem == position) {
            holder.itemView.setBackgroundColor(Color.GREEN);
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }

    }

    @Override
    public int getItemCount() {
        return DataBase.users.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mContentView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}