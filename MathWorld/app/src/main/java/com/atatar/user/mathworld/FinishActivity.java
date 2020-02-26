package com.atatar.user.mathworld;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.atatar.user.mathworld.Common.Common;

public class FinishActivity extends Activity implements View.OnClickListener {
    Button restart;
    Button exit;
    TextView points;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        points=(TextView)findViewById(R.id.tpoints);
        points.setText(""+100 / Common.questionList.size() * Common.right_answer_count);
        restart = (Button)findViewById(R.id.brestart);
        exit = (Button)findViewById(R.id.btnExit);

        restart.setOnClickListener(this);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.brestart:

                Intent intent = new Intent(this,CategoryesActivity.class);
                startActivity(intent);
                break;
            case  R.id.btnExit:
                finishAffinity();
                // System.exit(0);
                break;
        }
    }
}
