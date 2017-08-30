package com.planetdev.plquiz;

/**
 * Created by Benjamin on 5/27/2017.
 */

public class JsQuestionLibrary {
    public String mQuestions [] = {
            "By entering \nvar example = new Array();\nwe create an empty array which can be filled...",

            "What is the output of this code? \n<div id=\"test\">\n<p>some text</p>\n</div>" +
                    "\n<script>\nvar el=document.getElementById(test);\nalert(el.hasChildNodes());\n</script>",

            "Please associate the \"testDate\" constructor function below with a method called \"myMethod\":" +
                    "\nfunction testData (first, second){\nthis.first = first;\nthis.second = second;\nthis.checkData = _______;\n}",

            "In order to use the object's properties within a function, use:",
            "If today was friday wat will the day be in 100 days"
    };

    private String mChoices [][] = {
            {"just after it", "anytime later", "never more"},
            {"false", "undefined", "true"},
            {"method;", "myMethod;", "myMethod"},
            {"The \"var\" keyword", "Just the name of the property","The \"this\" keyword"},
            {"Wednesday", "Thursday", "Tuesday"}
    };

    public String mCorrectAnswer [] = {
            "anytime later",
            "true",
            "myMethod",
            "The \"this\" keyword",
            "Thursday"
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
