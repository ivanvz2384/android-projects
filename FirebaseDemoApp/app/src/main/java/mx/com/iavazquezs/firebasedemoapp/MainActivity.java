package mx.com.iavazquezs.firebasedemoapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference();
        Map<String, String> values = new HashMap<>();
        values.put("name", "Ivan");
        dbref.push().setValue(values, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Log.i("Info", "Successful");
                } else {
                    Log.i("Info", "Failed");
                }
            }
        });
         */
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        AdView adView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

    }
}
