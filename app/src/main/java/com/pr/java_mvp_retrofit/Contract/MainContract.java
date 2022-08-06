package com.pr.java_mvp_retrofit.Contract;

import com.pr.java_mvp_retrofit.Model.Model.Posts;

import java.util.ArrayList;

public interface MainContract {

    interface MainView{
        void showData(ArrayList<Posts> postsArrayList);
    }
    interface MainRepository {
        void loaddata();
    }
    interface MainPresenter{
        void go();
        void response(ArrayList<Posts> postsArrayList);
    }

}
