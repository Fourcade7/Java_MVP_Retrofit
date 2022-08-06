package com.pr.java_mvp_retrofit.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.pr.java_mvp_retrofit.Contract.MainContract;
import com.pr.java_mvp_retrofit.Model.Model.Posts;
import com.pr.java_mvp_retrofit.Presenter.MainPresenter;
import com.pr.java_mvp_retrofit.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    TextView textView;

    MainContract.MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview1);

        mainPresenter=new MainPresenter(this);
        textView.setOnClickListener(v -> {
            mainPresenter.go();
        });


    }

    @Override
    public void showData(ArrayList<Posts> postsArrayList) {

        Toast.makeText(MainActivity.this, postsArrayList.size()+"", Toast.LENGTH_SHORT).show();

    }
}