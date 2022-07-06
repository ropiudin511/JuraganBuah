package com.ropiudin.juraganbuah.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ropiudin.juraganbuah.databinding.ActivityMainBinding
import com.ropiudin.juraganbuah.databinding.ListItemBuahBinding
import com.ropiudin.juraganbuah.model.Buah

open class AdapterMacamBuah (private val context : Context,
                             private val data : List<Buah>?,
                             private val itemclick : onClickListener) :
    RecyclerView.Adapter<AdapterMacamBuah.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBuahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            if (item != null) {
                itemclick.detailData(item)
            }
        }
    }

    override fun getItemCount(): Int = data?.size ?:0
    inner class ViewHolder (val binding : ListItemBuahBinding): RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var nama = binding.txtnama

    }

    interface onClickListener {
        fun detailData (item : Buah)
    }
}

