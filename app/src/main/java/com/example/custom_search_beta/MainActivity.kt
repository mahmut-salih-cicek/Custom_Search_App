package com.example.custom_search_beta

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var googleUrl = "https://www.google.com/search?as_q="


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerFileType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                AdapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {

                Toast.makeText(applicationContext,"Secilen öge ${AdapterView?.getItemAtPosition(position).toString()}",Toast.LENGTH_SHORT).show()
                var fileTypeItem = "${AdapterView?.getItemAtPosition(position).toString()}"
                textView99.text = fileTypeItem
            }

        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                AdapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext,"Secilen öge ${AdapterView?.getItemAtPosition(position).toString()}",Toast.LENGTH_SHORT).show()
                var lanquage = "${AdapterView?.getItemAtPosition(position).toString()}"
                textView100.text = lanquage
            }

        }

        spinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                goster : AdapterView<*>?, view: View?, position: Int, id: Long) {

                Toast.makeText(applicationContext,"Secilen öge ${goster?.getItemAtPosition(position).toString()}",Toast.LENGTH_SHORT).show()
                var region = "${goster?.getItemAtPosition(position).toString()}"
                textView200.text = region
            }

        }


        spinner4.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(applicationContext,"Secilen öge ${parent?.getItemAtPosition(position).toString()}",Toast.LENGTH_SHORT).show()
                var timeZone = "${parent?.getItemAtPosition(position).toString()}"
                textView300.text = timeZone

            }

        }




    }


    fun basmak(view:View){

        var kullanıcıDegeriİstenilen= editText1.text.toString() ///// kırmızı
        var istenilmeyenDeger = edittext2.text.toString()///// -kalem
        var fileTypeItem = textView99.text.toString() //// filetype:pdf
        var lanquageText = textView100.text.toString() ////&lr=lang_de
        var regionText = textView200.text.toString() /////&cr=countryDE
        var timeText = textView300.text.toString() ///// &as_qdr=y


        var time = "&as_qdr=$timeText"
        var region = "&cr=country$regionText"
        var lanquage = "&lr=lang_$lanquageText"
        var fileTypeText = "filetype:$fileTypeItem"
        var bırlestır = " $istenilmeyenDeger"
        var istenilmeyenDegerCıkar = bırlestır.replace(" ", " -")
        if (istenilmeyenDeger.equals("")){
            istenilmeyenDegerCıkar = ""
        }


        var mainData = "$googleUrl$kullanıcıDegeriİstenilen$istenilmeyenDegerCıkar $fileTypeText$lanquage$region$time"


        val intent =  Intent(Intent.ACTION_VIEW, Uri.parse("$mainData"));
        startActivity(intent);

    }

}