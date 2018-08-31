package bms.kotlinretrofitrecyclerview

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient{

    //base url for retrofit builder
    var BASE_URL="https://next.json-generator.com/api/json/get/"

    //retrofit instance with check
    var retrofit: Retrofit?=null

    //fn to build retrofit instance
    fun getApiClient():Retrofit?{
        if (retrofit==null){
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit
    }
}