package com.alejandrokantun.uservip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.alejandrokantun.uservip.UserVipApplication.Companion.prefs
import com.alejandrokantun.uservip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        checkUserValues()
    }

    private fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            goDetail()
        }
    }
    private fun initUI(){
        binding.btnContinue.setOnClickListener {
            accessToDetail()
        }
    }
    private fun accessToDetail(){
        if(binding.etName.text.isNotEmpty()){
            prefs.saveName(binding.etName.text.toString())
            prefs.saveVip(binding.cbVip.isChecked)
            goDetail()
        }
        else{
            Toast.makeText(this, "Se debe agregar un nombre de usuario", Toast.LENGTH_SHORT).show()
        }
    }

    fun goDetail(){
        startActivity(Intent(this,ResultActivity::class.java))
    }
}