package com.example.odev5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.odev5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var tempString: String = ""

    private lateinit var tasarim: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        listeners()
    }

    private fun listeners() {
        tasarim.buttonBir.setOnClickListener {
            onButtonClick("1")
        }

        tasarim.buttonIki.setOnClickListener {
            onButtonClick("2")
        }

        tasarim.buttonUc.setOnClickListener {
            onButtonClick("3")
        }

        tasarim.buttonDort.setOnClickListener {
            onButtonClick("4")
        }

        tasarim.buttonBes.setOnClickListener {
            onButtonClick("5")
        }

        tasarim.buttonAlti.setOnClickListener {
            onButtonClick("6")
        }

        tasarim.buttonYedi.setOnClickListener {
            onButtonClick("7")
        }

        tasarim.buttonSekiz.setOnClickListener {
            onButtonClick("8")
        }

        tasarim.buttonDokuz.setOnClickListener {
            onButtonClick("9")
        }

        tasarim.buttonSifir.setOnClickListener {
            onButtonClick("0")
        }

        tasarim.buttonTopla.setOnClickListener {
            onButtonClick("+")
        }

        tasarim.buttonEsittir.setOnClickListener {
            onButtonClickEquals()
        }

        tasarim.buttonTemizle.setOnClickListener {
            onButtonClickClear()
        }

        tasarim.buttonSil.setOnClickListener {
            onButtonClickRemove()
        }
    }

    private fun onButtonClick(basilanButton: String) {
        if (tempString.isNotBlank() && tempString.last() == '+' && basilanButton == "+") {
            return
        }

        tempString += basilanButton
        tasarim.textView.text = tempString
    }

    private fun onButtonClickEquals() {
        if (tempString.isNotBlank() && tempString.last() == '+') {
            return
        }

        var toplam = 0
        var toplamString = tempString
        while (toplamString.contains('+')) {
            toplam += toplamString.substringBefore("+").toInt()
            toplamString =
                toplamString.substring(toplamString.indexOf("+") + 1, toplamString.length)
        }

        toplam += tempString.substringAfterLast("+").toInt()
        tempString = toplam.toString()
        tasarim.textView.text = toplam.toString()
    }

    private fun onButtonClickRemove() {
        if (tasarim.textView.text.isNotEmpty()) {
            tempString = tempString.substring(0, tempString.length - 1)
            tasarim.textView.text = tempString
        }else{
            return
        }
    }

    private fun onButtonClickClear() {
            tempString = ""
            tasarim.textView.text = tempString
    }
}