package com.example.clickme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private val TAG = "MainActivity"
private val TEXT = "TEXT_CONTENT"


class MainActivity : AppCompatActivity() {

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userInput: EditText = findViewById<EditText>(R.id.TextName)
        val BotonGuardar: Button = findViewById<Button>(R.id.savebutton)
        val BotonLimpiar: Button = findViewById<Button>(R.id.clearbutton)
        textView = findViewById<TextView>(R.id.textView)

        textView?.text = ""

        textView?.movementMethod = ScrollingMovementMethod()

        BotonGuardar?.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick")
                textView?.append(userInput.text)
                textView?.append("\n")
                userInput.setText("")
                userInput.text.clear()
            }
        })

        BotonLimpiar?.setOnClickListener(object :View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d(TAG, "onClick Clean")
                textView?.setText("")
            }
        })
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        Log.d(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(TEXT)
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
        outState.putString(TEXT, textView?.text.toString())
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.d(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }
}