package mx.com.iavazquezs.animations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fade(View view) {
        ImageView bartImageView = findViewById(R.id.bartImageView);
        bartImageView.animate().alpha(0f).setDuration(2000);
        //bartImageView.animate().translationYBy(1000f).setDuration(2000);

        //ImageView homerImageView = findViewById(R.id.homerImageView);
        //homerImageView.animate().alpha(1f).setDuration(2000);
    }

    public void fadeHomer(View view) {
        ImageView homerImageView = findViewById(R.id.homerImageView);
        homerImageView.animate().alpha(0f).setDuration(2000);

        ImageView bartImageView = findViewById(R.id.bartImageView);
        bartImageView.animate().alpha(1f).setDuration(2000);
    }
}
