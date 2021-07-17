package com.nicatnabiyev88.recyclerviewwithcardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class ManzaraAdapter(context: Context,list: List<Manzara>): RecyclerView.Adapter<ManzaraAdapter.MyViewHolder>() {
    // declare list (manzara) and infalter (layoutinfalter for itemlist)
    val mDataList = list.toMutableList() //inital list here
    val inflater: LayoutInflater = LayoutInflater.from(context)

    //initial inflater and return viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    //set holder data with function
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val manzara = mDataList[position]
        holder.setData(manzara,position)
    }

    //how much item in list
    override fun getItemCount(): Int {
        return mDataList.size
    }

    //delete item from list
    fun deleteItem(position: Int){
        mDataList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position,mDataList.size)
    }

    //copy item from list
    fun copyItem(position: Int,manzara: Manzara){
        mDataList.add(position,manzara)
        notifyItemInserted(position)
        notifyItemRangeChanged(position,mDataList.size)
    }

    //declare inner class
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var getPosition = 0 //clicked position
        lateinit var getManzara: Manzara // clicked manzara object

        //set data to itemlist
        fun setData(manzara: Manzara, position: Int){
            itemView.txt_title.text =  manzara.baslik
            itemView.txt_description.text =  manzara.tanim
            itemView.img_main.setImageResource(manzara.imageID)
            getPosition = position
            getManzara = manzara

        }

        init {
            //when delete image clicked
            itemView.img_delete.setOnClickListener {
                deleteItem(getPosition)
            }

            //when copy image clicked
            itemView.img_copy.setOnClickListener {
                copyItem(getPosition, getManzara)
            }
        }

    }
}