package mx.com.iavazquezs.textfielddemo;

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

    public void doLogin(View view) {
        EditText userNameEditText = (EditText)findViewById(R.id.userNameEditText);
        EditText passwordEditText = (EditText)findViewById(R.id.passwordEditText);
        Log.i("INFO", "The user is" +  userNameEditText.getText());
        Log.i("INFO", "The password is" +  passwordEditText.getText());
    }
}
