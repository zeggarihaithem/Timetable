package com.example.td04exo03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.timeTable.R
import com.example.timeTable.entite.Module
import kotlinx.android.synthetic.main.module.view.*

class ModuleAdapter(context: Context, var listModuleAdapter: ArrayList<Module>) :
    BaseAdapter() {

    var context: Context?= context

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view=inflater.inflate(R.layout.module,null)
        val module = listModuleAdapter[position]
        view.name_module.text = module.nom
        view.interval_module.text = module.interval
        return view
    }

    override fun getItem(position: Int): Any {
        return listModuleAdapter[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listModuleAdapter.size
    }
}