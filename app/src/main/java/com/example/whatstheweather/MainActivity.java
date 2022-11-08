package com.example.whatstheweather;

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
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String city = "";
    String result = "";
    TextView weatherTextView;

    public void getWeather(View view){
        // Accessing the city name from user input to find the weather
        city = editText.getText().toString();

        if(city.length() == 0)
            Toast.makeText(getApplicationContext(), "Please enter a city name!", Toast.LENGTH_LONG).show();

        else {
            DownloadTask task = new DownloadTask();
            // prev api: http://api.openweathermap.org/data/2.5/weather?q= <city> &units=metric&APPID=a1b6d892785676f2bca5be6519e55fc6
            task.execute("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "/?key=XD6PWJKNFBL42D6L7VWYGEXQ8");

            // execute() method is to start the background thread

            // To hide the keypad from user's screen on click of button
            InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            Toast.makeText(getApplicationContext(), "Keypad removed!", Toast.LENGTH_SHORT).show();
        }
    }

    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            StringBuilder result = new StringBuilder();
            URL url;
            HttpURLConnection urlConnection;

            try{
                url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                int data = reader.read();
                while(data != -1){
                    char current = (char) data;
                    result.append(current);
                    data = reader.read();
                }
                return result.toString();

            } catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                JSONObject jsonObject = new JSONObject(s);
                String weatherInfo = jsonObject.getString("weather");
                String tempInfo = jsonObject.getString("main");
                String windInfo = jsonObject.getString("wind");

                Log.i("Weather content: ", weatherInfo);
                Log.i("Temperature content: ", tempInfo);
                Log.i("Wind content: ", windInfo);
                //Log.i("JSON: ", String.valueOf(jsonObject) );

                // For setting the weatherContent
                JSONArray jsonArray = new JSONArray(weatherInfo);

                StringBuilder message = new StringBuilder();

                for(int i=0 ; i<jsonArray.length() ; i++){
                    JSONObject jsonPart = jsonArray.getJSONObject(i);

                    String main = jsonPart.getString("main");

                    String description = jsonPart.getString("description");

                    if( !main.equals("") && !description.equals("") )
                        message.append(main).append(": ").append(description).append("\n");

                    result = message.toString();

                    if(!result.equals("")) {
                        weatherTextView.setText(result);
                    }
                }

                // For setting the temperature and humidity
                JSONObject tempJsonPart = new JSONObject(tempInfo);

                // For setting the wind speed
                JSONObject windJsonPart = new JSONObject(windInfo);

                // Setting the temperature
                String temp = tempJsonPart.getString("temp");
                result += "Temp: " + temp + "°C";

                // Setting the humidity
                String humid = tempJsonPart.getString("humidity");
                result += "\nHumidity: " + humid + "%";

                // Setting the wind speed
                String wind = windJsonPart.getString("speed");
                result += "\nWind speed: " + wind + " km/h";

                // Filling the weatherTextView with weather details
                weatherTextView.setText(result);

            } catch(NullPointerException e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Could not find weather!" + (" \ud83d\ude16"), Toast.LENGTH_LONG).show();
            } catch(Exception e){
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Something went wrong!" + (" \ud83d\ude16"), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Make sure that the Internet is on!", Toast.LENGTH_LONG).show();

        editText = findViewById(R.id.editText);
        weatherTextView = findViewById(R.id.weatherTextView);
    }
}