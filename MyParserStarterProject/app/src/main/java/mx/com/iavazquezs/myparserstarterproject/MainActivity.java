package mx.com.iavazquezs.myparserstarterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseUser.logOut();

        if (ParseUser.getCurrentUser() != null) {
            Log.i("currentUser", "User logged in " + ParseUser.getCurrentUser().getUsername());
        } else {
            Log.i("currentUser", "Not logged in");
        }

        //Login an user
        /*
        ParseUser.logInInBackground("iavazquezs", "Pass", new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    Log.i("Login", "Succesful");
                } else {
                    Log.i("Login", "Failed" + e.toString());
                }
            }
        });


         */

        //Create an user
        /*
        ParseUser user = new ParseUser();
        user.setUsername("iavazquezs");
        user.setPassword("Pa$$w0rd");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    Log.i("Sig up", "Succesful");
                } else {
                    Log.i("Sig up", "Fail");
                }
            }
        });

         */

        /*
        //Update score
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
        query.whereGreaterThan("score", 200);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null && objects != null) {
                    Log.i("findInBackground", "Retrieve " + objects.size() +  " objects");
                    if (objects.size() > 0) {
                        for(ParseObject object : objects) {
                            object.put("score", object.getInt("score") + 50);
                            object.saveInBackground();
                            Log.i("findInBackgroundResult", object.toString());
                        }
                    }
                }
            }
        });

        */

        /*
        //Se filtra por username
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
        query.whereEqualTo("username", "iavazquezs");
        query.setLimit(1);

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    Log.i("findInBackground", "Retrieve " + objects.size() +  " objects");
                    if (objects.size() > 0) {
                        for(ParseObject object : objects) {
                            Log.i("findInBackgroundResult", object.toString());
                        }
                    }
                }
            }
        });
         */

        /*
        //Se inserta unos valores en la clase Score
        ParseObject score = new ParseObject("Score");
        score.put("username", "iavazquezs");
        score.put("score", 86);
        score.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    Log.i("saveInBackground", "Successful");
                } else {
                    Log.i("saveInBackground", "Failed" + e.toString());
                }
            }
        });
        */

        /*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");
        query.getInBackground("DXFXGvmhO4", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e == null && object != null) {
                    object.put("score", 200);
                    object.saveInBackground();
                    Log.i("Object Value", object.getString("username"));
                    Log.i("Object Value", String.valueOf(object.getInt("score")));
                } else {
                    Log.i("Object Value", "Failed" + e.toString());
                }
            }
        });
         */

        /*
        ParseObject score = new ParseObject("Tweet");
        score.put("username", "iavazquezs");
        score.put("tweet", "Hi there.This is my first tweet");
        score.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    Log.i("saveInBackground", "Successful");
                } else {
                    Log.i("saveInBackground", "Failed" + e.toString());
                }
            }
        });
         */


        /*
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");
        query.getInBackground("GtlDqxdmuF", new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject object, ParseException e) {
                if(e == null && object != null) {
                    //object.put("score", 200);
                    //object.saveInBackground();
                    Log.i("Object Value", object.getString("username"));
                    Log.i("Object Value", object.getString("tweet"));
                } else {
                    Log.i("Object Value", "Failed" + e.toString());
                }
            }
        });
         */
        ParseAnalytics.trackAppOpenedInBackground(getIntent());
    }
}
