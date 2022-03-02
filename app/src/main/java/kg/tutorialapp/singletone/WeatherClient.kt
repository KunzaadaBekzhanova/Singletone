package kg.tutorialapp.singletone
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import kg.tutorialapp.singletone.models.ForeCast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


object WeatherClient {



    private val httpClient by lazy {
        val interceptor =
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            //.baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }
     val weatherApi by lazy {
        retrofit.create(WeatherClient::class.java)
    }
}