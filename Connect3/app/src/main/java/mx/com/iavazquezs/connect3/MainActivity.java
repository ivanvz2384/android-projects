package mx.com.iavazquezs.connect3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    //0 = yellow 1 = red
    private int activePlayer = 0;

    private boolean gameIsActive = true;
    // 2 = unplayed
    private int[] gameState= {2,2,2,2,2,2,2,2,2};

    private int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropin(View view) {
        ImageView counter = (ImageView)view;
        String tag = counter.getTag().toString();
        Log.i("INFO", tag);
        int tappedCounter = Integer.parseInt(tag);

        if(gameState[tappedCounter] == 2 && gameIsActive) {
            gameState[tappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360f).setDuration(300);

            for(int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                && gameState[winningPosition[0]] != 2) {
                    gameIsActive = false;
                    Log.i("INFO", "Someone has won" + gameState[winningPosition[0]]);
                    String winner = "Red";
                    if (gameState[winningPosition[0]] == 0) {
                        winner = "Yellow";
                    }
                    TextView winnerMessage = findViewById(R.id.winnerMessageEditText);
                    winnerMessage.setText(winner + " has won!");
                    LinearLayout layout = findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                } else {
                    boolean gameIsOver = true;
                    for(int counterState: gameState) {
                        if (counterState == 2) {
                            gameIsOver = false;
                        }
                    }

                    if(gameIsOver) {
                        TextView winnerMessage = findViewById(R.id.winnerMessageEditText);
                        winnerMessage.setText("It's a draw");
                        LinearLayout layout = findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }

    }

    public void playAgain(View view){
        Log.i("INFO", "A new game has started");
        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);

        activePlayer = 0;
        gameIsActive = true;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }

        GridLayout myGridLayout = (GridLayout)findViewById(R.id.myGridLayout);

        for(int i = 0; i < myGridLayout.getChildCount(); i++) {
            View viewChild = myGridLayout.getChildAt(i);

            if (viewChild instanceof  ImageView) {
                ImageView iv = (ImageView)viewChild;
                iv.setImageResource(0);
            }
        }

    }


}
