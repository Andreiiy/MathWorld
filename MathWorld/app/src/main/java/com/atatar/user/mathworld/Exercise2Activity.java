package com.atatar.user.mathworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atatar.user.mathworld.Common.Common;
import com.atatar.user.mathworld.DbHelper.Data;
import com.atatar.user.mathworld.Model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import io.github.kexanie.library.MathView;

public class Exercise2Activity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout rlQuestion1;
    private RelativeLayout rlQuestion2;
    private RelativeLayout rlQuestion3;
    private RelativeLayout rlQuestion4;
    private LinearLayout llQuestion1;
    private LinearLayout llQuestion2;
    private LinearLayout llQuestion3;
    private LinearLayout llQuestion4;
    private Random rand = new Random();

    private TextView tvQuestion1,tvQuestion2,tvQuestion3,tvQuestion4;

    private MathView mvQuestion1,mvQuestion2,mvQuestion3,mvQuestion4;
    private EditText etAnswer1,etAnswer2,etAnswer3,etAnswer4;
    private EditText etAnswer1Drob,etAnswer11Drob,etAnswer12Drob;
    private EditText etAnswer2Drob,etAnswer21Drob,etAnswer22Drob;
    private EditText etAnswer3Drob,etAnswer31Drob,etAnswer32Drob;
    private EditText etAnswer4Drob,etAnswer41Drob,etAnswer42Drob;

    private Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        btnNext = (Button)findViewById(R.id.bnext);
        btnNext.setOnClickListener(this);

        llQuestion1 = (LinearLayout) findViewById(R.id.llQuestion1);
        rlQuestion1 = (RelativeLayout) findViewById(R.id.rlQuestionFraction);
        llQuestion2 = (LinearLayout) findViewById(R.id.llQuestion2);
        rlQuestion2 = (RelativeLayout) findViewById(R.id.rlQuestionFraction2);
        llQuestion3 = (LinearLayout) findViewById(R.id.llQuestion3);
        rlQuestion3 = (RelativeLayout) findViewById(R.id.rlQuestionFraction3);
        llQuestion4 = (LinearLayout) findViewById(R.id.llQuestion4);
        rlQuestion4 = (RelativeLayout) findViewById(R.id.rlQuestionFraction4);





        //Data data = new Data(this);
        //Common.questionList = data.getQuestions(Common.idSelectedCategory);


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

        if(Common.questionList.get(4).getFraction()) {
            etAnswer1Drob=(EditText)findViewById(R.id.etAnswer1Drob);
            etAnswer11Drob=(EditText)findViewById(R.id.etAnswer11Drob);
            etAnswer12Drob=(EditText)findViewById(R.id.etAnswer12Drob);
            String[] questionString = Common.questionList.get(4).getExercise().split("/");
            llQuestion1.getLayoutParams().height = 0;

            mvQuestion1 = (MathView) findViewById(R.id.mvQuestion1);

            mvQuestion1.config("MathJax.Hub.Config({\n"+"  { TeX: { extensions: [\"color.js\"] } }\n"+"});");

            mvQuestion1.setText("\\(\\color{white}{\\Huge{"
                    +questionString[1]+"\\frac{"+questionString[2]+"}{"+questionString[3]+"}"
                    +questionString[4]+ ""
                    +questionString[5]+""+"" +"\\frac{"+questionString[6]+"}{"+questionString[7]+"} =}}\\)");
        }else {

            rlQuestion1.getLayoutParams().height = 0;
            etAnswer1=(EditText) findViewById(R.id.etAnswer1);
            tvQuestion1= (TextView)findViewById(R.id.txt_question_txt);
            tvQuestion1.setText(Common.questionList.get(4).getExercise());
        }

        if(Common.questionList.get(5).getFraction()) {
            etAnswer2Drob=(EditText)findViewById(R.id.etAnswer2Drob);
            etAnswer21Drob=(EditText)findViewById(R.id.etAnswer21Drob);
            etAnswer22Drob=(EditText)findViewById(R.id.etAnswer22Drob);
            llQuestion2.getLayoutParams().height = 0;
            String[] questionString = Common.questionList.get(5).getExercise().split("/");
            mvQuestion2 = (MathView) findViewById(R.id.mvQuestion2);

            mvQuestion2.config("MathJax.Hub.Config({\n"+"  { TeX: { extensions: [\"color.js\"] } }\n"+"});");

            mvQuestion2.setText("\\(\\color{white}{\\Huge{"
                    +questionString[1]+"\\frac{"+questionString[2]+"}{"+questionString[3]+"}"
                    +questionString[4]+ ""
                    +questionString[5]+""+"" +"\\frac{"+questionString[6]+"}{"+questionString[7]+"} =}}\\)");
        }else {

            rlQuestion2.getLayoutParams().height = 0;
            etAnswer2=(EditText) findViewById(R.id.etAnswer2);
            tvQuestion2= (TextView)findViewById(R.id.txt_question_txt2);
            tvQuestion2.setText(Common.questionList.get(5).getExercise());
        }

        if(Common.questionList.get(6).getFraction()) {
            etAnswer3Drob=(EditText)findViewById(R.id.etAnswer3Drob);
            etAnswer31Drob=(EditText)findViewById(R.id.etAnswer31Drob);
            etAnswer32Drob=(EditText)findViewById(R.id.etAnswer32Drob);
            llQuestion3.getLayoutParams().height = 0;
            String[] questionString = Common.questionList.get(6).getExercise().split("/");
            mvQuestion3 = (MathView) findViewById(R.id.mvQuestion3);

            mvQuestion3.config("MathJax.Hub.Config({\n"+"  { TeX: { extensions: [\"color.js\"] } }\n"+"});");

            mvQuestion3.setText("\\(\\color{white}{\\Huge{"
                    +questionString[1]+"\\frac{"+questionString[2]+"}{"+questionString[3]+"}"
                    +questionString[4]+ ""
                    +questionString[5]+""+"" +"\\frac{"+questionString[6]+"}{"+questionString[7]+"} =}}\\)");
        }else {
            rlQuestion3.getLayoutParams().height = 0;
            etAnswer3=(EditText) findViewById(R.id.etAnswer3);
            tvQuestion3= (TextView)findViewById(R.id.txt_question_txt3);
            tvQuestion3.setText(Common.questionList.get(6).getExercise());
        }

        if(Common.questionList.get(7).getFraction()) {
            etAnswer4Drob=(EditText)findViewById(R.id.etAnswer4Drob);
            etAnswer41Drob=(EditText)findViewById(R.id.etAnswer41Drob);
            etAnswer42Drob=(EditText)findViewById(R.id.etAnswer42Drob);
            llQuestion4.getLayoutParams().height = 0;
            String[] questionString = Common.questionList.get(7).getExercise().split("/");
            mvQuestion4 = (MathView) findViewById(R.id.mvQuestion4);

            mvQuestion4.config("MathJax.Hub.Config({\n"+"  { TeX: { extensions: [\"color.js\"] } }\n"+"});");

            mvQuestion4.setText("\\(\\color{white}{\\Huge{"
                    +questionString[1]+"\\frac{"+questionString[2]+"}{"+questionString[3]+"}"
                    +questionString[4]+ ""
                    +questionString[5]+""+"" +"\\frac{"+questionString[6]+"}{"+questionString[7]+"} =}}\\)");

        }else {

            rlQuestion4.getLayoutParams().height = 0;
            etAnswer4=(EditText) findViewById(R.id.etAnswer4);
            tvQuestion4= (TextView)findViewById(R.id.txt_question_txt4);
            tvQuestion4.setText(Common.questionList.get(7).getExercise());
        }


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bnext){

            if(Common.questionList.get(4).getFraction()) {
                String integer = etAnswer1Drob.getText().toString();
                //if(integer.equals("")) integer="/";
                String answer = "" + integer + "/" + etAnswer11Drob.getText() + "/" + etAnswer12Drob.getText();
                checkAnswerFraction(Common.questionList.get(4), answer);
            }else{
                if(etAnswer1.getText().toString().equals(Common.questionList.get(4).getAnswerCorrect()))
                    Common.right_answer_count++;
            }

            if(Common.questionList.get(5).getFraction()) {
                String integer = etAnswer2Drob.getText().toString();
                // if(integer.equals("")) integer="/";
                String answer = "" + integer + "/" + etAnswer21Drob.getText() + "/" + etAnswer22Drob.getText();
                checkAnswerFraction(Common.questionList.get(5), answer);
            }else{
                if(etAnswer2.getText().toString().equals(Common.questionList.get(5).getAnswerCorrect()))
                    Common.right_answer_count++;
            }

            if(Common.questionList.get(6).getFraction()) {
                String integer = etAnswer3Drob.getText().toString();
                //if(integer.equals("")) integer="/";
                String answer = "" + integer + "/" + etAnswer31Drob.getText() + "/" + etAnswer32Drob.getText();
                checkAnswerFraction(Common.questionList.get(6), answer);
            }else{
                if(etAnswer3.getText().toString().equals(Common.questionList.get(6).getAnswerCorrect()))
                    Common.right_answer_count++;
            }
            if(Common.questionList.get(7).getFraction()) {
                String integer = etAnswer4Drob.getText().toString();
                //if(integer.equals("")) integer="/";
                String answer = "" + integer + "/" + etAnswer41Drob.getText() + "/" + etAnswer42Drob.getText();
                checkAnswerFraction(Common.questionList.get(7), answer);
            }else{
                if(etAnswer4.getText().toString().equals(Common.questionList.get(7).getAnswerCorrect()))
                    Common.right_answer_count++;
            }

            Intent intent = new Intent(this,Exercise3Activity.class);
            startActivity(intent);
        }
    }

    private  void checkAnswerFraction(Question question, String answer){
        switch ( question.getAnswerCorrect()){
            case "A":{
                answer = "A/"+answer;
                if (question.getAnswerA().equals(answer))
                    Common.right_answer_count++;
            }
            break;
            case "B":{
                answer = "B/"+answer;
                if (question.getAnswerB().equals(answer))
                    Common.right_answer_count++;
            }
            break;
            case "C":{
                answer = "C/"+answer;
                if (question.getAnswerC().equals(answer))
                    Common.right_answer_count++;
            }
            break;
            case "D":{
                answer = "D/"+answer;
                if (question.getAnswerD().equals(answer))
                    Common.right_answer_count++;
            }
            break;
        }
    }
}
