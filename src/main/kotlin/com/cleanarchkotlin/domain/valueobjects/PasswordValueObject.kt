package com.cleanarchkotlin.domain.valueobjects

import com.cleanarchkotlin.domain.errors.InvalidParamError

class PasswordValueObject(val value: String) {
    init {
        println(value)
        if (value.isEmpty() || value.length < 8) {
            throw InvalidParamError("password. Must be not empty and must have more than 8 characters")
        }
    }

    override fun toString(): String {
        return this.value
    }
}