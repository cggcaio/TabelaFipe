package br.com.gerencianet.tabelafipe.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ManufacturerResponse(
    @Json(name = "nome")
    val name: String,
    @Json(name = "codigo")
    val code: String
)
