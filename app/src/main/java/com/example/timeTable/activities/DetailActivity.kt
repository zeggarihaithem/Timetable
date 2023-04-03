package com.example.timeTable.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.td04exo02.data.ListEns
import com.example.timeTable.R
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        if (!resources.getBoolean(R.bool.isTablet)) {
            val extras = intent.extras
            nom_module.text = extras?.getString("nomModule")
            duree_module.text = extras?.getString("dureeModule")
            Ens_module.text = extras?.getString("nomEns")
            Ens_module.setOnClickListener {
                val i = Intent(this,
                    EnsActivity::class.java)
                i.putExtra("nomEns",extras?.getString("nomEns"))
                i.putExtra("photoEns", extras?.getString("nomEns")?.let { it1 -> getPhotoEns(it1) })
                i.putExtra("prenomEns", extras?.getString("nomEns")?.let { it1 -> getPrenomEns(it1) })
                startActivity(i)
            }
        }
    }
    private fun getPhotoEns(nom:String):Int{
        for (i in ListEns.getEns()){
            if(nom.equals(i.nom)) return i.photo
        }
        return 0
    }
    private fun getPrenomEns(nom:String):String{
        for (i in ListEns.getEns()){
            if(nom.equals(i.nom)) return i.prenom
        }
        return ""
    }
}