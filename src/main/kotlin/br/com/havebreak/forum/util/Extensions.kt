package br.com.havebreak.forum.util

import br.com.havebreak.forum.dto.DetalhesDoTopicoDto
import br.com.havebreak.forum.dto.RespostaDto
import br.com.havebreak.forum.dto.TopicoDto
import br.com.havebreak.forum.model.Resposta
import br.com.havebreak.forum.model.Topico

fun Topico.toDetalheDoTopico(): DetalhesDoTopicoDto {
    val listaRespostas = ArrayList<RespostaDto>()
    respostas.forEach {
        listaRespostas.add(it.toRespostaDto())
    }
    return DetalhesDoTopicoDto(id ?: 0, titulo, mensagem, dataCriacao, autor.nome, status, listaRespostas)
}

fun Resposta.toRespostaDto(): RespostaDto =
        RespostaDto(id, mensagem, dataCriacao, autor.nome)

fun List<Topico>.toTopicoDtoList(): List<TopicoDto> {
    val list = ArrayList<TopicoDto>()
    this.forEach {
        list.add(it.toTopicoDto())
    }
    return list
}

fun Topico.toTopicoDto(): TopicoDto {
    return TopicoDto(id ?: 0, titulo, mensagem, dataCriacao)
}