package com.derandecker.androidintents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    companion object {
        internal const val REQUEST_IMAGE_INT = 1
    }

    val imageList: ArrayList<ImageData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val deran: Uri = Uri.parse("Deran://ddd")
//        imageList.add(ImageData(deran))
//        imageList.add(ImageData(deran))
//        Log.d("ImageData Test", imageList[0].imageUriString)

        image_select_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_IMAGE_INT)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_INT && resultCode == RESULT_OK) {
            val imageUri = data!!.data
            if (imageUri != null) {
                imageList.add(ImageData(imageUri))
            }
        }

        populateData()
        super.onActivityResult(requestCode, resultCode, data)
    }


    fun createTextView(image: ImageData): TextView {
        val view = TextView(this)

        view.text = "${image.imageUriString}"

        return view
    }


    fun populateData() {
        imageList.forEach {
            val view = createTextView(it)
            list_view.addView(view)
        }
    }

}
