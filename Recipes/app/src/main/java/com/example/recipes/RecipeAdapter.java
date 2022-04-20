package com.example.recipes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.WorldViewHolder> {

    private Hashtable<String, String> mRecipeList;
    private LayoutInflater mInflater;
    private ArrayList<String> mRecipeValues = new ArrayList<>(mRecipeList.values());
    private ArrayList<String> mRecipeKeys = new ArrayList<>(mRecipeList.keySet());
    private LinkedList<String> mLLRecipeValues = new LinkedList<>(mRecipeValues);
    private LinkedList<String> mLLRecipeKeys = new LinkedList<>(mRecipeKeys);
    private Context context;

    public RecipeAdapter(Context context, Hashtable recipeList){
        this.context = context;
        this.mRecipeList=recipeList;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecipeAdapter.WorldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recipelist_item, parent,false);
        return new WorldViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.WorldViewHolder holder, int position) {
        String mCurrent = mLLRecipeKeys.get(position);
        holder.mNameViewItem.setText(mCurrent);
        holder.mDescriptionViewItem.setText(mRecipeList.get(mCurrent));
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    class WorldViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mNameViewItem;
        public final TextView mDescriptionViewItem;
        final RecipeAdapter mAdapter;

        public WorldViewHolder(@NonNull View itemView, RecipeAdapter adapter) {
            super(itemView);
            mNameViewItem = itemView.findViewById(R.id.name);
            mDescriptionViewItem = itemView.findViewById(R.id.description);
            mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition=getLayoutPosition();
            String recipe=mRecipeKeys.get(mPosition);
            Log.d("RecylerView:Recipe",recipe);
            Intent intent=new Intent(context,RecipeDetailActivity.class);
            intent.putExtra("Recipe",recipe);
            context.startActivity(intent);

        }
    }
}
