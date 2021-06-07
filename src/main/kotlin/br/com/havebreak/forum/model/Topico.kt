package br.com.havebreak.forum.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Topico(
    var titulo: String = "",
    var mensagem: String = "",
    @ManyToOne
    var curso: Curso = Curso(),
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
    @Enumerated(EnumType.STRING)
    var status: StatusTopico = StatusTopico.NAO_RESPONDIDO,
    @ManyToOne(cascade= [CascadeType.PERSIST])
    var autor: Usuario = Usuario(),
    @OneToMany(mappedBy = "topico")
    var respostas: List<Resposta> = ArrayList()
)