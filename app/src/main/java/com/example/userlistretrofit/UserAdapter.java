package com.example.userlistretrofit;

import android.content.Context;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserDataViewHolder>{

    private List<UsersModel> userList;

    UserAdapter(List<UsersModel> userList){
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View userView = inflater.inflate(R.layout.user_cardview,parent,false);
        UserDataViewHolder userDataViewHolder = new UserDataViewHolder(userView);
        return userDataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserDataViewHolder holder, int position) {
        holder.username.setText(userList.get(position).getUsername());
        holder.phone.setText(userList.get(position).getPhone());
        holder.companyName.setText(userList.get(position).getCompanyInfo().getComName());
        String address = userList.get(position).getAddress().getHomeStreet() + "-" + userList.get(position).getAddress().getHomeCity();
        holder.address.setText(address.toString());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
