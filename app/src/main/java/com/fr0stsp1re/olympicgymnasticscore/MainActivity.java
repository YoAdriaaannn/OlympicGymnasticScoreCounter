package com.fr0stsp1re.olympicgymnasticscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

import java.text.DecimalFormat;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    // Set up SeekBar for each scoring metric.

    public SeekBar strengthA, styleA, performanceA, strengthB, styleB, performanceB = null;

    private TextView strengthScoreA, styleScoreA, performanceScoreA, teamAScore, strengthScoreB, styleScoreB, performanceScoreB, teamBscore, teamAPlayerNumber, teamBPlayerNumber, finalAverageScore;

    private float convertedProgressStrengthA = 0.0f;
    private float convertedProgressStyleA = 0.0f;
    private float convertedProgressPerformanceA = 0.0f;

    private float convertedProgressStrengthB = 0.0f;
    private float convertedProgressStyleB = 0.0f;
    private float convertedProgressPerformanceB = 0.0f;

    // Set up arrays to hold scores for each team. Olympic gymnastic teams have 6 on each team.

    private float arrayScoreTeamA[];
    private float arrayScoreTeamB[];

    // set up index for arrays
    private int indexTeamA = 0;
    private int indexTeamB = 0;

    private float averageScoreTeamA = 0;
    private float averageScoreTeamB = 0;

    // This is used to format our scoring system to one decimal place.
    DecimalFormat onePoint = new DecimalFormat("#.#");

    private CountryCodePicker countryTeamA, countryTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init country code pickers
        countryTeamA = findViewById(R.id.ccp_team_a);
        countryTeamB = findViewById(R.id.ccp_team_b);


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


        //init TextViews for team A and B. These display scoring values for each attribute of the score and also handles the display of team  scores

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


        // Init TextViews for final average score of both teams

        finalAverageScore = findViewById(R.id.textView_final_score);


        // Initialize arrays that hold the score for each player. These serve as a stack for each team and allow for a re-score

        arrayScoreTeamA = new float[6];
        arrayScoreTeamB = new float[6];

        /**
         *  Start team A slider controls to set scores for each player. Challenge: Gymnastics uses a one point decimal scoring system. Our sliders can only deal with integers.
         *  Workaround: set sliders to 100 amd step by 10. Multiply that value by our float of .10 so we can come up with traditional scoring values for gymnastics which are based
         *  on a 10 point system and 1/10 a point is deducted from your overall 10 for every thing the judges will dock a contestant on. Later on I format the decimal to 1 place using
         *  the DecimalFormat class
         */

        // Set up the listener for change in  team A strength slider

        strengthA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // This is used to store the progress of the slider
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                progressChanged = progress;
                convertedProgressStrengthA = .10f * progressChanged;
                strengthScoreA.setText(String.valueOf(onePoint.format(convertedProgressStrengthA)));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressStrengthA = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressStrengthA,
                        Toast.LENGTH_SHORT).show();

                strengthScoreA.setText(String.valueOf(onePoint.format(convertedProgressStrengthA)));
            }
        });


        // Set up the listener for change in  team A style slider

        styleA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressStyleA = .10f * progressChanged;

                styleScoreA.setText(String.valueOf(onePoint.format(convertedProgressStyleA)));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressStyleA = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressStyleA,
                        Toast.LENGTH_SHORT).show();

                styleScoreA.setText(String.valueOf(onePoint.format(convertedProgressStyleA)));
            }
        });


        // Set up the listener for change in  team A performance slider

        performanceA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressPerformanceA = .10f * progressChanged;

                performanceScoreA.setText(String.valueOf(onePoint.format(convertedProgressPerformanceA)));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressPerformanceA = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressPerformanceA,
                        Toast.LENGTH_SHORT).show();

                performanceScoreA.setText(String.valueOf(onePoint.format(convertedProgressPerformanceA)));
            }
        });


        /**
         * Start team b controls to set score for each player. This is set up just like team A in the above methods.
         */


        // Set up the listener for change in  team B strength slider
        strengthB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressStrengthB = .10f * progressChanged;
                strengthScoreB.setText(String.valueOf(onePoint.format(convertedProgressStrengthB)));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressStrengthB = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressStrengthB,
                        Toast.LENGTH_SHORT).show();

                strengthScoreB.setText(String.valueOf(onePoint.format(convertedProgressStrengthB)));
            }
        });


        // Set up the listener for change in  team B style slider
        styleB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressStyleB = .10f * progressChanged;
                styleScoreB.setText(String.valueOf(onePoint.format(convertedProgressStyleB)));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressStyleB = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressStyleB,
                        Toast.LENGTH_SHORT).show();

                styleScoreB.setText(String.valueOf(onePoint.format(convertedProgressStyleB)));
            }
        });


        // Set up the listener for change in  team B performance slider
        performanceB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;


            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChanged = progress;
                convertedProgressPerformanceB = .10f * progressChanged;
                performanceScoreB.setText(String.valueOf(onePoint.format(convertedProgressPerformanceB)));

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {

                convertedProgressPerformanceB = .10f * progressChanged;
                Toast.makeText(MainActivity.this, "seek bar progress:" + convertedProgressPerformanceB,
                        Toast.LENGTH_SHORT).show();

                performanceScoreB.setText(String.valueOf(onePoint.format(convertedProgressPerformanceB)));
            }
        });


        startApp(null);
    }

    public void startApp(View v) {

        indexTeamA = 0;
        indexTeamB = 0;
        averageScoreTeamA = 0;
        averageScoreTeamB = 0;

        // Trick display to read index 0 as 1 by adding 1 to the string output
        teamAPlayerNumber.setText("Gymnast number: " + (indexTeamA + 1));
        teamBPlayerNumber.setText("Gymnast number: " + (indexTeamB + 1));
        teamAScore.setText(String.valueOf(onePoint.format(averageScoreTeamA)));
        teamBscore.setText(String.valueOf(onePoint.format(averageScoreTeamB)));

        strengthA.setProgress(100);
        styleA.setProgress(100);
        performanceA.setProgress(100);
        strengthB.setProgress(100);
        styleB.setProgress(100);
        performanceB.setProgress(100);

    }

    /**
     * Calculate average score of the three values for team A the judges use to score a contestant. Round the values to one decimal place.
     */
    public void calculateAverageScoreTeamA(View view) {


        averageScoreTeamA = (convertedProgressPerformanceA + convertedProgressStrengthA + convertedProgressStyleA) / 3;

        teamAScore.setText(String.valueOf(onePoint.format(averageScoreTeamA)));
        // Store average in array to be called later for total team average.
        arrayScoreTeamA[indexTeamA] = averageScoreTeamA;

    }

    /**
     * Calculate average score of the three values for team B the judges use to score a contestant. Round the values to one decimal place.
     */

    public void calculateAverageScoreTeamB(View view) {


        averageScoreTeamB = (convertedProgressPerformanceB + convertedProgressStrengthB + convertedProgressStyleB) / 3;
        teamBscore.setText(String.valueOf(onePoint.format(averageScoreTeamB)));
        // Store average in array to be called later for total team average.
        arrayScoreTeamB[indexTeamB] = averageScoreTeamB;


    }

    /**
     * Move the team contestants back and forth through the arrayScoreTeamA which stores the scores for each player. This provides a way to undo scores by over writing them with new
     * <p>
     * ones.
     */

    //  Team A player navigation

    // Move forward through index
    public void forwardTeamA(View view) {

        // Check if we are still within the 6 contestants if so advance index
        if (indexTeamA >= 5) {

            // Error handling if we go out of bounds.
            Toast.makeText(this, "There are only 6 gymnasts in an Olympic event", Toast.LENGTH_SHORT).show();
            teamAScore.setText(String.valueOf(onePoint.format(arrayScoreTeamA[indexTeamA])));
            endMatch();

        } else {


            indexTeamA++;

            // Set header to show team player number. Since we have 6 gymnasts and the index starts at zero I add 1 to the display so it appears as 1 - 6
            teamAPlayerNumber.setText("Gymnast number: " + (indexTeamA + 1));

            //Set score to the current score stored in the index for arrayScoreTeamA
            teamAScore.setText(String.valueOf(onePoint.format(arrayScoreTeamA[indexTeamA])));

            // Reset sliders to value of 100 which appears as a 10 through conversion
            strengthA.setProgress(100);
            styleA.setProgress(100);
            performanceA.setProgress(100);

        }
    }

    // Move backwards through index

    public void backwardTeamA(View view) {

        // Check to see if we are within index bounds
        if (indexTeamA <= 0) {
            Toast.makeText(this, "You are at the start of the list", Toast.LENGTH_SHORT).show();
            teamAScore.setText(String.valueOf(onePoint.format(arrayScoreTeamA[indexTeamA])));
        } else {
            // Step backwards through index
            indexTeamA = indexTeamA - 1;
            // Set the scoreboard to the current score stored in the current index

            teamAScore.setText(String.valueOf(onePoint.format(arrayScoreTeamA[indexTeamA])));

            // Reset all sliders to 100 which appear as a 10 through conversion
            strengthA.setProgress(100);
            styleA.setProgress(100);
            performanceA.setProgress(100);

            // Set header to display current contestant
            teamAPlayerNumber.setText("Gymnast number: " + (indexTeamA + 1));
        }


    }


    // Team B player navigation

    public void forwardTeamB(View view) {
        if (indexTeamB >= 5) {

            Toast.makeText(this, "There are only 6 gymnasts in an Olympic event", Toast.LENGTH_SHORT).show();
            endMatch();
        } else {


            indexTeamB++;
            teamBPlayerNumber.setText("Gymnast number: " + (indexTeamB + 1));

            teamBscore.setText(String.valueOf(onePoint.format((arrayScoreTeamB[indexTeamB]))));

            strengthB.setProgress(100);
            styleB.setProgress(100);
            performanceB.setProgress(100);

        }
    }

    public void backwardTeamB(View view) {
        if (indexTeamB <= 0) {
            Toast.makeText(this, "You are at the start of the list", Toast.LENGTH_SHORT).show();
        } else {
            indexTeamB = indexTeamB - 1;
            teamBscore.setText(String.valueOf(onePoint.format((arrayScoreTeamB[indexTeamB]))));

            strengthB.setProgress(100);
            styleB.setProgress(100);
            performanceB.setProgress(100);

            teamBPlayerNumber.setText("Gymnast number: " + (indexTeamB + 1));
        }


    }

    // End match

    public void endMatch() {

        // Set up to floats to hold the average score
        float totalAverageForAllGymnastsTeamA = 0;
        float totalAverageForAllGymnastsTeamB = 0;

        // Loop through the score holding arrays the amount of members per each team. This number is 6 according to olympic rules.

        for (int i = 0; i < 6; i++) {

            // Add the totals of each array index together

            totalAverageForAllGymnastsTeamA = totalAverageForAllGymnastsTeamA + arrayScoreTeamA[i];
            totalAverageForAllGymnastsTeamB = totalAverageForAllGymnastsTeamB + arrayScoreTeamB[i];

        }

        // Exit the loop and divide by 6 to get total average for each team

        totalAverageForAllGymnastsTeamA = totalAverageForAllGymnastsTeamA / 6;
        totalAverageForAllGymnastsTeamB = totalAverageForAllGymnastsTeamB / 6;

        // Display the averages. Change the score header text and display a message at bottom of screen.

        teamAPlayerNumber.setText("Final average score:");
        teamAScore.setText(String.valueOf(onePoint.format(totalAverageForAllGymnastsTeamA)));
        teamBPlayerNumber.setText("Final average score:");
        teamBscore.setText(String.valueOf(onePoint.format(totalAverageForAllGymnastsTeamB)));

        String teamAFlag = countryTeamA.getSelectedCountryName().toString();
        String teamBFlag = countryTeamB.getSelectedCountryName().toString();

        finalAverageScore.setText("The final average score for the "  + teamAFlag + " team is: " + onePoint.format(totalAverageForAllGymnastsTeamA) + "\n" + "The final average score for the " + teamBFlag  + " team is: " + onePoint.format((totalAverageForAllGymnastsTeamB)));


    }


}
