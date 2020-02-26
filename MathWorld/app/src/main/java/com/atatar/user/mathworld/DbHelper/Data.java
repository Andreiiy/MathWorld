package com.atatar.user.mathworld.DbHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.atatar.user.mathworld.Common.Common;
import com.atatar.user.mathworld.Model.Question;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;


public class Data {

    private   SQLiteDatabase mDb;
    private DatabaseHelper mDBHelper;
    private ArrayList<Question> questions;




    public Data(Context context) {


        mDBHelper = new DatabaseHelper(context);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();


        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

    }



    public HashMap<String,String> getCategories() {

        HashMap<String,String> catigories = new HashMap<>();


        Cursor cursor = mDb.rawQuery("SELECT * FROM Categories ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            catigories.put(cursor.getString(0),cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();

        return  catigories;
    }


    public ArrayList<Question> getDataBaseQuestions(int categoryID) {

        questions = new ArrayList<>();



        Cursor cursor = mDb.rawQuery(String.format("SELECT * FROM Exercises WHERE CategoryID =%d ORDER BY Random() LIMIT 30",categoryID), null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Question question = new Question(cursor.getInt(0),cursor.getString(2),cursor.getString(3));
            if(question.getExercise().charAt(0)=='/')
                question.setFraction(true);
            questions.add(question);
            cursor.moveToNext();
        }
        cursor.close();

        return  questions;
    }


    private void setQuestionsToList(ArrayList<Question> dataBaseQuestions) {

        //questions = new ArrayList<>();
        Random rand = new Random();
        ArrayList<String> answers = new ArrayList<>();
        for(Question question:dataBaseQuestions){

            answers.add(question.getAnswerCorrect());
            while (answers.size() < 4){
                String element = dataBaseQuestions.get(rand.nextInt(dataBaseQuestions.size())).getAnswerCorrect();
                if(Common.idSelectedCategory == 5) {
                    if (question.getFraction()) {
                        if (!answers.contains(element)) {
                            int index = element.indexOf('.');
                            if (index == -1)
                                answers.add(element);
                        }
                    } else {
                        if (!answers.contains(element)) {
                            int index = element.indexOf('.');
                            if (index >= 0)
                                answers.add(element);
                        }
                    }
                }
                else {
                    if (!answers.contains(element)) {
                           answers.add(element);
                    }
                }
            }

            Collections.shuffle(answers);
            if(question.getFraction()){
                if(question.getAnswerCorrect().equals(answers.get(0)))
                    question.setAnswerCorrect("A");
                if(question.getAnswerCorrect().equals(answers.get(1)))
                    question.setAnswerCorrect("B");
                if(question.getAnswerCorrect().equals(answers.get(2)))
                    question.setAnswerCorrect("C");
                if(question.getAnswerCorrect().equals(answers.get(3)))
                    question.setAnswerCorrect("D");

                question.setAnswerA("A/"+answers.get(0));
                question.setAnswerB("B/"+answers.get(1));
                question.setAnswerC("C/"+answers.get(2));
                question.setAnswerD("D/"+answers.get(3));

                answers.clear();

            }else {
                question.setAnswerA(answers.get(0));
                question.setAnswerB(answers.get(1));
                question.setAnswerC(answers.get(2));
                question.setAnswerD(answers.get(3));


                answers.clear();
            }
            }

            int size = questions.size();

    }

    public  ArrayList<Question> getQuestions (int categoryID){
        setQuestionsToList(getDataBaseQuestions(categoryID));
        return questions;
    }



}

