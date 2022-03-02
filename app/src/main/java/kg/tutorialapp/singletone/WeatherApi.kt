package kg.tutorialapp.singletone


import kg.tutorialapp.singletone.models.ForeCast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("onecall?lat=42.882004&lon=74.582748&exclude=minutely&appid=2dc7a4a8bf32ea93b27312a966b83f18&lang=ru&units=metric")
    fun getWeather(): Call<ForeCast>

    @GET("onecall")
    fun fetWeatherUsingQuerry(
        @Query("lat") lat: Double = 42.0746,
        @Query("icon") lon: Double = 74.5698,
        @Query("exclude") exclude: String = "minutely",
        @Query("lang") lang: String = "ru",
        @Query("appid") appid: String = "2dc7a4a8bf32ea93b27312a966b83f18",
        @Query("units") units: String = "metric"

    )
}