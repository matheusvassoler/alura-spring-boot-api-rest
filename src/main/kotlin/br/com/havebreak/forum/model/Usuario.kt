package br.com.havebreak.forum.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Usuario(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Permite tornar o id primary key (@id) e definir o mesmo com auto incremento (strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var nome: String = "",
    var email: String = "",
    var senha: String = "",
)