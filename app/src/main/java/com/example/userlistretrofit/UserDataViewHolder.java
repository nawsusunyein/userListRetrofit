package com.example.userlistretrofit;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserDataViewHolder extends RecyclerView.ViewHolder {

    TextView username;
    TextView companyName;
    TextView phone;
    TextView address;

    UserDataViewHolder(View itemView){
        super(itemView);
        username = (TextView) itemView.findViewById(R.id.txt_username);
        companyName = (TextView) itemView.findViewById(R.id.txt_company_name);
        phone = (TextView) itemView.findViewById(R.id.txt_phone_number);
        address = (TextView) itemView.findViewById(R.id.txt_address);
    }
}
