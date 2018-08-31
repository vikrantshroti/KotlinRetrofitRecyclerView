package bms.kotlinretrofitrecyclerview

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.hospitalClickListener {

    //array list hospitals
    var hospitalsData: ArrayList<Hospitals> = ArrayList()

    //overridden interface from adapter for item click
    override fun getItem(position: Int) {
        val alertDialog = AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle(hospitalsData.get(position).hospitalName)
        alertDialog.setMessage(hospitalsData.get(position).address)
        alertDialog.setPositiveButton("Okay") { dialog, which ->
            Toast.makeText(this@MainActivity, "Okay", Toast.LENGTH_LONG).show()
        }
        alertDialog.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recycler view initialisation
        var recyclerView: RecyclerView = findViewById(R.id.recyclerview_demo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        //getting retrofit instance in this class
        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class
                .java)

        //calling web service
        apiInterface.getHospitalsList().enqueue(object : Callback<ArrayList<Hospitals>> {
            override fun onResponse(call: Call<ArrayList<Hospitals>>?, response:
            Response<ArrayList<Hospitals>>?) {
                hospitalsData = response?.body()!!
                recyclerView.adapter = RecyclerViewAdapter(response?.body()!!, this@MainActivity)
            }

            override fun onFailure(call: Call<ArrayList<Hospitals>>?, t: Throwable?) {
            }
        })
    }
}
