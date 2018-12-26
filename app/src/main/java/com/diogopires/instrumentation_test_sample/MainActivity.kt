package com.diogopires.instrumentation_test_sample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.diogopires.instrumentation_test_sample.R.id.hello_btn
import com.diogopires.instrumentation_test_sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.listener = this

    }

    override fun onclick() {
        Toast.makeText(applicationContext,resources.getString(R.string.toast_text),Toast.LENGTH_LONG).show()
    }

}

interface ClickListener{
    fun onclick()
}
