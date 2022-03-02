package kg.tutorialapp.singletone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kg.tutorialapp.singletone.WeatherClient.weatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kg.tutorialapp.singletone.models.ForeCast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchWeatherUsingQuerry()

    }

    private fun fetchWeatherUsingQuerry() {
        val textView: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView1)
        val call = WeatherClient.fetWeatherUsingQuerry(lat = 40.5140, lon = 72.161, lang = "en")
        call.enqueue(object : Callback<ForeCast> {
            override fun onResponse(call: Call<ForeCast>, response: Response<ForeCast>) {
                if (response.isSuccessful) {
                    val foreCast = response.body()

                    foreCast?.let {
                        textView.text = it.curren?.weather!![0].description
                        textView2.text = it.timeZone

                    }
                }
            }

            override fun onFailure(call: Call<ForeCast>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG)
            }

        })
    }
}