package ru.bersenev_kirill.need_for_wheels.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.adapter.TireAdapter
import ru.bersenev_kirill.need_for_wheels.data.DataSource

class TiresActivity : Activity() {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_tires)
        val rvTires = findViewById<RecyclerView>(R.id.rvTires)
        rvTires.layoutManager = LinearLayoutManager(this)
        rvTires.adapter = TireAdapter(DataSource.tires) { (name,description,iconResId) ->
            val intent = Intent(this, TiresActivity::class.java)
            intent.putExtra(KEY_NAME,name.toString())
            intent.putExtra(KEY_DESCRIPTION,description)
            intent.putExtra(KEY_ICON_RES_ID, iconResId)
            startActivity(intent)
        }
    }
}