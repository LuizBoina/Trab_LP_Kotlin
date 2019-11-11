package ufes

import java.util.ArrayList



class Docente(campos: List<String>) {
    val cod = Integer.parseInt(campos[0].trim())
    val nome = campos[1].trim()
    val departamento = campos[2].trim()
    val producaoCientifica = HashMap<String, ProducaoCientifica>()
    val orientacoes = ArrayList<Orientacao>()
    val cursos = HashMap<Int, Curso>()

    fun adicionaCurso(cur: Curso) = cursos.put(cur.cod, cur)
    fun adicionaOrientacao(ori: Orientacao) = orientacoes.add(ori)
    fun adicionaProd(prod: ProducaoCientifica) = producaoCientifica.put(prod.titulo, prod)

    fun getDisciplinasDadas(): ArrayList<Disciplina> {
        val disciplinas = ArrayList<Disciplina>()
        cursos.forEach {
            disciplinas.addAll(it.value.disciplina.filter { it.value.codDocente == cod }.values)
        }
        return disciplinas
    }

    fun getTHSemanaisOrientacao(): Int {
        var qtdHr = 0
        orientacoes.forEach { qtdHr += it.CHsemanal }
        return qtdHr
    }

    fun getQtdProdCientificasQualificadas(): Int = producaoCientifica.filter { it.value.qualificada }.size
    fun getQtdProdCientificasNQualificadas(): Int = producaoCientifica.size - getQtdProdCientificasQualificadas()
    //    fun getOrientaPos(): List<OrientaPos> = orientacoes.filterIsInstance<OrientaPos>()
    fun getOrientaPos(): List<OrientaPos> {
        val oriPos = ArrayList<OrientaPos>()
        for (ori in orientacoes) {
            if (ori is OrientaPos)
                oriPos.add(ori)
        }
        return oriPos
    }
}
