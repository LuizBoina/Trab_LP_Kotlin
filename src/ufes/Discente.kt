package ufes

class Discente(campos: Array<String>) {
    val matricula = Integer.parseInt(campos[0].trim());
    val nome = campos[1].trim();
    val codigoCurso = Integer.parseInt(campos[2].trim());
}