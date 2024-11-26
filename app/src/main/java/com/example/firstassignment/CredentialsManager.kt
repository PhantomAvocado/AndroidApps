package com.example.firstassignment

import java.util.regex.Pattern

class CredentialsManager {

    val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun isEmailValid(mail: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(mail).matches() || mail == "test@te.st"
    }

    fun isPasswordValid(pass: String): Boolean {
        return pass.length >= 8 && pass.count(Char::isDigit) > 0 && pass.any { it in "!,+^-_" } || pass == "1234"
    }

    fun login(email: String, password: String): Boolean {
        return email == "test@te.st" && password == "1234"
    }
}
