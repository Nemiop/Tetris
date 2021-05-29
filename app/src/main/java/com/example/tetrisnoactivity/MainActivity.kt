package com.example.tetrisnoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.widget.TextView
import com.example.tetrisnoactivity.storage.AppPreferences
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    var tvHighScore: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide Action Bar with name
        supportActionBar?.hide()
        /*
        val appBar: ActionBar? = supportActionBar
        if(appBar != null)
            appBar.hide()
        */
        tvHighScore = findViewById<TextView>(R.id.tv_high_score)

        val btnNewGame: Button = findViewById<Button>(R.id.btn_new_game)
        val btnResetScore: Button = findViewById<Button>(R.id.btn_reset_score)
        val btnExit: Button = findViewById<Button>(R.id.btn_exit)

        btnNewGame.setOnClickListener(this::onBtnNewGameClick)
        btnResetScore.setOnClickListener(this::onBtnResetScoreClick)
        btnExit.setOnClickListener(this::onBtnExitClick)
    }

    private fun onBtnNewGameClick(view: View){
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun onBtnResetScoreClick(view: View){
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        
        Snackbar.make(view, "Score successfully reset!", Snackbar.LENGTH_SHORT).show()
        tvHighScore?.text = "High score: ${preferences.getHighScore()}"
    }

    fun onBtnExitClick(view: View){
       System.exit(0)
    }
}