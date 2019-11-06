package mx.com.iavazquezs.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    private Boolean signUpModeActive = true;
    private TextView changeSingupModetextView;
    private EditText passwordEditText;
    private EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Instagram");

        changeSingupModetextView = findViewById(R.id.changeSingupModetextView);
        changeSingupModetextView.setOnClickListener(this);
        usernameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        RelativeLayout backgroundRelativeLayout = findViewById(R.id.backgroundRelativeLayout);
        ImageView logoImageView = findViewById(R.id.logoImageView);

        backgroundRelativeLayout.setOnClickListener(this);
        logoImageView.setOnClickListener(this);

        passwordEditText.setOnClickListener(this);

        if (ParseUser.getCurrentUser() != null) {
            showUserList();
        }

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }

    public void signUp(View view) {
        if (usernameEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Username and password are required", Toast.LENGTH_SHORT).show();
        } else {
            if (signUpModeActive) {
                ParseUser user = new ParseUser();
                user.setUsername(usernameEditText.getText().toString().trim());
                user.setPassword(passwordEditText.getText().toString().trim());


                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e == null) {
                            Log.i("Signup", "Succesful");
                            showUserList();
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                ParseUser.logInInBackground(usernameEditText.getText().toString().trim(), passwordEditText.getText().toString().trim(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if(user != null) {
                            Log.i("Login", "Succesful");
                            showUserList();
                        } else {
                            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.changeSingupModetextView){
            Button signUpButton = findViewById(R.id.signUpButton);
            if (signUpModeActive) {
                signUpModeActive = false;
                signUpButton.setText("Login");
                changeSingupModetextView.setText(("Or, Signup"));
            } else {
                signUpModeActive = true;
                signUpButton.setText("Signup");
                changeSingupModetextView.setText(("Or, Login"));
            }
        } else if (v.getId() == R.id.backgroundRelativeLayout || v.getId() == R.id.logoImageView) {
            InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
            signUp(v);
        }
        return false;
    }

    public void showUserList() {
        Intent intent = new Intent(getApplicationContext(), UserListActivity.class);
        startActivity(intent);
    }
}
