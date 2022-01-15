package ru.bersenev_kirill.need_for_wheels.presentation.viewmodel

import android.content.Context

import ru.bersenev_kirill.need_for_wheels.presentation.ScreenState

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import ru.bersenev_kirill.need_for_wheels.data.database.DatabaseProvider
import ru.bersenev_kirill.need_for_wheels.data.network.NetworkService
import java.io.IOException

class TiresViewModel
    (
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val tiresDao = DatabaseProvider.provideDatabase(context).tireDao()
    private val _screenState = MutableStateFlow<ScreenState> (ScreenState.Loading)
    val screenState : StateFlow<ScreenState> = _screenState
    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job = coroutineScope.launch {
            try{
                _screenState.value = ScreenState.Loading
                val tires = try{
                    NetworkService.loadTires().also{
                        tiresDao.insertAll(it)
                    }
                } catch (ex: IOException){
                   tiresDao.getAll()
                }
                _screenState.value = ScreenState.DataLoaded(tires)
            } catch (ex: Throwable){
                _screenState.value = ScreenState.Error("Ошибка!")
            }
        }
    }
    }