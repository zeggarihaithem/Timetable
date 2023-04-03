package com.example.td04exo02.data

import com.example.timeTable.entite.Module


class ListModule {
    companion object {
        fun getModule(): List<Module> {
            //  getApplicationContext().getPackageName();
            val listModule = ArrayList<Module>()
            listModule.add(
                Module(
                    "TDM",
                    2,
                    ListEns.getEns()[0],
                    "8:30-10:30"
                )
            )
            listModule.add(
                Module(
                    "Projet",
                    2,
                    ListEns.getEns()[1],
                    "13:00-16:00"
                )
            )
            return listModule
        }

    }
}