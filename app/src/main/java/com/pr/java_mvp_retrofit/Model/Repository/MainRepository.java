package com.pr.java_mvp_retrofit.Model.Repository;

import android.util.Log;

import com.pr.java_mvp_retrofit.Contract.MainContract;
import com.pr.java_mvp_retrofit.Model.Api.Api;
import com.pr.java_mvp_retrofit.Model.Model.Posts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainRepository implements MainContract.MainRepository {

    ArrayList<Posts> postsArrayList;
    private static final String TAG = "Pr7";
    MainContract.MainPresenter mainPresenter;

    public MainRepository(MainContract.MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @Override
    public void loaddata() {
        postsArrayList=new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api=retrofit.create(Api.class);
        Call<List<Posts>> call=api.getAllposts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (response.isSuccessful()){
                   postsArrayList=(ArrayList<Posts>) response.body();
                    Log.d(TAG, "onResponse: "+postsArrayList.size());
                    mainPresenter.response(postsArrayList);
                }

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });


    }
}
