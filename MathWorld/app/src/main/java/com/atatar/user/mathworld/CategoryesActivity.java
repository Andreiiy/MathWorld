package com.atatar.user.mathworld;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.atatar.user.mathworld.Adapter.MyRecyclerViewAdapter;
import com.atatar.user.mathworld.Common.Common;

import java.util.ArrayList;

public class CategoryesActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    private ArrayList<Bitmap> images;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoryes);


        images = new ArrayList<>();
        Bitmap bImage1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.test2);
        Bitmap bImage2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.exercises2);

        images.add(bImage1);
        images.add(bImage2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvCategories);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(this, images,"category");
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);



        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(View view, int position) {

        if(position==0)
            Common.selectedCategoryTest = true;
            Intent intent = new Intent(this,ClassesActivity.class);
            startActivity(intent);


    }
}
