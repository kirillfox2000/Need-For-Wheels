package ru.bersenev_kirill.need_for_wheels.presentation.viewmodel

import android.content.Context

import ru.bersenev_kirill.need_for_wheels.presentation.ScreenState

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import ru.bersenev_kirill.need_for_wheels.data.network.NetworkService

class TiresViewModel
    (
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val _screenState = MutableStateFlow<ScreenState> (ScreenState.Loading)
    val screenState : StateFlow<ScreenState> = _screenState
    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job?.cancel()
        job = coroutineScope.launch {
            try {
                _screenState.emit(ScreenState.Loading)
                val tires = NetworkService.loadTires()
                _screenState.emit(ScreenState.DataLoaded(tires))
            } catch ( ex: Throwable) {
                _screenState.emit(ScreenState.Error("Ошибка"))
            }
        }
    }
}