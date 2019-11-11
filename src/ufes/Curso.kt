package ufes

class Curso(campos: List<String>) {
    val cod: Int = Integer.parseInt(campos[0].trim())
    val nome = campos[1].trim()
    val discente = HashMap<Int, Discente>()
    val disciplina = HashMap<String, Disciplina>()
    var ehGrad: Boolean = false
        private set

    init {
        try {
            if (campos[2].trim() == "X")
                ehGrad = true;
        } catch (e: ArrayIndexOutOfBoundsException) {
            ehGrad = false
        }
    }

    fun totalHorasDocente(codDocente: Int): Int {
        var qtdHr: Int = 0
        disciplina.forEach {
            if (it.value.codDocente == codDocente)
                qtdHr += it.value.cHSemestral
        }
        return qtdHr
    }

    fun adicionaDisciplinaNoCurso(disci: Disciplina) = disciplina.put(disci.cod, disci)

    fun adicionaDiscenteNoCurso(disce: Discente) = discente.put(disce.matricula, disce)
}