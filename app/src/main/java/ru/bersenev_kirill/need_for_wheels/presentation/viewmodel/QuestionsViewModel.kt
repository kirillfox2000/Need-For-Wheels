package ru.bersenev_kirill.need_for_wheels.presentation.viewmodel

import android.content.Context


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import ru.bersenev_kirill.need_for_wheels.data.database.DatabaseProvider
import ru.bersenev_kirill.need_for_wheels.data.network.NetworkService
import ru.bersenev_kirill.need_for_wheels.presentation.ScreenStateQuestions
import java.io.IOException


class QuestionsViewModel (
   // private val context: Context,
   // private val coroutineScope: CoroutineScope
) {
   // private val questionsDao = DatabaseProvider.provideDatabase(context).questionDao()
   // private val _screenState = MutableStateFlow<ScreenStateQuestions> (ScreenStateQuestions.Loading)
   // val screenState : StateFlow<ScreenStateQuestions> = _screenState
  //  private var job: Job? = null

  //  @ExperimentalSerializationApi
   // fun loadData() {
      //  job = coroutineScope.launch {
          //  try{
              //  _screenState.value = ScreenStateQuestions.Loading
               // val questions = try{
                 //   NetworkService.loadQuestions().also{
                   //     questionsDao.insertAll(it)
                  //  }
               // } catch (ex: IOException){
                 //   questionsDao.getAll()
              //  }
              //  _screenState.value = ScreenStateQuestions.DataLoaded(questions)
           // } catch (ex: Throwable){
            //    _screenState.value = ScreenStateQuestions.Error("Ошибка!")
         //   }
      //  }
   // }
}
