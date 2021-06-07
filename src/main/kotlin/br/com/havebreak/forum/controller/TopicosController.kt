package br.com.havebreak.forum.controller

import br.com.havebreak.forum.controller.form.TopicoForm
import br.com.havebreak.forum.dto.TopicoDto
import br.com.havebreak.forum.model.Curso
import br.com.havebreak.forum.model.Topico
import br.com.havebreak.forum.repository.CursoRepository
import br.com.havebreak.forum.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.time.LocalDateTime
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicosController {

    @Autowired
    lateinit var topicoRepository: TopicoRepository

    @Autowired
    lateinit var cursoRepository: CursoRepository

    @GetMapping
    fun lista(nomeCurso: String?, uriBuilder: UriComponentsBuilder): List<TopicoDto> {
        print(uriBuilder.toUriString())
        return if(nomeCurso == null) {
            val topicos = topicoRepository.findAll()
            TopicoDto.converter(topicos)
        } else {
            val topicos = topicoRepository.findByCursoNome(nomeCurso)
            TopicoDto.converter(topicos)
        }
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid form: TopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoDto> {
        val topico = form.converter(cursoRepository = cursoRepository);
        topicoRepository.save(topico);
        val id = topico.id ?: 0

        val uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.id).toUri()
        return ResponseEntity
                .created(uri)
                .body(TopicoDto(id_ = id, titulo_ = topico.titulo, mensagem_ = topico.mensagem, dataCriacao_ = topico.dataCriacao))
        // Cabeçalho http chamado location contendo a url do recurso criado
    }
}