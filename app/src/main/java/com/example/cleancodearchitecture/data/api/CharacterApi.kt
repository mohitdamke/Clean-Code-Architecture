package com.example.cleancodearchitecture.data.api

import com.example.cleancodearchitecture.data.dto.CharacterDto
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getAllCharacters(): List<CharacterDto>
}