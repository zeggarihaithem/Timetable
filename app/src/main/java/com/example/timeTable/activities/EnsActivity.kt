package com.example.timeTable.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.timeTable.R
import kotlinx.android.synthetic.main.activity_ens.*

class EnsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ens)
        if (!resources.getBoolean(R.bool.isTablet)) {
            val extras = intent.extras
            nom_ens.text = extras?.getString("nomEns")
            prenom_ens.text = extras?.getString("prenomEns")
            extras?.getString("photoEns")?.toInt()?.let { ens_image.setImageResource(it) }


        }
    }
}