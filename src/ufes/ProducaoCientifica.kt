package ufes

class ProducaoCientifica(campos: List<String>) {
    val codDocente: Int = Integer.parseInt(campos[0].trim())
    val titulo: String = campos[1].trim()
    var qualificada: Boolean = false
        private set

    init {
        try {
            if (campos[2].trim() == "X")
                qualificada = true;
        } catch (e: ArrayIndexOutOfBoundsException) {
            qualificada = false;
        }
    }

}