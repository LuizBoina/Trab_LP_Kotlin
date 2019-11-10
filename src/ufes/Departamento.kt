package ufes

class Departamento(nome: String) {
    val nome = nome.trim()
    val docentes = HashMap<Int, Docente>()

    fun adicionaDocente(doc: Docente) = docentes.put(doc.cod, doc)
    fun getQuantidadeDocentes() = docentes.size
}