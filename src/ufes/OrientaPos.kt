package ufes

import java.text.SimpleDateFormat

class OrientaPos(campos: Array<String>, dis: Discente) : Orientacao(campos[0], campos[4], dis) {
    val dataIngresso = SimpleDateFormat("dd/MM/yyyy").parse(campos[2].trim())
    val programa = campos[3].trim()
}