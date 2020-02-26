package com.atatar.user.mathworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.atatar.user.mathworld.Common.Common;
import com.atatar.user.mathworld.DbHelper.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exercise1Activity extends AppCompatActivity {

    private RelativeLayout rlQuestion1;
    private RelativeLayout rlQuestion2;
    private RelativeLayout rlQuestion3;
    private RelativeLayout rlQuestion4;
    private LinearLayout llQuestion1;
    private LinearLayout llQuestion2;
    private LinearLayout llQuestion3;
    private LinearLayout llQuestion4;
    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);
        Data data = new Data(this);
       // Common.questionList = data.getQuestions(Common.idSelectedCategory);

        ImageView img_question = (ImageView)findViewById(R.id.img_question);

        ArrayList<Integer> idImages = new ArrayList<Integer>(
                Arrays.asList(getResources().getIdentifier("com.atatar.user.mathworld:drawable/hat",null,null),
                        getResources().getIdentifier("com.atatar.user.mathworld:drawable/hat2",null,null),
                        getResources().getIdentifier("com.atatar.user.mathworld:drawable/il1",null,null),
                        getResources().getIdentifier("com.atatar.user.mathworld:drawable/il2",null,null),
                        getResources().getIdentifier("com.atatar.user.mathworld:drawable/il3",null,null),
                        getResources().getIdentifier("com.atatar.user.mathworld:drawable/il4",null,null),
                        getResources().getIdentifier("com.atatar.user.mathworld:drawable/il5",null,null),
                        getResources().getIdentifier("com.atatar.user.mathworld:drawable/il6",null,null),
                        getResources().getIdentifier("com.atatar.user.mathworld:drawable/il7",null,null),
                        getResources().getIdentifier("com.atatar.user.mathworld:drawable/il8",null,null))
        );
        // int g = getResources().getIdentifier("com.atatar.user.testreciclerview:drawable/class3",null,null);
        //img_question.setImageDrawable(getResources().getDrawable(class3));
        img_question.setImageResource(idImages.get(rand.nextInt(idImages.size())));
/*
        rlQuestion1 = (RelativeLayout) findViewById(R.id.rlQuestionFraction);
        rlQuestion1.getLayoutParams().height = 0;

        rlQuestion2 = (RelativeLayout) findViewById(R.id.rlQuestionFraction2);
        rlQuestion2.getLayoutParams().height = 0;

        rlQuestion3 = (RelativeLayout) findViewById(R.id.rlQuestionFraction3);
        rlQuestion3.getLayoutParams().height = 0;

        rlQuestion4 = (RelativeLayout) findViewById(R.id.rlQuestionFraction4);
        rlQuestion4.getLayoutParams().height = 0;

        */
        llQuestion1 = (LinearLayout) findViewById(R.id.llQuestion1);
        llQuestion1.getLayoutParams().height = 0;

        llQuestion2 = (LinearLayout) findViewById(R.id.llQuestion2);
        llQuestion2.getLayoutParams().height = 0;

        llQuestion3 = (LinearLayout) findViewById(R.id.llQuestion3);
        llQuestion3.getLayoutParams().height = 0;

        llQuestion4 = (LinearLayout) findViewById(R.id.llQuestion4);
        llQuestion4.getLayoutParams().height = 0;
    }
}
