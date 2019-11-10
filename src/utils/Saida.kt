package utils

import java.io.FileWriter

class Saida(private var fileWriter: FileWriter? = null) {
    val NOVA_LINHA = '\n'
    val HEAD_PAD = """Docente;Departamento;Horas Semanais Aula;Horas Semestrais Aula;Horas Semanais
                      Orientação;Produções Qualificadas;Produções Não Qualificadas"""
    val HEAD_RHA = "Departamento;Docente;Cód. Curso;Curso;Horas Semestrais Aula"
    val HEAD_ALOCACAO = "Docente;Código;Nome;Carga Horária Semestral"
    val HEAD_PPG = "Nome do Programa;Data de Ingresso;Matrícula;Nome"
    fun escreveString(str: String) {
        fileWriter!!.append(str);
        fileWriter!!.append(NOVA_LINHA)
    }

    fun abrirArquivoParaEscrita(nomeArqSaida: String) {
        fileWriter = FileWriter(nomeArqSaida)
    }

    fun fecharFileWriter() {
        fileWriter!!.flush()
        fileWriter!!.close()
    }
}