package com.atatar.user.mathworld;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atatar.user.mathworld.Common.Common;
import com.atatar.user.mathworld.Interface.IQuestion;
import com.atatar.user.mathworld.Model.CurrentQuestion;
import com.atatar.user.mathworld.Model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Fraction1Activity extends AppCompatActivity implements IQuestion ,View.OnClickListener{
    RelativeLayout rlQuestion;
    TextView txt_question_txt;
    TextView tvQuestion1,tvQuestion11,tvQuestion12,tvQuestionznak,tvQuestion2,tvQuestion21,tvQuestion22;
    TextView tvAnswerA1,tvAnswerA11,tvAnswerAznak,tvAnswerA12;
    TextView tvAnswerB1,tvAnswerB11,tvAnswerBznak,tvAnswerB12;
    TextView tvAnswerC1,tvAnswerC11,tvAnswerCznak,tvAnswerC12;
    TextView tvAnswerD1,tvAnswerD11,tvAnswerDznak,tvAnswerD12;
    CheckBox ckbA,ckbB,ckbC,ckbD;
    FrameLayout layout_image;
    Random rand = new Random();
    Question question;
    int questionIndex = -1;
    boolean fraction;



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraction1);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(Common.selectedCategory);
        setSupportActionBar(toolbar);

        question = Common.questionList.get(questionIndex);

        if (question != null) {


            ImageView img_question = (ImageView) findViewById(R.id.img_question);

            ArrayList<Integer> idImages = new ArrayList<Integer>(
                    Arrays.asList(getResources().getIdentifier("com.atatar.user.mathworld:drawable/hat", null, null),
                            getResources().getIdentifier("com.atatar.user.mathworld:drawable/hat2", null, null),
                            getResources().getIdentifier("com.atatar.user.mathworld:drawable/il1", null, null),
                            getResources().getIdentifier("com.atatar.user.mathworld:drawable/il2", null, null),
                            getResources().getIdentifier("com.atatar.user.mathworld:drawable/il3", null, null),
                            getResources().getIdentifier("com.atatar.user.mathworld:drawable/il4", null, null),
                            getResources().getIdentifier("com.atatar.user.mathworld:drawable/il5", null, null),
                            getResources().getIdentifier("com.atatar.user.mathworld:drawable/il6", null, null),
                            getResources().getIdentifier("com.atatar.user.mathworld:drawable/il7", null, null),
                            getResources().getIdentifier("com.atatar.user.mathworld:drawable/il8", null, null))
            );
            // int g = getResources().getIdentifier("com.atatar.user.testreciclerview:drawable/class3",null,null);
            //img_question.setImageDrawable(getResources().getDrawable(class3));
            img_question.setImageResource(idImages.get(rand.nextInt(idImages.size())));

            ckbA = (CheckBox) findViewById(R.id.ckbA);
            ckbB = (CheckBox) findViewById(R.id.ckbB);
            ckbC = (CheckBox) findViewById(R.id.ckbC);
            ckbD = (CheckBox) findViewById(R.id.ckbD);

            //View
            if (question.getFraction()) {
                txt_question_txt = (TextView) findViewById(R.id.txt_question_txt);
                txt_question_txt.setHeight(0);

                String[] questionString = question.getExercise().split("/");
                String[] answerA = question.getAnswerA().split("/");
                String[] answerB = question.getAnswerB().split("/");
                String[] answerC = question.getAnswerC().split("/");
                String[] answerD = question.getAnswerD().split("/");

                tvQuestion1 = (TextView) findViewById(R.id.tvQuestionDrob2);
                if (!questionString[1].equals(" "))
                    tvQuestion1.setText(questionString[1]);

                tvQuestion11 = (TextView) findViewById(R.id.tvQuestionDrob111);
                tvQuestion11.setText(questionString[2]);

                tvQuestion12 = (TextView) findViewById(R.id.tvQuestionDrob121);
                tvQuestion12.setText(questionString[3]);

                tvQuestionznak = (TextView) findViewById(R.id.tvQuestion1znak);
                tvQuestionznak.setText(questionString[4]);

                tvQuestion2 = (TextView) findViewById(R.id.tvQuestionDrob12);
                if (!questionString[5].equals(" "))
                    tvQuestion2.setText(questionString[5]);

                tvQuestion21 = (TextView) findViewById(R.id.tvQuestionDrob121);
                tvQuestion21.setText(questionString[6]);

                tvQuestion22 = (TextView) findViewById(R.id.tvQuestion122);
                tvQuestion22.setText(questionString[7]);

                tvAnswerA1 = (TextView) findViewById(R.id.tvAnswera1);
                if (!answerA[1].equals(" "))
                    tvAnswerA1.setText(answerA[1]);
                tvAnswerA11 = (TextView) findViewById(R.id.tvAnswera11);
                tvAnswerA11.setText(answerA[2]);
                tvAnswerA12 = (TextView) findViewById(R.id.tvAnswera12);
                tvAnswerA12.setText(answerA[3]);
                tvAnswerAznak = (TextView) findViewById(R.id.tvAnswerAznak);
                tvAnswerAznak.setText("---");

                tvAnswerB1 = (TextView) findViewById(R.id.tvAnswerb1);
                if (!answerB[1].equals(" "))
                    tvAnswerB1.setText(answerB[1]);
                tvAnswerB11 = (TextView) findViewById(R.id.tvAnswerb11);
                tvAnswerB11.setText(answerB[2]);
                tvAnswerB12 = (TextView) findViewById(R.id.tvAnswerb12);
                tvAnswerB12.setText(answerB[3]);
                tvAnswerBznak = (TextView) findViewById(R.id.tvAnswerBznak);
                tvAnswerBznak.setText("---");

                tvAnswerC1 = (TextView) findViewById(R.id.tvAnswerc1);
                if (!answerC[1].equals(" "))
                    tvAnswerC1.setText(answerC[1]);
                tvAnswerC11 = (TextView) findViewById(R.id.tvAnswerc11);
                tvAnswerC11.setText(answerC[2]);
                tvAnswerC12 = (TextView) findViewById(R.id.tvAnswerc12);
                tvAnswerC12.setText(answerC[3]);
                tvAnswerCznak = (TextView) findViewById(R.id.tvAnswerCznak);
                tvAnswerCznak.setText("---");


                tvAnswerD1 = (TextView) findViewById(R.id.tvAnswerd1);
                if (!answerD[1].equals(" "))
                    tvAnswerD1.setText(answerD[1]);
                tvAnswerD11 = (TextView) findViewById(R.id.tvAnswerd11);
                tvAnswerD11.setText(answerD[2]);
                tvAnswerD12 = (TextView) findViewById(R.id.tvAnswerd12);
                tvAnswerD12.setText(answerD[3]);
                tvAnswerDznak = (TextView) findViewById(R.id.tvAnswerDznak);
                tvAnswerDznak.setText("---");


                ckbA.setText("" + question.getAnswerA().charAt(0));
                ckbB.setText("" + question.getAnswerB().charAt(0));
                ckbC.setText("" + question.getAnswerC().charAt(0));
                ckbD.setText("" + question.getAnswerD().charAt(0));
            } else {

                rlQuestion = (RelativeLayout) findViewById(R.id.rlQuestionFraction);
                rlQuestion.getLayoutParams().height = 0;


                txt_question_txt = (TextView) findViewById(R.id.txt_question_txt);
                txt_question_txt.setText(question.getExercise());


                ckbA.setText(question.getAnswerA());
                ckbB.setText(question.getAnswerB());
                ckbC.setText(question.getAnswerC());
                ckbD.setText(question.getAnswerD());
            }

            ckbA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Common.selected_values.add(ckbA.getText().toString());
                    } else {
                        Common.selected_values.remove(ckbA.getText().toString());
                    }

                }
            });

            ckbB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Common.selected_values.add(ckbB.getText().toString());
                    } else {
                        Common.selected_values.remove(ckbB.getText().toString());
                    }

                }
            });

            ckbC.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Common.selected_values.add(ckbC.getText().toString());
                    } else {
                        Common.selected_values.remove(ckbC.getText().toString());
                    }

                }
            });

            ckbD.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Common.selected_values.add(ckbD.getText().toString());
                    } else {
                        Common.selected_values.remove(ckbD.getText().toString());
                    }

                }
            });


            layout_image = (FrameLayout) findViewById(R.id.layout_image);

        }
    }
    @Override
    public CurrentQuestion getSelectedAnswer() {
        CurrentQuestion currentQuestion = new CurrentQuestion(questionIndex,Common.ANSWER_TYPE.NO_ANSWER);
        StringBuilder result = new StringBuilder();
        if(Common.selected_values.size() > 1){

            Object[] arrayAnswer = Common.selected_values.toArray();
            for (int i = 0; i < arrayAnswer.length;i++){
                if(i < arrayAnswer.length - 1){
                    result.append(new StringBuilder((String)arrayAnswer[i]).substring(0,1)).append(",");
                }else
                    result.append(new StringBuilder((String)arrayAnswer[i]).substring(0,1));
            }
        }
        else if(Common.selected_values.size() == 1){
            Object[] arrayAnswer = Common.selected_values.toArray();
            // result.append(new StringBuilder((String)arrayAnswer[0]).substring(0,1));
            result.append(arrayAnswer[0].toString());
        }
///////////////////Check answer
        if(question != null){
            if(!TextUtils.isEmpty(result)){
                if(result.toString().equals(question.getAnswerCorrect()))
                    currentQuestion.setType(Common.ANSWER_TYPE.RIGHT_ANSWER);
                else
                    currentQuestion.setType(Common.ANSWER_TYPE.WRONG_ANSWER);
            }
            else
                currentQuestion.setType(Common.ANSWER_TYPE.NO_ANSWER);
        }else {
            Toast.makeText(this,"Cannot get question",Toast.LENGTH_SHORT).show();
            currentQuestion.setType(Common.ANSWER_TYPE.NO_ANSWER);
        }

        Common.selected_values.clear();
        return currentQuestion;
    }

    @Override
    public void showCorrectAnswer() {

        String[] correctAnswer = question.getAnswerCorrect().split(",");

        for(String answer:correctAnswer){

            if(answer.equals("A")){
                ckbA.setTypeface(null, Typeface.BOLD);
                ckbA.setTextColor(Color.RED);
            }
            else if(answer.equals("B")){
                ckbB.setTypeface(null, Typeface.BOLD);
                ckbB.setTextColor(Color.RED);
            }
            else if(answer.equals("C")){
                ckbC.setTypeface(null, Typeface.BOLD);
                ckbC.setTextColor(Color.RED);
            }
            else if(answer.equals("D")){
                ckbD.setTypeface(null, Typeface.BOLD);
                ckbD.setTextColor(Color.RED);
            }
        }
    }

    @Override
    public void disableAnswer() {

        ckbA.setEnabled(false);
        ckbB.setEnabled(false);
        ckbC.setEnabled(false);
        ckbD.setEnabled(false);
    }

    @Override
    public void resetQuestion() {
        ckbA.setEnabled(true);
        ckbB.setEnabled(true);
        ckbC.setEnabled(true);
        ckbD.setEnabled(true);

        ckbA.setChecked(false);
        ckbB.setChecked(false);
        ckbC.setChecked(false);
        ckbD.setChecked(false);

        ckbA.setTypeface(null, Typeface.NORMAL);
        ckbA.setTextColor(Color.BLACK);
        ckbB.setTypeface(null, Typeface.NORMAL);
        ckbB.setTextColor(Color.BLACK);
        ckbC.setTypeface(null, Typeface.NORMAL);
        ckbC.setTextColor(Color.BLACK);
        ckbD.setTypeface(null, Typeface.NORMAL);
        ckbD.setTextColor(Color.BLACK);
    }

    @Override
    public void onClick(View v) {

    }
}

