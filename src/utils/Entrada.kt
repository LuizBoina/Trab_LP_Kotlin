package utils

import java.io.BufferedReader
import java.io.FileReader


class Entrada(args: Array<String>) {
    val caminhoDocente: String
    val caminhoDiscente: String
    val caminhoProdcientifica: String
    val caminhoCursos: String
    val caminhoDisciplinas: String
    val caminhoOrientacaoGrad: String
    val caminhoOrientacaoPos: String

    init {
        val indexDocente = args.indexOf("-d")
        val indexDiscente = args.indexOf("-a")
        val indexPC = args.indexOf("-p")
        val indexCursos = args.indexOf("-c")
        val indexDisciplinas = args.indexOf("-r")
        val indexOG = args.indexOf("-og")
        val indexOP = args.indexOf("-op")
        caminhoDocente = args[indexDocente + 1]
        caminhoDiscente = args[indexDiscente + 1]
        caminhoProdcientifica = args[indexPC + 1]
        caminhoCursos = args[indexCursos + 1]
        caminhoDisciplinas = args[indexDisciplinas + 1]
        caminhoOrientacaoGrad = args[indexOG + 1]
        caminhoOrientacaoPos = args[indexOP + 1]
    }

    fun qtdLinhas(caminho: String): Int {
        var qtdLinhas = 0
        val leitor = BufferedReader(FileReader(caminho))
        while (leitor.readLine() != null)
            qtdLinhas++;
        leitor.close();
        return (qtdLinhas - 1);
    }

    fun lePlanilha(caminhoArq: String, qtdCelulas: Int): Array<List<String>> {
        val numLinhas = qtdLinhas(caminhoArq)
        val planilha = Array(numLinhas) { listOf<String>() }
        val leitor = BufferedReader(FileReader(caminhoArq))
        var linhaLida: String? = leitor.readLine() //remove a linha com cabecalho
        var i = 0
        while (linhaLida != null) {
            linhaLida = leitor.readLine()
            planilha[i++] = linhaLida.split(";")
        }
        leitor.close()
        return planilha
    }
}