package com.colormediumearth

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var maskBitmap: Bitmap
    private lateinit var colorMapBitmap: Bitmap
    private lateinit var paintView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maskBitmap = BitmapFactory.decodeResource(resources, R.drawable.mask)
        colorMapBitmap = BitmapFactory.decodeResource(resources, R.drawable.colormap)
        paintView = findViewById(R.id.paintView)

        paintView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val x = event.x.toInt()
                val y = event.y.toInt()
                val pixelColor = colorMapBitmap.getPixel(x, y)
                // Aqui você pode pintar a área no maskBitmap e atualizar a tela
                true
            } else false
        }
    }
}
