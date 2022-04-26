package com.azhar.exoplayerwithrecyclerviewapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azhar.exoplayerwithrecyclerviewapplication.R
import com.azhar.exoplayerwithrecyclerviewapplication.model.data.MediaObject
import com.bumptech.glide.RequestManager
import java.util.ArrayList

class MediaRecyclerAdapter (var  mediaObjects: ArrayList<MediaObject>, var requestManager:RequestManager ) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  PlayerViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_media_list_item, parent, false));
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlayerViewHolder).onBind(mediaObjects.get(position),requestManager)
    }

    override fun getItemCount(): Int {
        return mediaObjects.size
    }
}