package com.example.userlistretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserAdapter userAdapter;
    private RecyclerView userRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);
        Call<List<UsersModel>> call = service.getAllUsers();

        call.enqueue(new Callback<List<UsersModel>>() {
            @Override
            public void onResponse(Call<List<UsersModel>> call, Response<List<UsersModel>> response) {
                loadUserList(response.body());
            }

            @Override
            public void onFailure(Call<List<UsersModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Unable to load user",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadUserList(List<UsersModel> usersList){
        userRecyclerView = (RecyclerView) findViewById(R.id.user_recycler_view);
        userAdapter = new UserAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        userRecyclerView.setLayoutManager(layoutManager);
        userRecyclerView.setAdapter(userAdapter);

    }
}
