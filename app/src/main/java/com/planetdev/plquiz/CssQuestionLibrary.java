package com.planetdev.plquiz;

/**
 * Created by Benjamin on 5/27/2017.
 */

public class CssQuestionLibrary {
    public String mQuestions [] = {
            "",
            "",
            ""
    };

    private String mChoices [][] = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
    };

    private String mCorrectAnswer [] = {
            "",
            "",
            ""
    };

    public String getQuestion(int a){
        String question = mQuestions [a];
        return question;
    }

    public String getChoice0 (int a){
        String choice0 = mChoices [a][0];
        return choice0;
    }
    public String getChoice1 (int a){
        String choice1 = mChoices [a][1];
        return choice1;
    }
    public String getChoice2 (int a){
        String choice2 = mChoices [a][2];
        return choice2;
    }

    public String getAnswer(int a){
        String answer = mCorrectAnswer [a];
        return answer;
    }
}
