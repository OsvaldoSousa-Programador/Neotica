
data class Agrupador(
    val abertura: Char,
    val fechamento : Char,
    val inicio : Int,
    val fim: Int
)

data class CalculoResolucao(
    val expressaoAntes: String,
    val operacao: String,
    val resultado: Int,
    val expressaoDepois: String
)

data class ResolucaoCompleta(
    val passos: List<CalculoResolucao>,
    val resultadoFinal: Int
)

fun encontrarAgrupadorMaisInterno(expressao: String): Agrupador? {

    val pilha = mutableListOf<Pair<Char, Int>>()

    for (indice in expressao.indices) {

        when (expressao[indice]) {

            '(', '[', '{' -> {
                pilha.add(expressao[indice] to indice)
            }

            ')', ']', '}' -> {

                val (abertura, inicio) = pilha.removeAt(pilha.size - 1)

                return Agrupador(
                    abertura,
                    expressao[indice],
                    inicio,
                    indice
                )
            }
        }
    }

    return null
}

fun extrairExpressao(
    expressao: String,
    agrupador: Agrupador
): String {
    return expressao.substring(agrupador.inicio + 1, agrupador.fim)
}

fun resolverExpressao(expressao: String): Int {

    val partes = expressao.split(" ")

    var resultado = limparNumeroNegativo(partes[0])

    var indice = 1

    while (indice < partes.size) {

        val operador = partes[indice]

        val numero = limparNumeroNegativo(partes[indice + 1])

        when (operador) {

            "+" -> resultado += numero

            "-" -> resultado -= numero
        }

        indice += 2
    }

    return resultado
}

fun substituirAgrupador(
    expressao: String,
    agrupador: Agrupador,
    resultado: Int
): String {
    val antes = expressao.substring(0, agrupador.inicio)
    val depois = expressao.substring(agrupador.fim + 1)

    return antes + resultado + depois
}

fun resolverExpressaoCompleta(expressaoInicial: String): ResolucaoCompleta {

    var expressao = expressaoInicial

    val passos = mutableListOf<CalculoResolucao>()

    var resultadoFinal = 0

    while (true) {

        val agrupador = encontrarAgrupadorMaisInterno(expressao)
            ?: break

        val trecho = extrairExpressao(expressao, agrupador)

        val resultado = resolverExpressao(trecho)

        val novaExpressao = substituirAgrupador(
            expressao,
            agrupador,
            resultado
        )

        passos.add(
            CalculoResolucao(
                expressao,
                trecho,
                resultado,
                novaExpressao
            )
        )

        expressao = novaExpressao

    }

    // Resolve a expressão restante, caso ainda exista uma operação
    val partes = expressao.split(" ")

    if (partes.size > 1) {

        resultadoFinal = resolverExpressao(expressao)

        passos.add(
            CalculoResolucao(
                formatarExpressaoParaMostrar(expressao),
                formatarExpressaoParaMostrar(expressao),
                resultadoFinal,
                resultadoFinal.toString()
            )
        )
    }

    return ResolucaoCompleta(
        passos,
        resultadoFinal
    )
}

fun mostrarCalculo(passos: List<CalculoResolucao>) {

    //println("A expressão é $expressao")

    passos.forEachIndexed { indice, linha ->

        println("\nLinha ${indice + 1}")
        println("----------------")

        println("Expressão:")
        println(formatarExpressaoParaMostrar(linha.expressaoAntes))

        println("Operação:")
        println(formatarExpressaoParaMostrar(linha.operacao))

        println("Resultado:")
        println(linha.resultado)

        println("Nova expressão:")
        println(formatarExpressaoParaMostrar(linha.expressaoDepois))
    }

}

fun formatarExpressaoParaMostrar(expressao: String): String {

    // Se a expressão inteira for apenas um número negativo,
    // não coloca parênteses
    if (expressao.trim().matches(Regex("-\\d+"))) {
        return expressao
    }

    val regex = Regex("(?<=\\s)(-\\d+)")

    return regex.replace(expressao) { resultado ->
        "(${resultado.value})"
    }
}

fun limparNumeroNegativo(numero: String): Int {

    return numero
        .replace("(", "")
        .replace(")", "")
        .toInt()
}