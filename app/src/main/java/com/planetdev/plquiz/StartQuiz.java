package com.planetdev.plquiz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartQuiz extends Fragment {
    private JavaQuestionLibrary mJsQuestionLibrary = new JavaQuestionLibrary();
    private JavaQuestionLibrary mJavaQuestionLibrary = new JavaQuestionLibrary();
    private HtmlQuestionLibrary mHtmlQuestionLibrary = new HtmlQuestionLibrary();
    private CssQuestionLibrary mCssQuestionLibrary = new CssQuestionLibrary();

    private LinearLayout javaLayout, htmlLayout, cssLayout, jsLayout;

    AppCompatActivity activity;
    ActionBar actionBar;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    TextView javaQuestion, javaTime, jsQuestion, jsTime, cssQuestion, cssTime, htmlQuestion, htmlTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_quiz, container, false);

        activity = (AppCompatActivity) getActivity();
        actionBar = activity.getSupportActionBar();

        javaLayout = (LinearLayout) view.findViewById(R.id.start_java);
        jsLayout = (LinearLayout) view.findViewById(R.id.start_js);
        htmlLayout = (LinearLayout) view.findViewById(R.id.start_html);
        cssLayout = (LinearLayout) view.findViewById(R.id.start_css);

        javaQuestion = (TextView) view.findViewById(R.id.javaQuestion);
        jsQuestion = (TextView) view.findViewById(R.id.jsQuestion);
        htmlQuestion = (TextView) view.findViewById(R.id.htmlQuestion);
        cssQuestion = (TextView) view.findViewById(R.id.cssQuestion);


        javaTime = (TextView) view.findViewById(R.id.javaTime);
        jsTime = (TextView) view.findViewById(R.id.jsTime);
        htmlTime = (TextView) view.findViewById(R.id.htmlTime);
        cssTime = (TextView) view.findViewById(R.id.cssTime);

        StartScreen();
        getQuestionAndTime();
        return view;
    }
    public void getQuestionAndTime(){
        String query = "Query: ";
        String secs = "Secs";

        jsQuestion.setText(query + mJsQuestionLibrary.mQuestions.length);
        javaQuestion.setText(query + mJavaQuestionLibrary.mQuestions.length);
        htmlQuestion.setText(query + mHtmlQuestionLibrary.mQuestions.length);
        cssQuestion.setText(query + mCssQuestionLibrary.mQuestions.length);

        javaTime.setText("60 " + secs);
        jsTime.setText("50 " + secs);
        htmlTime.setText("0 " + secs);
        cssTime.setText("0 " + secs);
    }
    public void StartScreen(){
        javaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content, new JavaFragment());
                fragmentTransaction.commit();
                actionBar.setTitle("Java");
            }
        });

        jsLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content, new JsFragment());
                fragmentTransaction.commit();
                actionBar.setTitle("JavaScript");
            }
        });

        cssLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content, new CssFragment());
                fragmentTransaction.commit();
                actionBar.setTitle("CSS 3");
            }
        });

        htmlLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragmentManager = getFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_content, new HtmlFragment());
                fragmentTransaction.commit();
                actionBar.setTitle("HTML 5");
            }
        });
    }
}
