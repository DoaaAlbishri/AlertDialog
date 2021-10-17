package com.example.alertdialog

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var button : Button
    lateinit var textview : TextView
    var str = " "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        textview = findViewById(R.id.textView)
        button.setOnClickListener {
            customAlert()
        }

    }
    private fun customAlert(){
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        // then we set up the input
        val input = EditText(this)
        // here we set the message of our alert dialog
        dialogBuilder.setMessage("Enter your message:")
                // positive button text and action
                .setPositiveButton("TV", DialogInterface.OnClickListener {
                    dialog, id ->
                    str = input.text.toString()
                    textview.text= str
                })
                // negative button text and action
                .setNegativeButton("Go", DialogInterface.OnClickListener {
                    dialog, id ->
                    str = input.text.toString()
                    val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("message", str)
                    startActivity(intent)
                })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("New Message")
        // add the Edit Text
        alert.setView(input)
        // show alert dialog
        alert.show()
    }

/*
    private fun customAlert(){
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        // here we set the message of our alert dialog
        dialogBuilder.setMessage("Enter your message:")
        dialogBuilder.setView(R.layout.dialog)
        val tvbtn = findViewById<Button>(R.id.tv)
        tvbtn.setOnClickListener {
            val input = findViewById<EditText>(R.id.editText)
            val m = input.text.toString()
            val output = findViewById<TextView>(R.id.textView2)
            output.text= m
        }
        // negative button text and action
        val gobtn = findViewById<Button>(R.id.go)
        gobtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("message", "hello")
            startActivity(intent)
        }
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Alert")
        alert.show()
    }
*/
}