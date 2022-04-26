package com.azhar.exoplayerwithrecyclerviewapplication.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.azhar.exoplayerwithrecyclerviewapplication.R
import com.azhar.exoplayerwithrecyclerviewapplication.model.data.MediaObject
import com.azhar.exoplayerwithrecyclerviewapplication.view.adapter.MediaRecyclerAdapter
import com.azhar.exoplayerwithrecyclerviewapplication.view.utils.ExoPlayerRecyclerView
import com.azhar.exoplayerwithrecyclerviewapplication.view.utils.ExoPlayerRecyclerViewK
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions

class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerViewK: ExoPlayerRecyclerViewK
    private val mediaObjectList: ArrayList<MediaObject> = ArrayList<MediaObject>()
    private var mAdapter: MediaRecyclerAdapter? = null
    private val firstTime = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        // Prepare demo content
        prepareVideoList()

        //set data object
        mRecyclerViewK.setMediaObjects(mediaObjectList)
        mAdapter = MediaRecyclerAdapter(mediaObjectList, initGlide())

        //Set Adapter
        mRecyclerViewK.adapter = mAdapter
        mRecyclerViewK.smoothScrollToPosition(1)


        //mRecyclerView.smoothScrollToPosition(1);
        /*   if (firstTime) {
      new Handler(Looper.getMainLooper()).post(new Runnable() {
        @Override
        public void run() {
          mRecyclerView.playVideo(false);
        }
      });
      firstTime = false;
    }*/
    }

    private fun initView() {
        mRecyclerViewK = findViewById(R.id.exoPlayerRecyclerView)
        mRecyclerViewK.layoutManager = LinearLayoutManager(this)
    }

    private fun initGlide(): RequestManager {
        val options = RequestOptions()
        return Glide.with(this)
            .setDefaultRequestOptions(options)
    }

    override fun onDestroy() {
        mRecyclerViewK.releasePlayer()
        super.onDestroy()
    }

    private fun prepareVideoList() {
        val mediaObject = MediaObject(1, "Naima", "First",
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4")

        val mediaObject2 = MediaObject(2,"user 2","Item 2",
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1"
        ,"https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4")

        val mediaObject3 = MediaObject(3,"User 3", "Item 3",
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1",
        "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4")
        val mediaObject4 = MediaObject(4,"User 4","Item 4",
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1","")
//            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4")
        val mediaObject5 = MediaObject(5,"User 5","Item 5",
            "https://www.muscleandfitness.com/wp-content/uploads/2019/04/7-Demonized-BodyBuilding-Food-Gallery.jpg?w=940&h=529&crop=1",
            "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4")
        mediaObjectList.add(mediaObject)
        mediaObjectList.add(mediaObject2)
        mediaObjectList.add(mediaObject3)
        mediaObjectList.add(mediaObject4)
        mediaObjectList.add(mediaObject5)
    }
}
