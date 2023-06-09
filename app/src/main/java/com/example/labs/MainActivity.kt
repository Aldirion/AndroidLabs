package com.example.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.labs.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var bdCl : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bdCl = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bdCl.root)
        //bdCl.menuTitle.text = "Hello, Android!" - проверка работоспособности Binding Class
    }

    override fun onResume() {
        super.onResume()
        Log.i("MyLog", "Запущено MainActivity")
    }
    fun onClickL1 (view : View) {
        Log.i("MyLog", "Button 1 pressed")
        val intent = Intent(this, Lab1::class.java)
        startActivity(intent)
    }

    fun onClickL2(view: View) {
        Log.i("MyLog", "Button 2 pressed")
        val intent = Intent(this, Lab2::class.java)
        startActivity(intent)
    }
    fun onClickL3(view: View) {
        Log.i("MyLog", "Button 3 pressed")
        val intent = Intent (this, Lab3::class.java)
        startActivity(intent)
    }
    fun onClickL4(view: View) {
        Log.i("MyLog", "Button 4 pressed")
        val intent = Intent (this, Lab4::class.java)
        startActivity(intent)
    }
    fun onClickL5(view: View) {
        Log.i("MyLog", "Button 5 pressed")
    }
    fun onClickL6(view: View) {
        Log.i("MyLog", "Button 6 pressed")
    }
    fun onClickL7(view: View) {
        Log.i("MyLog", "Button 7 pressed")
    }
    fun onClickL8(view: View) {
        Log.i("MyLog", "Button 8 pressed")
    }
}


