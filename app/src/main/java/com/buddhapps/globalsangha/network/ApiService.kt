package com.buddhapps.globalsangha.network

import com.buddhapps.globalsangha.model.LoginRequest
import com.buddhapps.globalsangha.model.RegisterRequest
import com.buddhapps.globalsangha.model.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("users/login")
    fun login(@Body request: LoginRequest): Call<AuthResponse>

    @POST("users/register")
    fun register(@Body request: RegisterRequest): Call<AuthResponse>
}
