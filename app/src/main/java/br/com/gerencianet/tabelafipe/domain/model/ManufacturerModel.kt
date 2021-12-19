package br.com.gerencianet.tabelafipe.domain.model

data class ManufacturerModel(
    val id: Long,
    val name: String,
    val image: Int? = null
)
