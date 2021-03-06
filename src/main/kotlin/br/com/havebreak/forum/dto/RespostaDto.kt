package br.com.havebreak.forum.dto

import java.time.LocalDateTime

data class RespostaDto(
    val id: Long,
    val mensagem: String,
    val dataCriacao: LocalDateTime,
    val nomeAutor: String
)
