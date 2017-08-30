package com.planetdev.plquiz;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class HtmlFragment extends Fragment {

    private HtmlQuestionLibrary mHtmlQuestionLibrary = new HtmlQuestionLibrary();

    private TextView mQuestionNumber;
    private TextView mCountDown;

    private  int mNextQuestion = 0;
    private String mAnswer;
    private int mScore;
    private int TotalScore;

    private TextView mQuestionView;
    private RadioButton mChoice0;
    private RadioButton mChoice1;
    private RadioButton mChoice2;

    private RadioGroup mRadioGroup;

    private Button mContinueButton;
    private Button mSubmit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.quiz_layout, container, false);

        // All view are found by their id here
        mQuestionNumber = (TextView) view.findViewById(R.id.questionNumber);
        mCountDown = (TextView) view.findViewById(R.id.countDown);

        mQuestionView = (TextView) view.findViewById(R.id.question);
        mChoice0 = (RadioButton) view.findViewById(R.id.a);
        mChoice1 = (RadioButton) view.findViewById(R.id.b);
        mChoice2 = (RadioButton) view.findViewById(R.id.c);

        mRadioGroup = (RadioGroup) view.findViewById(R.id.radGroup);

        mContinueButton = (Button) view.findViewById(R.id.continueButton);
        mSubmit = (Button) view.findViewById(R.id.submitButton);

        mAnswer = mHtmlQuestionLibrary.getAnswer(mNextQuestion);

        // All methods are been called here
        updateQuestions();
        TimeCountdown();
        onAnyButtonClicked();
        EndQuiz();

        return view;
    }

    public void TimeCountdown(){
        new CountDownTimer(10 * 1000, 1000){
            public void onTick(long millisUntilFinished){
                mCountDown.setText("Time Left: " + String.format("%d min, %d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)))
                );
            }
            public void onFinish(){
                mCountDown.setText("Time Up!");
            }
        }.start();
    }

    public void updateQuestions (){
        mQuestionView.setText(mHtmlQuestionLibrary.getQuestion(mNextQuestion));
        mChoice0.setText(mHtmlQuestionLibrary.getChoice0(mNextQuestion));
        mChoice1.setText(mHtmlQuestionLibrary.getChoice1(mNextQuestion));
        mChoice2.setText(mHtmlQuestionLibrary.getChoice2(mNextQuestion));
    }


    // All my click functions goes here
    public void onAnyButtonClicked(){
        final int[] mQuestionCount = {1};
        mQuestionNumber.setText(mQuestionCount[0] + " of " + mHtmlQuestionLibrary.mQuestions.length);

        // On continue button clicked starts here
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The number of question and the number of questions in the array is being updated here
                mQuestionCount[0]++;

                if(mQuestionCount.length+1 == mHtmlQuestionLibrary.mQuestions.length ){
                    mQuestionNumber.setText(mHtmlQuestionLibrary.mQuestions.length + " of " + mHtmlQuestionLibrary.mQuestions.length);

                }else if(mQuestionCount[0] == mHtmlQuestionLibrary.mQuestions.length ){
                    mQuestionNumber.setText(mHtmlQuestionLibrary.mQuestions.length + " of " + mHtmlQuestionLibrary.mQuestions.length);
                    mContinueButton.setVisibility(View.GONE);
                    mSubmit.setVisibility(View.VISIBLE);
                }else{
                    mQuestionNumber.setText(mQuestionCount[0] + " of " + mHtmlQuestionLibrary.mQuestions.length);
                }
                // Being able to jump to the next question in the array is enabled here.
                if (mNextQuestion < mHtmlQuestionLibrary.getQuestion(mNextQuestion).length()-1){
                    mNextQuestion++;
                }
                mRadioGroup.clearCheck();
                updateQuestions();
                // Each time the button is clicked the method to set another question and answer is trigged by calling this method
            }
        });// On continue button clicked end here

        mSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                TotalScore = (mScore * 100) / mHtmlQuestionLibrary.mQuestions.length;
                Toast.makeText(getActivity(),"You Scored " + TotalScore +"%",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void EndQuiz(){
        /*
        * This methods ends the quiz When the time is up
        * Or when the Submit button is clicked
        * in any of the cases above it takes the user to the score activity
        * */
    }
}
