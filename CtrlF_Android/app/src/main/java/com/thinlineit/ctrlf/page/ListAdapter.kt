package com.thinlineit.ctrlf.page

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.thinlineit.ctrlf.R
import com.thinlineit.ctrlf.databinding.MainLvItemBinding
import com.thinlineit.ctrlf.notes.NoteDao
import com.thinlineit.ctrlf.notes.TopicDao
import com.thinlineit.ctrlf.util.BindingRecyclerViewAdapter
import kotlinx.android.synthetic.main.main_lv_item.view.*

class ListAdapter() :
    RecyclerView.Adapter<ListAdapter.ViewHolder>(),BindingRecyclerViewAdapter<List<TopicDao>>{

    //var mList: ArrayList<ContentList> = list
    //val mList : ArrayList<PageDao>
    var mList = listOf<TopicDao>()

    interface OnItemClickListener{
        fun onItemClick(v:View, data: TopicDao, pos : Int)
    }
    private var listener : OnItemClickListener? = null

    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)
    /*
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_lv_item,parent,false)
        //val dataBinding = DataBindingUtil.inflate<FragmentNotesBinding>(view,R.layout.main_lv_item,parent,false)
        return ViewHolder(view)

        val view = LayoutInflater.from(parent.context)
        val dataBinding = DataBindingUtil.inflate<FragmentNotesBinding>(view,R.layout.main_lv_item,parent,false)
        return ViewHolder(dataBinding)
    }*/

    override fun getItemCount(): Int = mList.size
    /*
    {
        return mList.size
    }*/

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = mList.get(position)
        holder.bind(p)
    }

    class ViewHolder(private val dataBinding: MainLvItemBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(topicDao: TopicDao) {
            dataBinding.page = topicDao

            val pos = adapterPosition
            val tag = "ActivityLife"
            if(pos!= RecyclerView.NO_POSITION)
            {
                itemView.setOnClickListener {
                    Log.d(tag,"checklist()")

                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ListAdapter.ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val dataBinding = DataBindingUtil.inflate<MainLvItemBinding>(
                    layoutInflater,
                    R.layout.main_lv_item,
                    parent,
                    false
                )
                return ViewHolder(dataBinding)
            }
        }
    }

    override fun setData(data: List<TopicDao>) {
        //TODO("Not yet implemented")
        mList = data
        notifyDataSetChanged()
    }

}