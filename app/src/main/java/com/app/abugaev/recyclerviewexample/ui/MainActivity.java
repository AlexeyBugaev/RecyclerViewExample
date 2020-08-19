package com.app.abugaev.recyclerviewexample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import android.os.Bundle;
import android.widget.Toast;

import com.app.abugaev.recyclerviewexample.R;
import com.app.abugaev.recyclerviewexample.adapters.RecyclerViewAdapter;
import com.app.abugaev.recyclerviewexample.model.JsonObject;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViewInterface, SwipeRefreshLayout.OnRefreshListener  {

    Presenter presenter;
    private RecyclerView.Adapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            presenter.loadData();
            swipeRefreshLayout.setRefreshing(false);
        });

        presenter = new Presenter(this);
        presenter.loadData();
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayObjects(List<JsonObject> objects) {
        adapter = new RecyclerViewAdapter(objects);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayError(String s) {
        showToast(s);
    }

    @Override
    public void onRefresh() {
    }
}
