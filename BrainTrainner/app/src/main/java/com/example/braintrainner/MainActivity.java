package com.example.braintrainner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private TextView sumTextView;
    private TextView resultTextView;
    private TextView pointsTextView;
    private TextView timerTextView;
    private RelativeLayout playRelativeLayout;

    private List<Integer> answers;
    private int locationOfCorrectAnswer;
    private int score = 0;
    private int numberOfQuestions = 0;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button playAgainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.startButton);
        sumTextView = findViewById(R.id.sumTextView);
        resultTextView = findViewById(R.id.resultTextView);
        pointsTextView = findViewById(R.id.pointsTextView);
        timerTextView = findViewById(R.id.timerTextView);
        playAgainButton = findViewById(R.id.playAgainButton);
        playRelativeLayout = findViewById(R.id.playRelativeLayout);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        generateQuestion();
    }

    public void start(View view) {
        startButton.setVisibility(View.INVISIBLE);
        playRelativeLayout.setVisibility(View.VISIBLE);
        playAgain(playAgainButton);
    }

    public void chooseAnswer(View view) {
        Log.i("Tag", (String)view.getTag());

        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))) {
            Log.i("Correct", "Correct");
            score++;

            resultTextView.setText("Correct!!!");
        } else {
            resultTextView.setText("Wrong!!!");
        }

        numberOfQuestions ++;
        pointsTextView.setText(Integer.toString(score) + "/"  + Integer.toString(numberOfQuestions));
        generateQuestion();
    }

    public void generateQuestion() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
        answers = new ArrayList<>();
        locationOfCorrectAnswer = rand.nextInt(4);
        int inCorrectAnswer;
        for (int i= 0; i <4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add((a + b));
            } else {
                inCorrectAnswer = rand.nextInt(41);

                while (inCorrectAnswer == a +b ) {
                    inCorrectAnswer = rand.nextInt(41);
                }
                answers.add(inCorrectAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void playAgain(View view) {
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);

        generateQuestion();

        new CountDownTimer(31000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                timerTextView.setText("0s");
                playAgainButton.setVisibility(View.VISIBLE);
                resultTextView.setText("Your score was" + Integer.toString(score) + "/"  + Integer.toString(numberOfQuestions));
            }
        }.start();


    }
}
