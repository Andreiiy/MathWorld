package com.atatar.user.mathworld;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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




/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment implements IQuestion {

    RelativeLayout rlQuestion;
    TextView txt_question_txt;
    TextView tvQuestion1,tvQuestion11,tvQuestion12,tvQuestionznak,tvQuestion2,tvQuestion21,tvQuestion22,tvDrob1;

    CheckBox ckbA,ckbB,ckbC,ckbD;
    FrameLayout layout_image;
    Random rand = new Random();
    Question question;
    int questionIndex = -1;
    boolean fraction;


    public QuestionFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View itemView =  inflater.inflate(R.layout.fragment_question, container, false);


        questionIndex = getArguments().getInt("index",-1);
        question = Common.questionList.get(questionIndex);

        if (question != null) {



            ImageView img_question = (ImageView)itemView.findViewById(R.id.img_question);

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

            ckbA = (CheckBox) itemView.findViewById(R.id.ckbA);
            ckbB = (CheckBox) itemView.findViewById(R.id.ckbB);
            ckbC = (CheckBox) itemView.findViewById(R.id.ckbC);
            ckbD = (CheckBox) itemView.findViewById(R.id.ckbD);

            //View
            if(question.getFraction()){

                rlQuestion = (RelativeLayout) itemView.findViewById(R.id.rlQuestionFraction);
                rlQuestion.getLayoutParams().height = 0;

                txt_question_txt = (TextView) itemView.findViewById(R.id.txt_question_txt);
                txt_question_txt.setTextSize(20);
/*
                String [] questionString = question.getExercise().split("/");
                String drob = "-";
                if( questionString[2].equals(" "))
                    drob="";
                String questionView = "    "+ questionString[2]+ "            "+questionString[6]+"  \n"
                        +questionString[1]+"  "+drob+"    "+questionString[4]+ "   "+questionString[5]+"  -  =\n"
                        +"    "+questionString[3]+"            "+questionString[7];
                        txt_question_txt.setText(questionView);
*/

                SpannableStringBuilder test = new SpannableStringBuilder();
                test.append("\n");
                test.append(Html.fromHtml("3 1/2"));
                test.append("\n");
                txt_question_txt.setText(test);



                String [] answerA = question.getAnswerA().split("/");
                String [] answerB = question.getAnswerB().split("/");
                String [] answerC = question.getAnswerC().split("/");
                String [] answerD = question.getAnswerD().split("/");

               /*
                tvDrob1 = (TextView) itemView.findViewById(R.id.tvdrob1);


                tvQuestion1 = (TextView) itemView.findViewById(R.id.tvQuestionDrob2);
                if(!questionString[1].equals(" ")) {
                    if (questionString[2].equals(" "))
                        tvDrob1.setText(questionString[1]);
                    else
                    tvQuestion1.setText(questionString[1]);
                }

                tvQuestion11 = (TextView) itemView.findViewById(R.id.tvQuestionDrob111);
                tvQuestion11.setText(questionString[2]);

                tvQuestion12 = (TextView) itemView.findViewById(R.id.tvQuestionDrob12);
                tvQuestion12.setText(questionString[3]);

                tvQuestionznak = (TextView) itemView.findViewById(R.id.tvQuestion1znak);
                tvQuestionznak.setText(questionString[4]);

                tvQuestion2 = (TextView) itemView.findViewById(R.id.tvQuestionDrob12);
                if(!questionString[5].equals(" "))
                tvQuestion2.setText(questionString[5]);

                tvQuestion21 = (TextView) itemView.findViewById(R.id.tvQuestionDrob21);
                tvQuestion21.setText(questionString[6]);

                tvQuestion22 = (TextView) itemView.findViewById(R.id.tvQuestion122);
                tvQuestion22.setText(questionString[7]);

 */
                           }

            else {

                rlQuestion = (RelativeLayout) itemView.findViewById(R.id.rlQuestionFraction);
                rlQuestion.getLayoutParams().height = 0;


                txt_question_txt = (TextView) itemView.findViewById(R.id.txt_question_txt);
                txt_question_txt.setText(question.getExercise());


            }

            ckbA.setText(question.getAnswerA());
            ckbB.setText(question.getAnswerB());
            ckbC.setText(question.getAnswerC());
            ckbD.setText(question.getAnswerD());

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


                layout_image = (FrameLayout) itemView.findViewById(R.id.layout_image);

        }
        return itemView;
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
            Toast.makeText(getContext(),"Cannot get question",Toast.LENGTH_SHORT).show();
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
}
