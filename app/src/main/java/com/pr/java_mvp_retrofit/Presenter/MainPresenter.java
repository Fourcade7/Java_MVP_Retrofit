package com.pr.java_mvp_retrofit.Presenter;

import com.pr.java_mvp_retrofit.Contract.MainContract;
import com.pr.java_mvp_retrofit.Model.Model.Posts;
import com.pr.java_mvp_retrofit.Model.Repository.MainRepository;

import java.util.ArrayList;

public class MainPresenter implements MainContract.MainPresenter {

    MainContract.MainView mainView;
    MainContract.MainRepository mainRepository;

    public MainPresenter(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void go() {
        mainRepository=new MainRepository(this);
        mainRepository.loaddata();
    }

    @Override
    public void response(ArrayList<Posts> postsArrayList) {
        mainView.showData(postsArrayList);
    }


}
