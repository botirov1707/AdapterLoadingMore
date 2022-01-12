package com.example.recycleviewcustommultitypeadapter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewcustommultitypeadapter.Model.User;
import com.example.recycleviewcustommultitypeadapter.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_AVAIlABLE_YES = 0;
    private static final int TYPE_AVAILABLE_NOT = 1;
    private Context context;
    private List<User> userList;

    public CustomAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getItemViewType(int position) {
        if (userList.get(position).isAvailable()) {
            return TYPE_AVAIlABLE_YES;
        }
        return TYPE_AVAILABLE_NOT;
    }

    @Override
    public int getItemCount() {
       return userList.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_AVAIlABLE_YES){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_yes,viewGroup,false);
            return new CustomViewYesHolder(view);
        }
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_not,viewGroup,false);
        return new CustomViewNotHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        User user = userList.get(position);
        if (holder instanceof CustomViewYesHolder){
            TextView first_name = ((CustomViewYesHolder) holder).first_name;
            TextView last_name = ((CustomViewYesHolder) holder).last_name;
            first_name.setText(user.getFirstName());
            last_name.setText(user.getLastName());
        }
        if (holder instanceof CustomViewNotHolder){
            TextView first_name = ((CustomViewNotHolder) holder).first_name;
            TextView last_name = ((CustomViewNotHolder) holder).last_name;
            first_name.setText(user.getFirstName());
            last_name.setText(user.getLastName());
        }
    }
    public class CustomViewYesHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView first_name,last_name;
        CustomViewYesHolder(View v){
            super(v);
            view =v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
    public class CustomViewNotHolder extends RecyclerView.ViewHolder{
        public View view;
        public TextView first_name,last_name;
        CustomViewNotHolder(View v){
            super(v);
            view =v;
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
}
