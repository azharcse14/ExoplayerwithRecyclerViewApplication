package com.azhar.exoplayerwithrecyclerviewapplication.view.adapter

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azhar.exoplayerwithrecyclerviewapplication.R
import com.azhar.exoplayerwithrecyclerviewapplication.model.data.MediaObject
import com.bumptech.glide.RequestManager

class PlayerViewHolder(private val parent: View) : RecyclerView.ViewHolder(
    parent
) {
    lateinit var mediaContainer: FrameLayout
    lateinit var requestManager: RequestManager
    lateinit var volumeControl: ImageView
    lateinit var progressBar: ProgressBar
    lateinit var mediaCoverImage: ImageView
    private val title: TextView
    private val userHandle: TextView

    init {
        mediaContainer = itemView.findViewById(R.id.mediaContainer)
        mediaCoverImage = itemView.findViewById(R.id.ivMediaCoverImage)
        title = itemView.findViewById(R.id.tvTitle)
        userHandle = itemView.findViewById(R.id.tvUserHandle)
        progressBar = itemView.findViewById(R.id.progressBar)
        volumeControl = itemView.findViewById(R.id.ivVolumeControl)
    }


    fun onBind(mediaObject: MediaObject, requestManager: RequestManager?) {
        this.requestManager = requestManager!!
        parent.tag = this
        title.text = mediaObject.title
        userHandle.text = mediaObject.userHandle
        this.requestManager
            .load(mediaObject.coverUrl)
            .into(mediaCoverImage)
    }


}



