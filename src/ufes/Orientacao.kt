package ufes

open class Orientacao(codDocente: String, cHSemanal: String, val discente: Discente) {
    val codDocente: Int = Integer.parseInt(codDocente.trim())
    val CHsemanal: Int = Integer.parseInt(cHSemanal.trim())

}