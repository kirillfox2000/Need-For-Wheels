package ru.bersenev_kirill.need_for_wheels.data


import ru.bersenev_kirill.need_for_wheels.model.*

object DataSource {
    val manufacturers = listOf(
        Manufacturer("Kama", "Kama", "Russia",1),
        Manufacturer("Bridgestone", "Bridgestone", "Japan",2),
        Manufacturer("Sailun", "Sailun", "China",3),
        Manufacturer("Amtel", "Amtel", "Russia",4),
        Manufacturer("Continental", "Continental", "Germany",5)
    )

    val specification1 = Specification("summer", "15", "185", "60", "88H")
    val specification2 = Specification("winter", "14", "175", "65", "88H")

    val user1 = User("Petr", "Petrov", "89277777777", "cscsdc@mail.ru", "Russia",1)

    val reviews = listOf(
        Review(4.9, "01.09.2021", user1, "+", "-"),
        Review(4.2, "01.10.2021", user1, "+", "-")
    )

    val questions = listOf(
        Question(user1, "01.19.2021", "cxvxcvxc", user1.coverResId),
        Question(user1, "01.10.2021", " cxvvcxbxcv",user1.coverResId)
    )

    val tires = listOf(
        Tire(manufacturers[1],"euro",1750.0, specification1, reviews, questions,1),
        Tire(manufacturers[2],"potenza",2000.0, specification1, reviews, questions,2),
        Tire(manufacturers[3],"atrezzo",2200.0, specification1, reviews, questions,3),
        Tire(manufacturers[4],"planet",2350.0, specification1, reviews, questions,4),
        Tire(manufacturers[5],"contact",3200.0, specification1, reviews, questions,5),
        Tire(manufacturers[1],"euro",1900.0, specification2, reviews, questions,6),
        Tire(manufacturers[2],"potenza",2270.0, specification2, reviews, questions,7),
        Tire(manufacturers[3],"atrezzo",2475.0, specification2, reviews, questions,8),

    )

}