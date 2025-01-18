package com.amb.randomusersapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amb.card.RandomCreditCardInitializer
import com.amb.random.users.RandomUsersInitializer

class MainActivity : AppCompatActivity() {

    private val randomUserButton: Button by lazy { findViewById(R.id.bt_start) }
    private val randomCreditCardButton: Button by lazy { findViewById(R.id.bt_creditcard) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        randomUserButton.setOnClickListener {
            RandomUsersInitializer.openRandomUserScreen(this)
        }
        randomCreditCardButton.setOnClickListener {
            RandomCreditCardInitializer.openRandomCreditCardScreen(this)
        }
    }
}