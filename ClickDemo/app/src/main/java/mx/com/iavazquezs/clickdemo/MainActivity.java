package mx.com.iavazquezs.clickdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        Log.i("Info", "Button clicked");
        EditText namePlainText = (EditText)findViewById(R.id.namePlainText);

        Log.i("Name", namePlainText.getText().toString());

    }
}
