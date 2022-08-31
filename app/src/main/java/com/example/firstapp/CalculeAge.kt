package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.firstapp.databinding.ActivityCalculeAgeBinding
import com.example.firstapp.databinding.ActivityMainBinding
import java.util.*

class CalculeAge : AppCompatActivity() {

    var binding: ActivityCalculeAgeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calcule_age)
        initialView()
    }

    private fun initialView() {
        // 2600 =>
        //   700 =>
        //   1300 => lwalid
        binding!!.button.setOnClickListener {
            this.finish()
        }

        binding!!.button.setOnClickListener{
            var yearsOld:Int = binding!!.editTextTextEmailAddress.text.toString().toInt()
            var year:Int = Calendar.getInstance().get(Calendar.YEAR)

            binding!!.textView.text = ((year - yearsOld ).toString())

        }


    }
}