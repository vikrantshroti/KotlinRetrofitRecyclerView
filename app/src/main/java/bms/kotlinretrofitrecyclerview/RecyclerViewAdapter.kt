package bms.kotlinretrofitrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class RecyclerViewAdapter(var hospitalsList: ArrayList<Hospitals>?, var
itemClick: hospitalClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {

    //overridden method to return size of list
    override fun getItemCount(): Int {
        return hospitalsList!!.size
    }

    //interface for item click
    interface hospitalClickListener{
        fun getItem(position:Int)
    }

    //overridden method to bind holder
    override fun onBindViewHolder(holder:RecyclerViewHolder, position: Int) {
        holder.bindData(hospitalsList,position)
    }

    //overridden method to inflate view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        var view: View = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list,parent,
                false)
        return RecyclerViewHolder(view,itemClick)
    }

    //view holder to cast widgets and bind same
    class RecyclerViewHolder(itemView:View,var itemClick:hospitalClickListener):RecyclerView
    .ViewHolder(itemView){
        var textName : TextView = itemView.findViewById(R.id.text_name)
        var textAddress : TextView = itemView.findViewById(R.id.text_address)
        fun bindData(hospitalsList: ArrayList<Hospitals>?, position: Int){
            textName.text = hospitalsList!!.get(position).hospitalName
            textAddress.text = hospitalsList!!.get(position).address
            itemView.setOnClickListener{
                itemClick.getItem(adapterPosition)
            }
        }
    }

}