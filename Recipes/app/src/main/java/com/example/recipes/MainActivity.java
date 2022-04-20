package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Hashtable;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private Hashtable<String, String> mRecipeList = new Hashtable<>();
    private RecyclerView mRecycleView;
    private RecipeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecipeList.put("recipe 1","description 1");
        mRecipeList.put("recipe 2","description 2");
        mRecipeList.put("recipe 3","description 3");
        mRecipeList.put("recipe 4","description 4");
        mRecipeList.put("recipe 5","description 5");
        mRecipeList.put("recipe 6","description 6");
        mRecipeList.put("recipe 7","description 7");
        mRecipeList.put("recipe 8","description 8");
        mRecipeList.put("recipe 9","description 9");
        mRecipeList.put("recipe 10","description 10");




        mRecycleView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecipeAdapter(this,mRecipeList);
        mRecycleView.setAdapter(mAdapter);

    }
}