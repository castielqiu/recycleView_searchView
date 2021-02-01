package com.example.recycleview_searchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),itemsAdapter.ClickListner {
    val imageName= arrayOf(itemsModal("After","image description",R.drawable.after),
        itemsModal("Cold pursuit","image description",R.drawable.cold_pursuit),
        itemsModal("Joker","image description",R.drawable.joker),
        itemsModal("Mulan","image description",R.drawable.mulan),
        itemsModal("Project Power","image description",R.drawable.project_power),
        itemsModal("Antman","image description",R.drawable.ant_man),
        itemsModal("Moonlight","image description",R.drawable.moonlight),
        itemsModal("Jurassic park","image description",R.drawable.jurassic_park),
        itemsModal("Abc","image description",R.drawable.abc),
        itemsModal("John Wick","image description",R.drawable.john_wick)
        )
    val itemModalList=ArrayList<itemsModal>()

    var itemsAdapter: itemsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for(items in imageName)
        {
            itemModalList.add(items)
        }

        itemsAdapter=itemsAdapter(this);
        itemsAdapter!!.setData(itemModalList);

        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=itemsAdapter
    }

    override fun ClickedItem(itemsModal: itemsModal) {
        Toast.makeText(this,itemsModal.name,Toast.LENGTH_LONG).show()

    }


}