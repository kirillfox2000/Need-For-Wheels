package ru.bersenev_kirill.need_for_wheels.fragments


import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.activity.MainActivity
import ru.bersenev_kirill.need_for_wheels.adapter.QuestionAdapter
import ru.bersenev_kirill.need_for_wheels.data.DataSource
import ru.bersenev_kirill.need_for_wheels.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment(R.layout.fragment_questions) {
    companion object {
        const val KEY_NAME = "name"
        const val KEY_DATE = "date"
        const val KEY_DESCRIPTION = "description"
        const val KEY_ICON_RES_ID = "iconResId"

        fun newInstance (argName : String?, argDate : String?, argDescr : String?, argIcon : Int?) : QuestionsFragment {
            val args = bundleOf(
                KEY_NAME to argName,
                KEY_DATE to argDate,
                KEY_DESCRIPTION to argDescr,
                KEY_ICON_RES_ID to argIcon
            )
            val fragment = QuestionsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentQuestionsBinding.bind(view)
        val name = arguments?.getString(QuestionsFragment.KEY_NAME)
        val date = arguments?.getString(QuestionsFragment.KEY_DATE)
        val description = arguments?.getString(QuestionsFragment.KEY_DESCRIPTION)
        val iconResId = arguments?.getInt(QuestionsFragment.KEY_ICON_RES_ID)

        binding.rvQuestions.layoutManager = LinearLayoutManager(requireContext())
        binding.rvQuestions.adapter = QuestionAdapter(DataSource.questions) {
            (activity as MainActivity).navigateToFragment(
                QuestionsFragment.newInstance(name, date, description, iconResId)
            )
        }
    }
}