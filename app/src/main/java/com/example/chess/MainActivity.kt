package com.example.chess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


private const val TAG="Main Activity"
class MainActivity : AppCompatActivity() {
    var chessModel=ChessModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

                Log.d(TAG, chessModel.toString())


    }
}