package br.com.havebreak.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var mensagem: String = "",
    @ManyToOne
    var topico: Topico = Topico(),
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    var autor: Usuario = Usuario(),
    var solucao: Boolean = false
)