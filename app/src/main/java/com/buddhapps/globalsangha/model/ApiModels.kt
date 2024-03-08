package com.buddhapps.globalsangha.model

data class LoginRequest(val email: String, val password: String)
data class RegisterRequest(val email: String, val password: String, val name: String)
data class AuthResponse(val token: String)