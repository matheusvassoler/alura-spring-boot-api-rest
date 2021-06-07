package br.com.havebreak.forum.controller.form

import br.com.havebreak.forum.model.Topico
import br.com.havebreak.forum.repository.TopicoRepository
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty

class AtualizacaoTopicoForm (
    @field:[javax.validation.constraints.NotNull NotEmpty Length(min = 5)]
    val titulo: String = "",

    @field:[javax.validation.constraints.NotNull NotEmpty Length(min = 10)]
    val mensagem: String = "",
) {
    fun atualizar(id: Long, topicoRepository: TopicoRepository): Topico {
        val topico = topicoRepository.getOne(id)
        return Topico(titulo, mensagem, topico.curso, topico.id, topico.dataCriacao, topico.status, topico.autor, topico.respostas)
    }
}

