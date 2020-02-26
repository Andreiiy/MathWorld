package com.atatar.user.mathworld.Model;

public class Question {

    private Integer id;
    private String exercise;
    private String answerCorrect;
    private String answerA;
    private String answerB;
    private String answerD;
    private String answerC;
    private boolean fraction =false;



    public Question(Integer id, String exercise, String answerCorrect, String answerA , String answerB, String answerD, String answerC) {
        this.id = id;
        this.exercise = exercise;
        this.answerCorrect = answerCorrect;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerD = answerD;
        this.answerC = answerC;
    }

    public Question(Integer id, String exercise, String answerCorrect) {
        this.id = id;
        this.exercise = exercise;
        this.answerCorrect = answerCorrect;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getAnswerCorrect() {
        return answerCorrect;
    }

    public void setAnswerCorrect(String answerCorrect) {
        this.answerCorrect = answerCorrect;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public boolean getFraction() {
        return fraction;
    }

    public void setFraction(boolean fraction) {
        this.fraction = fraction;
    }
}
