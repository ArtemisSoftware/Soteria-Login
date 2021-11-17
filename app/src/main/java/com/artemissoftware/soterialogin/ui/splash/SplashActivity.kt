package com.artemissoftware.soterialogin.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artemissoftware.soterialogin.R
import com.artemissoftware.soterialogin.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //val navController = Navigation.findNavController(R.id.kennelNavHostFragment)

        button.setOnClickListener {
/*
            navController.navigateUp()
            navController.navigate(R.id.tutorialFragment)
*/

            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("keyIdentifier", true)
            startActivity(intent)

        }
    }
}