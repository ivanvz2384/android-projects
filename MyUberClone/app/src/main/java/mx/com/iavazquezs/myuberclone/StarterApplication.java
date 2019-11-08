package mx.com.iavazquezs.myuberclone;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class StarterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("bc9facfc41e1a3b668c3928e11d1d3d7a7294c84")
                .clientKey("6a6781157f73474726f95b2dbce9fbe5f4bf5427")
                .server("http://18.217.84.200:80/parse/")
                .build()
        );

        /*
        ParseObject object = new ParseObject("ExampleObject");
        object.put("myNumber", "123");
        object.put("myString", "iavazquezs");

        object.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException ex) {
                if (ex == null) {
                    Log.i("Parse Result", "Successful!");
                } else {
                    Log.i("Parse Result", "Failed" + ex.toString());
                }
            }
        });
         */

        //ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
