package com.elsyoufy.videostreaming

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mediaController: MediaController by lazy {
        MediaController(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_video_view.setMediaController(mediaController)
        main_video_view.start()

        main_btn_select_video.setOnClickListener {
            selectVideoFromDivec()
        }
    }

    private fun selectVideoFromDivec() {
        val intent = Intent()
        intent.type = "video/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startForResult.launch(intent)
    }

    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null)  {
            val videoUri  = result.data!!.data
            main_video_view.setVideoURI(videoUri)
        }
    }
}