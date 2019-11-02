package mx.com.iavazquezs.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createUsersDb();
    }

    private void createEvents() {
        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Events", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS events(event VARCHAR, year INT(4))");

            myDatabase.execSQL("INSERT INTO events (event, year) VALUES ('End of WW2', 1945)");
            myDatabase.execSQL("INSERT INTO events (event, year) VALUES ('Wham split up', 1986)");



            Cursor c = myDatabase.rawQuery("SELECT * FROM events", null);

            int nameIndex = c.getColumnIndex("event");
            int ageIndex = c.getColumnIndex("year");

            c.moveToFirst();

            while(c != null) {
                Log.i("event", c.getString(nameIndex));
                Log.i("year",Integer.toString(c.getInt(ageIndex)));
                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createUsersDb() {
        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR, age INT(3))");
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers(id INT(5) PRIMARY KEY, name VARCHAR, age INT(3))");

            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Danna', 3)");
            myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Iker', 2)");

            //myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Danna', 3)");
            //myDatabase.execSQL("INSERT INTO users (name, age) VALUES ('Iker', 2)");

            //myDatabase.execSQL("DELETE FROM users WHERE name ='Ivan' LIMIT 1");

            //myDatabase. execSQL("UPDATE users SET age = 17 WHERE name = 'Iker'");

            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers", null);

            int idIndex = c.getColumnIndex("id");
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");

            c.moveToFirst();

            while(c != null) {
                Log.i("id", String.valueOf(c.getInt(idIndex)));
                Log.i("name", c.getString(nameIndex));
                Log.i("age",Integer.toString(c.getInt(ageIndex)));
                c.moveToNext();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
