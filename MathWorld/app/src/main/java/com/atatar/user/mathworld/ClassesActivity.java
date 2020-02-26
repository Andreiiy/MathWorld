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

import com.atatar.user.mathworld.Adapter.MyRecyclerViewAdapter;
import com.atatar.user.mathworld.Common.Common;

import java.util.ArrayList;

public class ClassesActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{
    private ArrayList<Bitmap> images;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);


        images = new ArrayList<>();
        Bitmap bImage1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.class3);
        Bitmap bImage2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.class4);
        Bitmap bImage3 = BitmapFactory.decodeResource(this.getResources(), R.drawable.class5);
        Bitmap bImage4 = BitmapFactory.decodeResource(this.getResources(), R.drawable.class6);
        images.add(bImage1);
        images.add(bImage2);
        images.add(bImage3);
        images.add(bImage4);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvClasses);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(this, images, "classes");
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);



        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onItemClick(View view, int position) {
        Common.idSelectedCategory=position+3;

        Common.selectedCategory = "Class "+Common.idSelectedCategory;
        if(Common.selectedCategoryTest) {
            Intent intent = new Intent(this, QuestionActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, ExerciseActivity.class);
            startActivity(intent);
        }

    }
}
