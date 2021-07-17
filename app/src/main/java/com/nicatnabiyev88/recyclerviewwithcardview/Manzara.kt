package com.nicatnabiyev88.recyclerviewwithcardview

// model for recyclerview item
class Manzara(val imageID:Int,val baslik:String,val tanim:String){
    companion object{
        //recyclerview gets data from this function
        fun getData():List<Manzara>{
            val dataList = mutableListOf<Manzara>()
            val resimler= intArrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3)

            for (i in resimler.indices){
                val manzara = Manzara(resimler[i], "Manzara $i", "Tanim bilgisi $i")
                dataList.add(manzara)
            }

            return dataList
        }
    }
}