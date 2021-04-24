package nicholas.goes.retrofitnovalenada.service

import com.google.gson.GsonBuilder
import nicholas.goes.retrofitnovalenada.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofitinitializer {

    var gson = GsonBuilder()
            .setDateFormat("yyy-MM-dd'T'HH:mm:ss")
            .create()

    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    fun zipcodeService() = retrofit.create(ZipcodeService::class.java)
}