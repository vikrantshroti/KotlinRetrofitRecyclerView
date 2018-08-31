package bms.kotlinretrofitrecyclerview

import retrofit2.Call
import retrofit2.http.POST

interface ApiInterface {

    //get hospital list
    @POST("E1Pn7khWG")
    fun getHospitalsList(): Call<ArrayList<Hospitals>>
}