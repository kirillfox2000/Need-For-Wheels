package ru.bersenev_kirill.need_for_wheels.network

import retrofit2.http.GET
import ru.bersenev_kirill.need_for_wheels.model.*

abstract class RestApi {
    @GET("manufacturers")
    abstract suspend fun loadManufacturers(): List<Manufacturer>
    @GET("tires")
    abstract suspend fun loadTires():List<Tire>
    @GET("questions")
    abstract suspend fun loadQuestions():List<Question>
    @GET("reviews")
    abstract suspend fun loadReviews():List<Review>
    @GET("specifications")
    abstract suspend fun loadSpecifications():List<Specification>
    @GET("users")
    abstract suspend fun loadUsers():List<User>

}