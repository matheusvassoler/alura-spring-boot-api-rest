package br.com.havebreak.forum.repository

import br.com.havebreak.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository : JpaRepository<Topico, Long> {
    //Encontra um topico com base no atributo nome da entidade curso
    // Caso topico tivesse um atributo chamado cursoNome iria dar conflito, pois agora 2 pontos possuem cursoNome
    // Para especificar que gostaria de buscar o atributo nome da entidade curso seria necessário o nome do método ser
    //findByCurso_Nome
    //Com isso o Spring sabe que é necessário utilizar a entidade curso e seu atributo Nome para filtrar os topicos
    // Agora, caso não queira seguir o padrão de nomenclatura que permite o Spring fazer a implementação de forma automática,
    // É necessário usar a anotação @Query para indicar a ele como será feita a busca
    // Exemplo: @Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
    //fun findByCursoNome(@Param("nomeCurso") nomeCurso: String): List<Topico>
    fun findByCursoNome(nomeCurso: String): List<Topico>
}