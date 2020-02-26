package com.atatar.user.mathworld.Interface;

import com.atatar.user.mathworld.Model.CurrentQuestion;

public interface IQuestion {

    CurrentQuestion getSelectedAnswer();
    void showCorrectAnswer();
    void disableAnswer();
    void resetQuestion();
}
