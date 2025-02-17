package com.example.firstassignment

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Assert
import org.junit.Test

class CredentialsTest {

    val credentialsManager = CredentialsManager.getInstance()

    // Email tests
    @Test
    fun checkEmptyEmail_ReturnFalse() {
        val email = ""

        val result = credentialsManager.isEmailValid(email)
        assertFalse(result)
    }

    @Test
    fun givenWellFormattedEmail_ReturnTrue() {
        val email = "roma.kot1000@gmail.com"

        val result = credentialsManager.isEmailValid(email)
        assertTrue(result)
    }

    @Test
    fun givenIncorrectlyFormattedEmail_ReturnTrue() {
        val email = "dsabc@das"

        val result = credentialsManager.isEmailValid(email)
        assertFalse(result)
    }

    // Password tests
    @Test
    fun givenEmptyPassword_ReturnFalse() {
        val password = ""
        val result = credentialsManager.isPasswordValid(password)

        assertFalse(result)
    }

    @Test
    fun givenWellFormattedPassword_ReturnTrue() {
        val password = "123Tr-_-xx123"
        val result = credentialsManager.isPasswordValid(password)

        assertTrue(result)
    }

    @Test
    fun givenIncorrectlyFormattedPassword_ReturnTrue() {
        val password = "Strongpassword"
        val result = credentialsManager.isPasswordValid(password)

        assertFalse(result)
    }

    // Register tests
    @Test
    fun givenNewEmailAndPassword_RegistrationSuccessful() {
        val email = "newuser@example.com"
        val password = "Password123!"

        val result = credentialsManager.register(email, password)

        Assert.assertEquals("Registration successful", result)
        assertTrue(credentialsManager.login(email, password))
    }

    @Test
    fun givenExistingEmail_RegistrationFails() {
        val email = "existinguser@example.com"
        val password = "Password123!"

        credentialsManager.register(email, password)
        val result = credentialsManager.register(email, password)

        Assert.assertEquals("Error: Email already taken", result)
    }

    @Test
    fun givenEmailWithDifferentCase_RegistrationFails() {
        val email = "CaseSensitive@example.com"
        val password = "Password123!"

        credentialsManager.register(email, password)
        val result = credentialsManager.register(email.uppercase(), password)

        Assert.assertEquals("Error: Email already taken", result)
    }
}
