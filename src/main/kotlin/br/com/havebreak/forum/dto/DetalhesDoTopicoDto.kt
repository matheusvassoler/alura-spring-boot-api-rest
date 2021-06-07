package br.com.havebreak.forum.dto

import br.com.havebreak.forum.model.StatusTopico
import java.time.LocalDateTime

data class DetalhesDoTopicoDto(
    val id: Long,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime,
    val nomeAutor: String,
    val status: StatusTopico,
    val respostas: List<RespostaDto>
)
