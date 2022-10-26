package com.alejandrokantun.uservip

import android.content.Context

class Prefs(val context: Context) {
    val SHARED_NAME = "Mydtb" //se suele poner en mayúsculas las constantes
    val SHARED_USER = "username"
    val SHARE_VIP = "vip"
    val storage = context.getSharedPreferences(SHARED_NAME,0)
    fun saveName(name:String){
        storage.edit().putString(SHARED_USER,name).apply()
    }
    fun saveVip(vip:Boolean){
        storage.edit().putBoolean(SHARE_VIP,vip).apply()
    }

    fun getName():String{
         return  storage.getString(SHARED_USER,"")!!
    }
    fun getVip():Boolean{
        return  storage.getBoolean(SHARE_VIP,false)
    }
    fun wipe(){
        storage.edit().clear().apply()
    }
}