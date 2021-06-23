package com.hfad.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    private TextView questionTV, questionNumberTV;
    private Button option1Btn, option2Btn, option3btn, option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v){
             if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                 currentScore++;

             }
             questionAttempted++;
             currentPos = random.nextInt(quizModalArrayList.size());
             setDataToViews(currentPos);
         }

        });





        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;

                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }


        });

           option3btn.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3btn.getText().toString().trim().toLowerCase())) {
                       currentScore++;

                   }
                   questionAttempted++;
                   currentPos = random.nextInt(quizModalArrayList.size());
                   setDataToViews(currentPos);
               }
    });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;

                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });








    }

        private void setDataToViews(int currentPos){
        questionNumberTV.setText("Questions Attempted :  " + questionAttempted + "/10");
        if(questionAttempted == 10) {
            showBottomSheet();
        } else {
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());

        }

    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        //inflate the layout
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVscore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your score is \n" + currentScore + "/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }

        });

        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void getQuizQuestion(ArrayList<QuizModal> QuizModelArrayList) {
        quizModalArrayList.add(new QuizModal("Where is the busiest airport?",  "Chicago International", "Heathrow", "Newark", "All of the above",  "Heathrow"));
        quizModalArrayList.add(new QuizModal("What plane can fly the highest?",  "SR-71", "Airbus A380", "747",  "F-18 Hornet",  "SR-71"));
        quizModalArrayList.add(new QuizModal("What are airplane tires filled with?",  "Beer", "Nitrogen", "Helium",  "Compressed air",  "Nitrogen"));
        quizModalArrayList.add(new QuizModal("Year of the first supersonic flight?",  "1947", "1959", "1973",  "1983",  "1947"));


    }
}