package ufes

import utils.Entrada
import utils.Saida
import java.util.ArrayList



class Universidade() {
    private val cursos = HashMap<Int, Curso>()
    private val departamentos = HashMap<String, Departamento>()

    fun preencheDadosUniversidade(input: Entrada) {
        criaDepartamentos(input.lePlanilha(input.caminhoDocente, 3));
		adicionaCursos(input.lePlanilha(input.caminhoCursos, 4));
		adicionaProdCientificaAosDocentes(input.lePlanilha(input.caminhoProdcientifica, 3));
        adicionaDisciplinasCursosECursosADocentes(input.lePlanilha(input.caminhoDisciplinas, 6));
		adicionaDiscentesAosCursos(input.lePlanilha(input.caminhoDiscente, 3));
		adicionaOrientacaoGradAosDocentes(input.lePlanilha(input.caminhoOrientacaoGrad, 4));
		adicionaOrientacaoPosAosDocentes(input.lePlanilha(input.caminhoOrientacaoPos, 5));
    }

    fun criaDepartamentos(planilha: Array<List<String>>) {
        planilha.forEach {
            val depa: Departamento? = getDepartamento(it[2])
            val docen = Docente(it)
            if(depa != null)
                depa.adicionaDocente(docen)
            else {
                val novoDepa = Departamento(it[2])
                novoDepa.adicionaDocente(docen)
                departamentos.put(novoDepa.nome, novoDepa)
            }
        }
    }

    fun adicionaCursos(planilha: Array<List<String>>) {
        planilha.forEach {
            val cur = Curso(it)
            cursos.put(cur.cod, cur)
        }
    }

    fun adicionaProdCientificaAosDocentes(planilha: Array<List<String>>) {
        planilha.forEach {
            val prod = ProducaoCientifica(it)
            departamentos.forEach {
                if(it.value.docentes[prod.codDocente] != null)
                    it.value.docentes[prod.codDocente]!!.adicionaProd(prod)
            }
        }
    }

    fun adicionaDisciplinasCursosECursosADocentes(planilha: Array<List<String>>) {
        planilha.forEach {
            val disci = Disciplina(it)
            val curso = adicionaDisciplinaNoCursoERetornaCurso(disci)
            val docen = getDocentePeloCodigo(disci.codDocente)
            docen!!.adicionaCurso(curso!!)
        }
    }

    fun adicionaDiscentesAosCursos(planilha: Array<List<String>>) {
        planilha.forEach {
            val discente = Discente(it)
            cursos[discente.codigoCurso]!!.adicionaDiscenteNoCurso(discente)
        }
    }

    fun adicionaOrientacaoGradAosDocentes(planilha: Array<List<String>>) {
        planilha.forEach {
            val matDiscente = Integer.parseInt(it[1].trim())
            val discen = getDiscente(matDiscente)
            val orientaGrad = OrientaGrad(it, discen!!)
            adicionaOrientacaoDocente(orientaGrad)
        }
    }

    fun adicionaOrientacaoPosAosDocentes(planilha: Array<List<String>>) {
        planilha.forEach {
            val matDiscente = Integer.parseInt(it[1].trim())
            val discen = getDiscente(matDiscente)
            val orientaPos = OrientaPos(it, discen!!)
            adicionaOrientacaoDocente(orientaPos)
        }
    }

    fun adicionaOrientacaoDocente(orientacao: Orientacao) {
        for(depa in departamentos) {
            if(depa.value.docentes[orientacao.codDocente] != null){
                depa.value.docentes[orientacao.codDocente]!!.adicionaOrientacao(orientacao)
                break
            }
        }
    }

    fun getDepartamento(nomeDepa: String): Departamento? = departamentos[nomeDepa]

    fun adicionaDisciplinaNoCursoERetornaCurso(disci: Disciplina): Curso? {
        if(cursos[disci.codCurso] != null){
            cursos[disci.codCurso]!!.adicionaDisciplinaNoCurso(disci)
            return cursos[disci.codCurso]
        }
        return null
    }

    fun getDocentePeloCodigo(codDocen: Int): Docente? {
        for( depa in departamentos) {
            if(depa.value.docentes[codDocen] != null)
                return depa.value.docentes[codDocen]
        }
        return null
    }

    fun getDiscente(matDiscente: Int): Discente? {
        for(curso in cursos){
            if(curso.value.discente[matDiscente] != null)
                return curso.value.discente[matDiscente]
        }
        return null
    }

    fun geraSaidas(output: Saida) {
        //gerarPad(output)
        //gerarRha(output)
        gerarAlocacao(output)
        gerarPpg(output)
    }

    fun gerarAlocacao(output: Saida) {
        output.abrirArquivoParaEscrita("3-alocacao.csv")
        try {
            output.escreveString(output.HEAD_ALOCACAO)
            val docentes = ArrayList<Docente>()
            for(depa in departamentos)
                docentes.addAll(depa.value.docentes.values)
            docentes.sortedWith(compareBy { it.nome }).forEach { docen ->
                docen.getDisciplinasDadas().sortedWith(compareBy { it.cod }).forEach {
                    val saida = docen.nome + ";" + it.cod + ";" + it.nome + ";" +
                                    it.cHSemestral.toString()
                    output.escreveString(saida)
                }
            }
        } finally {
            output.fecharFileWriter()
        }
    }

    fun gerarPpg(output: Saida) {
        output.abrirArquivoParaEscrita("4-ppg.csv")
        try {
            output.escreveString(output.HEAD_PPG)
            val ori = ArrayList<OrientaPos>()
            for (depa in departamentos) {
                for (docen in depa.value.docentes)
                    ori.addAll(docen.value.getOrientaPos())
            }
            ori.sortedWith(compareBy( { it.programa }, { it.dataIngresso })).forEach {
                val saida = it.programa + ";" + it.dataFormata() + ";"+
                        it.discente.matricula.toString() + ";" + it.discente.nome
                output.escreveString(saida)
            }
        } finally {
            output.fecharFileWriter()
        }
    }
}