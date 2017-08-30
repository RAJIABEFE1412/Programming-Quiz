package com.planetdev.plquiz;

/**
 * Created by Benjamin on 5/27/2017.
 */

public class JavaQuestionLibrary {
    public String mQuestions [] = {
            "Select option to retrieve the number of elements in code below:" +
                    "\n String mText [] = {\"Ben\", \"Osiwi\"}",

            "Fill in the blanks to calculate sum of myArray\n" +
                    "double sum = 0.0\nfor(int x = 0; x < 4; x__){\nsum += myArray[x];\n}\nSystem.out.println(___);",
            "Dry run the code below:" +
                    "int[]myArr = {6,42,3,7};\nint sum = 0;\nfor(int x = 0; x < myArr.length; x++){\nsum += myArray[x];\n}\nSystem.out.println(sum);",

            "String river = \"Mississipi\";" +
                    "\nriver.toUpperCase();\t MISSISSIPI" +
                    "\nriver.toLowerCase();\t mississipi" +
                    "\nriver.toLowerCase.toUpperCase();" +
                    "\nWhat is the value of river after this calls?",

            "What is the method \'toUpperCase();\' in: \nString upperCased = river.toUpperCase();",

            "What is the output of this program ?" +
                    "\n" +
                    "class test{\n\tint a;\n\tint b;\n\tvoid meth(int i, int j){\n\ti*= 2;\n\tj/=2;\n\t}\n\t}" +
                    "class Output{\n\tpublic static void main(string args[]){\n\ttest obj = new test();\n\tint a = 10;\n\tint b = 20;\n\tobj.meth(a,b);\n\tSystem.out.print(a+\" \"+b);\n\t}\n}"

    };

    private String mChoices [][] = {
            {"mText.indexOf[ ]", "mText.Length", "mText.length"},
            {"-- & sum", "++ & sum", "sum & ++"},
            {"85", "58", "78"},
            {"MISSISSIPI", "mississipi", "Mississipi"},
            {"Modifier", "Mutator", "Accessor"},
            {"10 20", "20 10", "40 20"}
    };

    private String mCorrectAnswer [] = {
            "mText.length",
            "++ & sum",
            "58",
            "Mississipi",
            "Mutator",
            "10 20"
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
