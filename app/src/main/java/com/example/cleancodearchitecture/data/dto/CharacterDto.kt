package com.example.cleancodearchitecture.data.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    val actor: String,
    val alive: Boolean,
    @SerializedName("alternate_actors")
    val alternateactors: List<String>,
    @SerializedName("alternate_names")
    val alternatenames: List<String>,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val id: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wand: WandDto,
    val wizard: Boolean,
    val yearOfBirth: Int
)