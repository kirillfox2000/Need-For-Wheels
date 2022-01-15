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
import ru.bersenev_kirill.need_for_wheels.presentation.ScreenStateManufacturers
import ru.bersenev_kirill.need_for_wheels.presentation.ScreenState
import java.io.IOException


class ManufacturersViewModel (
    private val context: Context,
    private val coroutineScope: CoroutineScope
) {
    private val manufacturersDao = DatabaseProvider.provideDatabase(context).manufacturerDao()
    private val _screenState = MutableStateFlow<ScreenStateManufacturers> (ScreenStateManufacturers.Loading)


    val screenState : StateFlow<ScreenStateManufacturers> = _screenState
    private var job: Job? = null

    @ExperimentalSerializationApi
    fun loadData() {
        job = coroutineScope.launch {
           try{
                _screenState.value = ScreenStateManufacturers.Loading
                val manufacturers = try{
                    NetworkService.loadManufacturers().also{
                        manufacturersDao.insertAll(it)
                    }
                } catch (ex: IOException){
                    manufacturersDao.getAll()
                }
                _screenState.value = ScreenStateManufacturers.DataLoaded(manufacturers)
            } catch (ex: Throwable){
                _screenState.value = ScreenStateManufacturers.Error("Ошибка!")
           }
       }
    }
}