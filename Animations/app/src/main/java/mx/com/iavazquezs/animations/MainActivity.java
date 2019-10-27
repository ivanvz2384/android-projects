package mx.com.iavazquezs.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView bartImageView = findViewById(R.id.bartImageView);
        bartImageView.setTranslationX(-1000f);
        bartImageView.setTranslationY(-1000f);


    }

    public void fade(View view) {
        Log.i("INFO", "BART");
        ImageView bartImageView = findViewById(R.id.bartImageView);

        //bartImageView.animate().alpha(0f).setDuration(2000);
        //bartImageView.setVisibility(View.INVISIBLE);

        //bartImageView.animate().translationYBy(1000f).setDuration(2000);

        //bartImageView.animate().translationXBy(1000f).setDuration(2000);
        //bartImageView.animate().rotation(180f).setDuration(2000);

        bartImageView.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);

        /*
        ImageView homerImageView = findViewById(R.id.homerImageView);
        homerImageView.animate().alpha(1f).setDuration(2000);
        homerImageView.setVisibility(View.VISIBLE);

         */
    }

    public void fadeHomer(View view) {
        Log.i("INFO", "HOMER");
        ImageView homerImageView = findViewById(R.id.homerImageView);
        homerImageView.animate().alpha(0f).setDuration(2000);
        homerImageView.setVisibility(View.INVISIBLE);
        ImageView bartImageView = findViewById(R.id.bartImageView);
        bartImageView.animate().alpha(1f).setDuration(2000);
        bartImageView.setVisibility(View.VISIBLE);
    }
}
