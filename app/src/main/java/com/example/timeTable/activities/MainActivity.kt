package com.example.timeTable.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.td04exo02.data.ListEns
import com.example.td04exo02.data.ListModule
import com.example.td04exo03.adapter.ModuleAdapter
import com.example.timeTable.R
import com.example.timeTable.entite.Enseignant
import com.example.timeTable.entite.Module
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(resources.getBoolean(R.bool.isTablet)){
            val adapter= ModuleAdapter(this.applicationContext, ListModule.getModule() as ArrayList<Module>)
            tab_list_module.adapter=adapter
            tab_list_module.onItemClickListener =
                AdapterView.OnItemClickListener { arg0, arg1, position, arg3 ->
                    val module: Module = tab_list_module.adapter.getItem(position) as Module
                    val enseignant : Enseignant = getEns(module.ens.nom,module.ens.prenom)
                    tab_nom_module.text = module.nom
                    tab_duree_module.text = module.duree.toString()
                    tab_Ens_module.text = enseignant.nom
                    tab_nom_ens.text =  enseignant.nom
                    tab_prenom_ens.text = enseignant.prenom
                    tab_ens_image.setImageResource(enseignant.photo)
                    linear_details.visibility = View.VISIBLE

                }
        }else{
            val adapter= ModuleAdapter(this.applicationContext, ListModule.getModule() as ArrayList<Module>)
            list_module.adapter=adapter
            list_module.onItemClickListener =
                AdapterView.OnItemClickListener { arg0, arg1, position, arg3 ->
                    val module: Module = list_module.adapter.getItem(position) as Module
                    val i = Intent(this, DetailActivity::class.java)
                    i.putExtra("nomModule", module.nom)
                    i.putExtra("dureeModule", module.duree.toString())
                    i.putExtra("nomEns", module.ens.nom)
                    startActivity(i)
                }
        }
    }
    private fun getEns(nom:String,prenom:String): Enseignant {
        for(i in ListEns.getEns()){
            if(i.nom.equals(nom) && i.prenom.equals(prenom))return i
        }
        return Enseignant("", "", 0)
    }
}
