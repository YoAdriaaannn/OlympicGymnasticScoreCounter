package com.fr0stsp1re.olympicgymnasticscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // Set up SeekBar for each scoring metric.

    public SeekBar strengthA, styleA, performanceA, strengthB, styleB, performanceB = null;

    private TextView strengthScoreA, styleScoreA, performanceScoreA, teamAScore, strengthScoreB, styleScoreB, performanceScoreB, teamBscore, teamAPlayerNumber, teamBPlayerNumber;

    public float convertedProgressStrengthA = 0.0f;
    public float convertedProgressStyleA = 0.0f;
    public float convertedProgressPerformanceA = 0.0f;

    public float convertedProgressStrengthB = 0.0f;
    public float convertedProgressStyleB = 0.0f;
    public float convertedProgressPerformanceB = 0.0f;

    // Set up arrays to hold scores for each team. Olympic gymnastic teams have 6 on each team.

    public float arrayScoreTeamA[];
    public float arrayScoreTeamB[];

    // set up index for arrays
    private int indexTeamA = 0;
    private int indexTeamB = 0;

    public float averageScoreTeamA =0;
    public float averageScoreTeamB =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //init the SeekBars team A
        strengthA = findViewById(R.id.seekBar_team_a_strength);
        strengthA.setProgress(100);
        strengthA.setMax(100);
        strengthA.incrementProgressBy(10);

        styleA = findViewById(R.id.seekBar_team_a_style);
        styleA.setProgress(100);
        styleA.setMax(100);
        styleA.incrementProgressBy(10);


        performanceA = findViewById(R.id.seekBar_team_a_performance);
        performanceA.setProgress(100);
        performanceA.setMax(100);
        performanceA.incrementProgressBy(10);


        //init the SeekBars team B


        strengthB = findViewById(R.id.seekBar_team_b_strength);
        strengthB.setProgress(100);
        strengthB.setMax(100);
        strengthB.incrementProgressBy(10);

        styleB = findViewById(R.id.seekBar_team_b_style);
        styleB.setProgress(100);
        styleB.setMax(100);
        styleB.incrementProgressBy(10);


        performanceB = findViewById(R.id.seekBar_team_b_performance);
        performanceB.setProgress(100);
        performanceB.setMax(100);
        performanceB.incrementProgressBy(10);



        //init TextViews
        strengthScoreA = findViewById(R.id.team_a_strength_score);
        styleScoreA = findViewById(R.id.team_a_style_score);
        performanceScoreA = findViewById(R.id.team_a_performance_score);
        teamAScore = findViewById(R.id.team_a_score);
        teamAPlayerNumber = findViewById(R.id.team_a_tag);


        strengthScoreB = findViewById(R.id.team_b_strength_score);
        styleScoreB = findViewById(R.id.team_b_style_score);
        performanceScoreB = findViewById(R.id.team_b_performance_score);
        teamBscore = findViewById(R.id.team_b_score);
        teamBPlayerNumber = findViewById(R.id.team_b_tag);



        // init arrays
        arrayScoreTeamA = new float[6];
        arrayScoreTeamB = new float[6];


        // Set up the listener for change in  team A strength slider
        strengthA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressStrengthA = .10f * progressChanged;
                strengthScoreA.setText(String.valueOf(convertedProgressStrengthA));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressStrengthA = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressStrengthA,
                        Toast.LENGTH_SHORT).show();

                strengthScoreA.setText(String.valueOf(convertedProgressStrengthA));
            }
        });


        // Set up the listener for change in  team A style slider
        styleA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressStyleA = .10f * progressChanged;
                styleScoreA.setText(String.valueOf(convertedProgressStyleA));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressStyleA = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressStyleA,
                        Toast.LENGTH_SHORT).show();

                styleScoreA.setText(String.valueOf(convertedProgressStyleA));
            }
        });


        // Set up the listener for change in  team A performance slider
        performanceA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressPerformanceA = .10f * progressChanged;
                performanceScoreA.setText(String.valueOf(convertedProgressPerformanceA));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressPerformanceA = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressPerformanceA,
                        Toast.LENGTH_SHORT).show();

                performanceScoreA.setText(String.valueOf(convertedProgressPerformanceA));
            }
        });


        /**
         * Start team b controls
         */


        // Set up the listener for change in  team B strength slider
        strengthB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressStrengthB = .10f * progressChanged;
                strengthScoreB.setText(String.valueOf(convertedProgressStrengthB));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressStrengthB = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressStrengthB,
                        Toast.LENGTH_SHORT).show();

                strengthScoreB.setText(String.valueOf(convertedProgressStrengthB));
            }
        });


        // Set up the listener for change in  team B style slider
        styleB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressStyleB = .10f * progressChanged;
                styleScoreB.setText(String.valueOf(convertedProgressStyleB));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressStyleB = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressStyleB,
                        Toast.LENGTH_SHORT).show();

                styleScoreB.setText(String.valueOf(convertedProgressStyleB));
            }
        });


        // Set up the listener for change in  team B performance slider
        performanceB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressPerformanceB = .10f * progressChanged;
                performanceScoreB.setText(String.valueOf(convertedProgressPerformanceB));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressPerformanceB = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressPerformanceB,
                        Toast.LENGTH_SHORT).show();

                performanceScoreB.setText(String.valueOf(convertedProgressPerformanceB));
            }
        });













        startApp( null);
    }

    public void startApp(View v) {

        indexTeamA = 0;
        indexTeamB = 0;
        averageScoreTeamA =0;
        averageScoreTeamB =0;

        teamAPlayerNumber.setText("Gymnast number: " + indexTeamA);
        teamBPlayerNumber.setText("Gymnast number: " + indexTeamB);
        teamAScore.setText(String.valueOf(averageScoreTeamA));
        teamBscore.setText(String.valueOf(averageScoreTeamB));

        strengthA.setProgress(100);
        styleA.setProgress(100);
        performanceA.setProgress(100);
        strengthB.setProgress(100);
        styleB.setProgress(100);
        performanceB.setProgress(100);

    }

    public void calculateAverageScoreTeamA(View view) {


        averageScoreTeamA = (convertedProgressPerformanceA + convertedProgressStrengthA + convertedProgressStyleA) / 3;
        // averageScoreTeamA = Math.round(averageScoreTeamA / 100.0) * 10;
        teamAScore.setText(String.valueOf(averageScoreTeamA));

    }


    public void calculateAverageScoreTeamB(View view) {


        averageScoreTeamB = (convertedProgressPerformanceB + convertedProgressStrengthB + convertedProgressStyleB) / 3;
        // averageScoreTeamB = Math.round(averageScoreTeamB / 100.0) * 10;
        teamBscore.setText(String.valueOf(averageScoreTeamB));

    }

    public void forwardTeamA (View view){
        if (indexTeamA <= 5){
            indexTeamA ++;
            teamAPlayerNumber.setText("Gymnast number: " + indexTeamA);
        }
        else{
            Toast.makeText(this, "There are only 6 contestants in this event", Toast.LENGTH_SHORT).show();
        }
    }

    public void backwardTeamA(View view){
        if (indexTeamA <=0){
            Toast.makeText(this, "You are at the start of the list", Toast.LENGTH_SHORT).show();
        }

        else{
            indexTeamA = indexTeamA - 1;
            teamAPlayerNumber.setText("Gymnast number: " + indexTeamA);
        }


    }




    // Team B player navigation

    public void forwardTeamB (View view){
        if (indexTeamB <= 5){
            indexTeamB ++;
            teamBPlayerNumber.setText("Gymnast number: " + indexTeamB);
        }
        else{
            Toast.makeText(this, "There are only 6 contestants in this event", Toast.LENGTH_SHORT).show();
        }
    }

    public void backwardTeamB(View view){
        if (indexTeamB <=0){
            Toast.makeText(this, "You are at the start of the list", Toast.LENGTH_SHORT).show();
        }

        else{
            indexTeamB = indexTeamB - 1;
            teamBPlayerNumber.setText("Gymnast number: " + indexTeamB);
        }


    }

}
