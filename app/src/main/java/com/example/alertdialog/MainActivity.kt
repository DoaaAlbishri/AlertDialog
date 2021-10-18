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
    lateinit var button: Button
    lateinit var textview: TextView
    var str = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        textview = findViewById(R.id.textView)

        button.setOnClickListener {
            //customAlert()
            showdialog()
        }
    }

    private fun showdialog(){
        val dialogBuilder = AlertDialog.Builder(this)
        val dialogView = layoutInflater.inflate(R.layout.dialog, null)
        dialogBuilder.setTitle("Alert Dialog")
        dialogBuilder.setMessage("Enter your message:")
        dialogBuilder.setView(dialogView)
        val editText = dialogView.findViewById<EditText>(R.id.editText)
        val textView2 = dialogView.findViewById<TextView>(R.id.textView2)
        val tvBtn = dialogView.findViewById<Button>(R.id.tv)
        val goBtn = dialogView.findViewById<Button>(R.id.go)

            tvBtn.setOnClickListener {
                str = editText.text.toString()
                textView2.text = str
            }

            goBtn.setOnClickListener {
                str = editText.text.toString()
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("message", str)
                startActivity(intent)
            }
            dialogBuilder.show()
    }


    private fun customAlert() {
        // first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        // then we set up the input
        val input = EditText(this)
        // here we set the message of our alert dialog
        dialogBuilder.setMessage("Enter your message:")
                // positive button text and action
                .setPositiveButton("TV", DialogInterface.OnClickListener { dialog, id ->
                    str = input.text.toString()
                    textview.text = str
                })
                // negative button text and action
                .setNegativeButton("Go", DialogInterface.OnClickListener { dialog, id ->
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

}