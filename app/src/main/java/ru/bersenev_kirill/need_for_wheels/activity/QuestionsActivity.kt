package ru.bersenev_kirill.need_for_wheels.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.adapter.ManufacturerAdapter
import ru.bersenev_kirill.need_for_wheels.adapter.QuestionAdapter
import ru.bersenev_kirill.need_for_wheels.data.DataSource

class QuestionsActivity : Activity() {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DATE = "date"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_questions)
        val rvQuestions = findViewById<RecyclerView>(R.id.rvQuestions)
        rvQuestions.layoutManager = LinearLayoutManager(this)
        rvQuestions.adapter = QuestionAdapter(DataSource.questions) {
                (name,date,description, iconResId) -> val intent = Intent(this, QuestionsActivity::class.java)
            intent.putExtra(QuestionsActivity.KEY_NAME,name.toString())
            intent.putExtra(QuestionsActivity.KEY_DATE,date)
            intent.putExtra(QuestionsActivity.KEY_DESCRIPTION,description)
            intent.putExtra(QuestionsActivity.KEY_ICON_RES_ID,iconResId)
            startActivity(intent)
        }
    }
}