package com.example.dudgn.retrofitexample;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.dudgn.retrofitexample.databinding.ActivityMainBinding;
import com.example.dudgn.retrofitexample.model.Article;
import com.example.dudgn.retrofitexample.model.Profile;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //리사이클러뷰에는 레이아웃 매니저가 필요함.
        binding.rvMain.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter();
        binding.rvMain.setAdapter(adapter);

        List<Article> list = new ArrayList<>();

        list.add(new Article("영훈","스터디","2018-10-21",new Profile("이영훈")));
        list.add(new Article("대연","스터디","2018-10-21",new Profile("이영훈")));
        list.add(new Article("성수","스터디","2018-10-21",new Profile("이영훈")));
        list.add(new Article("지수","스터디","2018-10-21",new Profile("이영훈")));
        list.add(new Article("수현","스터디","2018-10-21",new Profile("이영훈")));

        adapter.setData(list);
    }
}
