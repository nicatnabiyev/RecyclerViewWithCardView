package com.nicatnabiyev88.recyclerviewwithcardview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create adapter and set to recyclerview
        val adapter = ManzaraAdapter(this, Manzara.getData())
        recycleView.adapter = adapter

        //create layoutmanager to show recyclerview
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayout.VERTICAL
        recycleView.layoutManager = linearLayoutManager
    }

    //option menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    //item select
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.linearViewHorizontal -> setLinearHorizontal()
            R.id.linearViewVertical -> setLinearVertical()
            R.id.gridView -> setGridView()
            R.id.staggeredViewHorizontal -> setStaggeredHorizontal()
            R.id.staggeredViewVertical -> setStaggeredVertical()
        }
        return super.onOptionsItemSelected(item)
    }

    // <--- layout manager for recycler view start --->
    @SuppressLint("WrongConstant")
    fun setLinearHorizontal(){
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayout.HORIZONTAL
        recycleView.layoutManager = linearLayoutManager
    }

    @SuppressLint("WrongConstant")
    fun setLinearVertical(){
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayout.VERTICAL
        recycleView.layoutManager = linearLayoutManager
    }

    fun setGridView(){
        val gridLayoutManager = GridLayoutManager(this,3)
        recycleView.layoutManager = gridLayoutManager
    }

    fun setStaggeredHorizontal(){
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
        recycleView.layoutManager = staggeredGridLayoutManager
    }

    fun setStaggeredVertical(){
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recycleView.layoutManager = staggeredGridLayoutManager
    }
    // <--- layout manager for recycler view end --->

}