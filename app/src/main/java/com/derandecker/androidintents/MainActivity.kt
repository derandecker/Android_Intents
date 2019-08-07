package com.derandecker.androidintents

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val imageList: ArrayList<ImageData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val deran: Uri = Uri.parse("Deran://ddd")
        imageList.add(ImageData(deran))
        imageList.add(ImageData(deran))
        Log.d("ImageData Test", imageList[0].imageUriString)
        populateData()
    }


    fun createTextView(image: ImageData): TextView {
        val view = TextView(this)

        view.text = "${image.name}"

        return view
    }


    fun populateData() {
        imageList.forEach {
            val view = createTextView(it)
            list_view.addView(view)
        }
    }

}
