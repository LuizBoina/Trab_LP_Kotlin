package ufes

class OrientaGrad(campos: Array<String>, dis: Discente) : Orientacao(campos[0], campos[3], dis) {
    val codCurso: Int = Integer.parseInt(campos[2].trim())

}