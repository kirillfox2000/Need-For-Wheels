package ru.bersenev_kirill.need_for_wheels.presentation

import ru.bersenev_kirill.need_for_wheels.domain.model.Question

sealed class ScreenStateQuestions{
    data class DataLoaded(val tires: List<Question>) : ScreenStateQuestions()
    object Loading : ScreenStateQuestions()
    data class Error(val error: String) : ScreenStateQuestions()
}