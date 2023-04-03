package com.example.td04exo02.data

import com.example.timeTable.R
import com.example.timeTable.entite.Enseignant


class ListEns {
    companion object {
        fun getEns(): List<Enseignant> {
            //  getApplicationContext().getPackageName();
            val listEns = ArrayList<Enseignant>()
            listEns.add(
                Enseignant(
                    "Ourdjini",
                    "Aymen",
                    R.mipmap.ic_ens
                )
            )
            listEns.add(
                Enseignant(
                    "Zeggari",
                    "Haithem",
                    R.mipmap.ic_user2
                )
            )
            return listEns
        }

    }
}