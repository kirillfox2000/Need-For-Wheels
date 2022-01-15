package ru.bersenev_kirill.need_for_wheels.data.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import ru.bersenev_kirill.need_for_wheels.domain.model.Specification

@ProvidedTypeConverter
class SpecificationConverter {

    @TypeConverter
    fun specificationToString(value: Specification): String {
        return value.seasonality+","+value.size+","+value.height+","+value.width+","+value.speed_index
    }

    @TypeConverter
    fun StringToSpecification(value: String): Specification {
        val array = value.split(",")
        return Specification(seasonality = array[0],size = array[1], height = array[2],width = array[3],speed_index = array[4])
    }
}