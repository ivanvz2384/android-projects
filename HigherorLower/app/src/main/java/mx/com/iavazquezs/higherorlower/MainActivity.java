package mx.com.iavazquezs.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Integer numberGenerated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();

        numberGenerated =  rand.nextInt(20) + 1;
        Log.i("The number is", numberGenerated.toString());
    }

    public void guessNumber(View view) {
        EditText numberGuessedEditText = findViewById(R.id.numberGuessedEditText);

        int yourNumber = Integer.valueOf(numberGuessedEditText.getText().toString());

        if (yourNumber > numberGenerated) {
            Toast.makeText(MainActivity.this, "The number is lower", Toast.LENGTH_SHORT).show();
        } else if (yourNumber < numberGenerated) {
            Toast.makeText(MainActivity.this, "The number is higher", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "You made it!!!", Toast.LENGTH_SHORT).show();
            numberGenerated =  (int) Math.random() * 20 ;
        }

    }
}
