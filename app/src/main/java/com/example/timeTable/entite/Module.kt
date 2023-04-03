package com.example.timeTable.entite

class Module(cNom:String, cDuree:Int, cEns: Enseignant, cInterval:String) {
    val nom:String = cNom
    val duree : Int = cDuree
    val interval :String = cInterval
    val ens : Enseignant = cEns
}