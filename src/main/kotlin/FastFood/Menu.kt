package FastFood

import AutoAtendimento

fun main() {

    val menu = Menu()
    menu.menuInicial()
}

class Menu {
    val executar = AutoAtendimento()

    fun menuInicial() {

        do {
            println("Bem-vindo ao FastFood!")
            println("Escolha uma opção:")
            println("1 -> Lanches")
            println("2 -> Bebidas")
            val input = readln() ?: ""
            val opcao = input.toIntOrNull()
            val sair = false

            when (opcao) {
                1 -> executar.lanche()
                2 -> executar.bebidas()
                null -> println("Formato inválido, para escolher o item, voce deve informar o numero dele")
                else -> println("Opção invalida, tente novamente")
            }
            menuInicial()
        } while (sair)
    }
}
