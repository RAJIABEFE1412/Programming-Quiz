package com.planetdev.plquiz;

/**
 * Created by Benjamin on 5/27/2017.
 */

public class HtmlQuestionLibrary {
    public String mQuestions [] = {
            "Which of the following tag represents an independent piece of content of a document in HTML5 ?",
            "Which of the following input control represents a date consisting of a year and a month encoded according to ISO 8601 in web form 2.0",
            "Which of the following attribute triggers event when an element is dragged?",
            "Which of the following attribute triggers event when an element is being dragged over a valid drop target?",
            "Which of the following attribute triggers event when the document comes online?"
    };

    private String mChoices [][] = {
            {"Section", "header", "article"},
            {"month", "date", "datetime-local"},
            {"ondragleave", "ondrag", "ondragend"},
            {"ondragleave", "ondrag", "ondragend"},
            {"onloadedmetadata", "onloadstart", "ononline"}
    };

    private String mCorrectAnswer [] = {
            "article",
            "month",
            "ondrag",
            "ondragend",
            "ononline"
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
