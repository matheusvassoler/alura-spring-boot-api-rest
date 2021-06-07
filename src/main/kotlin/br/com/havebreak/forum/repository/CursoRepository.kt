package br.com.havebreak.forum.repository

import br.com.havebreak.forum.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository : JpaRepository<Curso, Long> {
    fun findByNome(nome: String): Curso
}
