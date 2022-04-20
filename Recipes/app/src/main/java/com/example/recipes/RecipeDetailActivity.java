package com.example.recipes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.recipes.databinding.ActivityRecipedetailBinding;

public class RecipeDetailActivity extends AppCompatActivity {
    private TextView mDisplayRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipedetail);
        Intent intent = getIntent();
        String recipe = intent.getStringExtra("Recipe");
        mDisplayRecipe = (TextView) findViewById(R.id.textViewDisplayRecipe);
        mDisplayRecipe.setText(recipe);


    }

}