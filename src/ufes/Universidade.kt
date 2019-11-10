package ufes

import utils.Entrada
import utils.Saida

class Universidade() {
    private var cursos = HashMap<Int, Curso>()
    private var departamentos = HashMap<String, Departamento>()

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

    }

    fun adicionaCursos(planilha: Array<List<String>>) {

    }

    fun adicionaProdCientificaAosDocentes(planilha: Array<List<String>>) {

    }

    fun adicionaDisciplinasCursosECursosADocentes(planilha: Array<List<String>>) {

    }

    fun adicionaDiscentesAosCursos(planilha: Array<List<String>>) {

    }

    fun adicionaOrientacaoGradAosDocentes(planilha: Array<List<String>>) {

    }

    fun adicionaOrientacaoPosAosDocentes(planilha: Array<List<String>>) {

    }

    fun geraSaidas(output: Saida) {

    }
}