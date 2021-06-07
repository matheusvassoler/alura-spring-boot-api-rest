package br.com.havebreak.forum.controller.form

import br.com.havebreak.forum.model.Topico
import br.com.havebreak.forum.repository.CursoRepository
import org.hibernate.validator.constraints.Length
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class TopicoForm(
    @field:[NotNull NotEmpty Length(min = 5)]
    val titulo: String? = "",

    @field:[NotNull NotEmpty Length(min = 10)]
    val mensagem: String = "",

    @field:[NotNull NotEmpty]
    val nomeCurso: String = ""
) {
    fun converter(cursoRepository: CursoRepository): Topico {
        val curso = cursoRepository.findByNome(nomeCurso);
        return Topico(titulo = titulo!!, mensagem = mensagem, curso = curso);
    }
}
