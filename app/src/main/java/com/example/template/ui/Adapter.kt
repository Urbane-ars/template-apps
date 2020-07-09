package com.example.template.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.datasource.db.SomeData
import javax.inject.Inject

class Adapter @Inject constructor(): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_HEADER : Int = 0
    private val TYPE_ITEM : Int = 1
    private val TYPE_FOOTER : Int = 2
    private val list: MutableList<SomeData> = ArrayList()

    fun setData(newList: List<SomeData>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }


     class ViewHolderItem (val view : View) : RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.text)
    }


    inner class ViewHolderHeader(val viewHeader: View) : RecyclerView.ViewHolder(viewHeader)

    inner class ViewHolderFooter(val viewFooter: View) : RecyclerView.ViewHolder(viewFooter)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // if use footer or header need return ViewHolder"TYPE" via different viewType
        val viewItem : View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        val vh = ViewHolderItem(viewItem)
        viewItem.setOnLongClickListener {
            val position = vh.adapterPosition
            if (parent.context is FirstActivity){
                (parent.context as FirstActivity).presenter.deleteData(list[position])
            }
            true
        }
        return vh
    }

    override fun getItemCount(): Int {
        //change count if used footer or header
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderItem){
         holder.textView.text = list[position].toString()
        }

    }

    // need use method if used footer or header
// override fun getItemViewType(position: Int): Int {
//        if (position == list.size){
//            return TYPE_FOOTER
//        }
//        return super.getItemViewType(position)
//  }

}



