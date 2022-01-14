package ru.bersenev_kirill.need_for_wheels.presentation.viewmodel

import android.content.Context


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import ru.bersenev_kirill.need_for_wheels.data.network.NetworkService
import ru.bersenev_kirill.need_for_wheels.presentation.ScreenStateQuestions


class QuestionsViewModel (
   // private val context: Context,
    //private val coroutineScope: CoroutineScope
) //{
   // private val _screenState = MutableStateFlow<ScreenStateQuestions> (ScreenStateQuestions.Loading)
    //val screenState : StateFlow<ScreenStateQuestions> = _screenState
   // private var job: Job? = null

    //@ExperimentalSerializationApi
    //fun loadData() {
      //  job?.cancel()
       // job = coroutineScope.launch {
           // try {
              //  _screenState.emit(ScreenStateQuestions.Loading)
               // val questions = NetworkService.loadQuestions()
               // _screenState.emit(ScreenStateQuestions.DataLoaded(questions))
           // } catch ( ex: Throwable) {
              //  _screenState.emit(ScreenStateQuestions.Error("Ошибка"))
           // }
       // }
    //}
//}
