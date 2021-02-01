package com.example.recycleview_searchview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview_searchview.itemsAdapter.itemsAdapterViewHold
import kotlinx.android.synthetic.main.row_items.view.*

class itemsAdapter(var clickListner: ClickListner): RecyclerView.Adapter<itemsAdapterViewHold>() {



    var itemsModalList= ArrayList<itemsModal>()

    fun setData(itemsModalList:ArrayList<itemsModal>){
        this.itemsModalList=itemsModalList;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemsAdapterViewHold {
        return itemsAdapterViewHold(LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent,false))
    }

    override fun onBindViewHolder(holder: itemsAdapterViewHold, position: Int) {
      val itemsModal=itemsModalList[position]
        holder.name.text=itemsModal.name;
        holder.desc.text=itemsModal.description;
        holder.image.setImageResource(itemsModal.image)
        holder.itemView.setOnClickListener {clickListner.ClickedItem(itemsModal)  }
    }

    override fun getItemCount(): Int {
       return itemsModalList.size
    }

    class itemsAdapterViewHold(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name=itemView.names;
        val desc=itemView.description;
        val image=itemView.imageView;
    }

    interface  ClickListner{
        fun ClickedItem(itemsModal: itemsModal)
    }
}