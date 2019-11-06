package mx.com.iavazquezs.instagramclone;

import android.app.Application;
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
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("23c513333c95b130d8d6f547e05be35b4d74bad6")
                .clientKey("0ae8d989064200d39c190ce09847f0f3822c2cac")
                .server("http://3.133.90.70:80/parse/")
                .build()
        );
    }
}
