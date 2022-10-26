package com.alejandrokantun.uservip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.alejandrokantun.uservip.UserVipApplication.Companion.prefs
import com.alejandrokantun.uservip.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }
    private fun goBack()
    {
        binding.btnCloseSession.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }
    }
    private fun initUI(){
        goBack()
        val userName = prefs.getName()
        binding.tvName.text = "Bienvenido $userName"
        if(prefs.getVip()){
            binding.container.setBackgroundColor(ContextCompat.getColor(this,R.color.vip_yellow))
        }
    }
}