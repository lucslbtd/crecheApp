package com.example.crecheapp.loginFlow.model

data class SignUpRequest(
    val user: User = User(),
    val child: Child = Child(),
    val address: Address = Address()
)

data class User(
    var email: String = "",
    var password: String = "",
    var account_type: String = "",
    var name: String = "",
    var gender: String = "",
    var birthday_date: String = "",
    var phone_number: String = "",
    var document: String = ""
)

data class Child(
    var name: String = "",
    var gender: String = "",
    var birthday_date: String = ""
)

data class Address(
    var street: String = "",
    var number: Int = 0,
    var postal_code: String = "",
    var city: String = "",
    var complement: String = ""
)
