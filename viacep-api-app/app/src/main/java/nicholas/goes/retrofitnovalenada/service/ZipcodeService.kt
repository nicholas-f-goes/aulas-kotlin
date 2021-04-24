package nicholas.goes.retrofitnovalenada.service

import nicholas.goes.retrofitnovalenada.model.Zipcode
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ZipcodeService {

    @GET("{zipcode}/json/")

    fun findAddressByZipcode(@Path("zipcode")zipcode:String) : Call<Zipcode>

    @GET("{state}/{city}/{address}/json/")

    fun findZipcodeByStateDistrictAndCity(
            @Path("address")address:String,
            @Path("state")state:String,
            @Path("city")city:String) : Call<List<Zipcode>>

}