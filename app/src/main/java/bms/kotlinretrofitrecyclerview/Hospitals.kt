package bms.kotlinretrofitrecyclerview

import com.google.gson.annotations.SerializedName

/*
    Getter Setter class for Hospitals
 */
class Hospitals {

    //id
    var id: String? = null

    //hospital name
    @SerializedName("hospital_name")
    var hospitalName: String? = null

    //hospital address
    var address: String? = null
}
