package ufes

class Disciplina(campos: Array<String>) {
    val cod: String = campos[0].trim()
    val nome: String = campos[1].trim()
    val codDocente: Int = Integer.parseInt(campos[2].trim())
    val codCurso: Int = Integer.parseInt(campos[3].trim())
    val cHSemanal: Int = Integer.parseInt(campos[4].trim())
    val cHSemestral: Int = Integer.parseInt(campos[5].trim())
}