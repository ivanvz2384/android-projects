package mx.com.iavazquezs.whatstheweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private EditText cityEditText;
    private TextView weatherTextView;

    public class DownloadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            URL url;
            try {
                url = new URL(urls[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                int data = reader.read();

                String result = "";
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }
                Log.i("doInBackground", result);
                return result;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.i("INFO", result);
            try {
                String message = "";
                JSONObject jsonObject = new JSONObject(result);
                if (jsonObject.get("cod") != null && jsonObject.getString("cod").equals("404")) {
                    Toast.makeText(getApplicationContext(), "The city was not found", Toast.LENGTH_SHORT);
                    return;
                }
                String weatherInfo = jsonObject.getString("weather");
                Log.i("WeatherContent", weatherInfo);

                JSONArray jsonArray = (JSONArray)jsonObject.get("weather");

                for(int i= 0; i < jsonArray.length(); i++) {
                    JSONObject myJson = jsonArray.getJSONObject(i);
                    Log.i("Weather main", myJson.getString("main"));
                    Log.i("Weather description", myJson.getString("description"));

                    String main = myJson.getString("main");
                    String description = myJson.getString("description");

                    if (!main.isEmpty() && !description.isEmpty()) {
                        message += main + ": " + description + "\r\n";
                    }
                }

                if (!message.isEmpty()) {
                    weatherTextView.setText(message);
                } else {
                    Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_SHORT);
                }

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_SHORT);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityEditText = findViewById(R.id.cityEditText);
        weatherTextView = findViewById(R.id.weatherTextView);
    }

    public void findWeather(View view) {
        InputMethodManager mgr = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(weatherTextView.getWindowToken(), 0);
        String city = cityEditText.getText().toString();
        DownloadTask task = new DownloadTask();
        try {
            String url = "http://api.openweathermap.org/data/2.5/weather?APPID=a190e62ef334a424961a3cd0b8245047&q=" + URLEncoder.encode(city, "UTF-8");
            task.execute(url);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_SHORT);
        }
    }
}
