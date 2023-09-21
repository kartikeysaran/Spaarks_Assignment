package kartikey.saran.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import kartikey.saran.myapplication.R;
import kartikey.saran.myapplication.databinding.ItemLayoutBinding;
import kartikey.saran.myapplication.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private ArrayList<User> users;

    public UserAdapter(ArrayList<User> userList) {
        this.users = userList;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_layout, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
        User user = users.get(position);
        holder.binding.setUser(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemLayoutBinding binding;
        public ViewHolder(@NonNull ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setUsers(ArrayList<User> userList) {
        users = userList;
        notifyDataSetChanged();
    }
}
