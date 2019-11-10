package utils

import ufes.Universidade

fun main(args: Array<String>) {
    val input = Entrada(args)
    val output = Saida()
    val ufes = Universidade()
    ufes.preencheDadosUniversidade(input)
    ufes.geraSaidas(output)
}