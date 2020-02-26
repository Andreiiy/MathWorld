package com.atatar.user.mathworld.Common;

import com.atatar.user.mathworld.Model.CurrentQuestion;
import com.atatar.user.mathworld.Model.Question;
import com.atatar.user.mathworld.QuestionFragment;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Common {

    public static final int TOTAL_TIME = 20 * 60 * 1000; //20min

    public  static int idSelectedCategory;
    public  static String selectedCategory;
    public  static boolean selectedCategoryTest = false;
    public  static List<Question> questionList = new ArrayList<>() ;
    public  static List<CurrentQuestion>  answerSheetList = new ArrayList<>();
    public  static List<CurrentQuestion> currentQuestionList = new ArrayList<>() ;

    public static int right_answer_count = 0;
    public static int wrong_answer_count = 0;
    public static List<QuestionFragment> fragmentsList = new ArrayList<>();
    public static TreeSet<String> selected_values = new TreeSet<>();


    public enum ANSWER_TYPE{

        NO_ANSWER,
        WRONG_ANSWER,
        RIGHT_ANSWER
    }
}
