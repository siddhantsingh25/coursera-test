package com.siddhantsingh25.block12

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // the 2 buttons:
    // define in the activity_main.xml
    private lateinit var buttonBlue: Button
    //defined in this file
    internal lateinit var buttonPink: Button // What doesn't Java need a late init thing??


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonBlue = findViewById(R.id.buttonBlue)
        buttonPink = Button(applicationContext)

        buttonPink.text = "Hi <3"
        buttonPink.setTextColor(Color.MAGENTA)
        buttonPink.setBackgroundColor(Color.BLACK)

        val layoutParams = RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

        layoutParams.addRule(RelativeLayout.BELOW,buttonBlue.id)

        // IMPORTANT ,<RelativeLayout> is important :p
        val relativeLayout_mainScreen = findViewById<RelativeLayout>(R.id.relativeLayout_mainScreen) as RelativeLayout
        relativeLayout_mainScreen.addView(buttonPink, layoutParams)

        buttonBlue.setOnClickListener(this)
        buttonPink.setOnClickListener(this)
    }
    fun toDo(v: View){
        if (v == buttonBlue)
            v.visibility = View.INVISIBLE
        if (v == buttonPink)
            Toast.makeText(applicationContext,
                    "hihihihihi",
                    Toast.LENGTH_LONG).show()
    }

    override fun onClick(v : View) {
        toDo(v)
    }
}
