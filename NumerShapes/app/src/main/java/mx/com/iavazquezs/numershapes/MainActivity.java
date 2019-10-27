package mx.com.iavazquezs.numershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import mx.com.iavazquezs.numershapes.mx.com.iavazquezs.numershapes.util.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkNumber(View view) {
        EditText numberEditText = findViewById(R.id.numberEditText);
        String message = "";

        if(numberEditText.getText().toString().isEmpty()) {
            message = "Please enter a number";
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            return;
        }

        Util util = new Util();
        util.setMyNumber(Integer.parseInt(numberEditText.getText().toString()));



        if (util.isSquare()) {
            if (util.isTriangular()) {
                message = util.getMyNumber()  + " is both triangular and square";
            } else {
                message = util.getMyNumber()  + " is square but not triangular";
            }
        } else {
            if (util.isTriangular()) {
                message = util.getMyNumber()  + " is triangular but not square";
            } else {
                message = util.getMyNumber()  + " is neather square nor triangular";
            }
        }

        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

    }
}
