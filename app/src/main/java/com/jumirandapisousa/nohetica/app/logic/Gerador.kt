package com.jumirandapisousa.nohetica.app.logic

import kotlin.random.Random

fun gerarExpressaoNumerica(): String{

    val modelo = gerarNumeroOpcao()

    val A = gerarNumero()
    val B = gerarNumero()
    val C = gerarNumero()
    val D = gerarNumero()
    val E = gerarNumero()
    val F = gerarNumero()
    val G = gerarNumero()

    val expressao = when(modelo){
        1 -> "$A + $B - $C + $D - $E + $F - $G"
        2 -> "$A + ($B - $C) + $D - $E + $F - $G"
        3 -> "($A + $B) - $C + ($D - $E) + $F - $G"
        4 -> "$A + [$B - ($C + $D)] - $E + $F - $G"
        5 -> "[$A + $B - $C] + ($D - $E) + $F - $G"
        6 -> "{$A + [$B - $C]} + $D - ($E + $F) + $G"
        7 -> "$A - {$B + [$C - ($D + $E)]} + $F - $G"
        8 -> "{$A + ($B - $C)} - [$D + ($E - $F)] + $G"
        9 -> "[$A - {$B + ($C - $D)}] + ($E - $F) + $G"
        10 -> "{$A - [$B + ($C - $D)]} + {($E + $F) - $G}"
        else -> "Erro do Sistema"
    }

    return expressao
}

fun gerarNumeroOpcao() = Random.nextInt(1, 11)

fun gerarNumero()= Random.nextInt(1,200 )
