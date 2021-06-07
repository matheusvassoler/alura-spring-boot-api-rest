package br.com.havebreak.forum.dto

import br.com.havebreak.forum.model.Topico
import java.time.LocalDateTime
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors
import kotlin.collections.ArrayList


data class TopicoDto(
    private val id_: Long,
    private val titulo_: String,
    private val mensagem_: String,
    private val dataCriacao_: LocalDateTime
) {
    val id: Long get() = id_
    val titulo: String get() = titulo_
    val mensagem: String get() = mensagem_
    val dataCriacao: LocalDateTime get() = dataCriacao_

    companion object {
        fun converter(topicos: List<Topico>): List<TopicoDto> {
            val list = ArrayList<TopicoDto>()
            topicos.forEach {
                val id = it.id ?: 0
                list.add(TopicoDto(id_ = id, titulo_ = it.titulo, mensagem_ = it.mensagem, dataCriacao_ = it.dataCriacao))
            }
            return list
        }
    }
}
