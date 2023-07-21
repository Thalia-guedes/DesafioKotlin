data class ItemLanche(var nome: String, var quantidade: Int, var valorUnitario: Double)
data class ItemBebida(var nome: String, var quantidade: Int, var valorUnitario: Double)

class AutoAtendimento {

    companion object {
        val carrinhoLanche = mutableListOf<ItemLanche>()
        val carrinhoBebida = mutableListOf<ItemBebida>()
    }

    fun lanche() {


        println("Escolha seu lanche")
        println("1 -> X-Burger\n2 -> X-Salada")
        val opcaoLanche = lerInteiro()

        when (opcaoLanche) {
            1 -> {
                println("X-Burguer selecionado")
                println("Digite a quantidade que deseja")
                val quantidadeXburguer = lerInteiro()
                val valor = 10.0
                println("Pedido adicionado no carrinho")
                val adicionarXburguer = ItemLanche("X-Burguer", quantidadeXburguer, valor)
                carrinhoLanche.add(adicionarXburguer)

                carrinho()
            }

            2 -> {
                println("X-Salada selecionado: ")
                println("Digite a quantidade que deseja: ")
                val quantidadeXsalada = lerInteiro()
                val valorXsalada = 12
                val total = quantidadeXsalada * valorXsalada
                val adicionarXsalada = ItemLanche("X-Salada", quantidadeXsalada, total.toDouble())
                println("Pedido adicionado no carrinho")
                carrinhoLanche.add(adicionarXsalada)

                carrinho()
            }

            else -> {
                println("Opção inválida")
                println("AVISO -> Retornando as opções do cardapio!")
            }
        }
    }

    fun bebidas() {

        println("Escolha sua Bebida")
        println("1 -> Refrigerante \n2 -> Suco Natural")
        val opcaoBebida = lerInteiro()

        when (opcaoBebida) {
            1 -> {
                println("Refrigerante selecionado: ")
                println("Dite a quantidade que deseja: ")
                val quantidadeRefri = lerInteiro()
                val precoRefri = 8
                val adicionarRefri = ItemBebida("Refrigerante", quantidadeRefri, precoRefri.toDouble())
                carrinhoBebida.add(adicionarRefri)
                carrinho()

            }

            2 -> {
                println("Suco Natural selecionado: ")
                println("Dite a quantidade que deseja: ")
                val quantidadeSuco = lerInteiro()
                val precoSuco = 6
                val adicionarSuco = ItemBebida("Suco Natural", quantidadeSuco, precoSuco.toDouble())
                carrinhoBebida.add(adicionarSuco)
                carrinho()
            }

            else -> {
                println("Opção inválida")
                println("AVISO -> Retornando as opções do cardapio!")

            }
        }
    }
    fun carrinho() {
        val codigo = (1..30).random()
        println("Seu carrinho:")

        val totalLanches = carrinhoLanche.sumOf { it.valorUnitario * it.quantidade }
        carrinhoLanche.forEach { itemLanche ->
            println("Lanche: ${itemLanche.nome}\nQuantidade: ${itemLanche.quantidade}\nCódigo: ${codigo}\nTotal: R$${itemLanche.valorUnitario * itemLanche.quantidade}")
        }

        val totalBebidas = carrinhoBebida.sumOf { it.valorUnitario * it.quantidade }
        carrinhoBebida.forEach { itemBebida ->
            println("Bebida: ${itemBebida.nome}\nQuantidade: ${itemBebida.quantidade}\nCódigo: ${codigo}\nTotal: R$${itemBebida.valorUnitario * itemBebida.quantidade}")
        }

        val totalAPagar = totalLanches + totalBebidas

        println("Escolha uma opção (1- Finalizar o pedido 2- Editar item)")

        val opcaoDigitada = lerInteiro()
        if (opcaoDigitada == 1) {
            efetuarPagamento(totalAPagar)
        } else if (opcaoDigitada == 2) {
            editarItem()
        } else {
            println("Opção inválida! Escolha uma opção")
        }
    }

    fun removerItens() {
        println("Escolha uma opção para remover:")
        println("1-> X-Burguer \n2-> X-Salada \n3 -> Refrigerante \n4 -> Suco Natural")
        val opcaoRemover = lerInteiro()

        when (opcaoRemover) {
            1 -> {
                if (carrinhoLanche.isNotEmpty()) {
                    println("Digite a quantidade que deseja remover")
                    val quantidadeRemovida = lerInteiro()
                    println("Quantidade removida foi: $quantidadeRemovida")

                    val itemRemover = carrinhoLanche.find { it.nome == "X-Burguer" }
                    if (itemRemover != null && itemRemover.quantidade >= quantidadeRemovida) {
                        itemRemover.quantidade -= quantidadeRemovida
                        carrinho()
                    } else {
                        println("Quantidade inválida! A quantidade a ser removida não pode ser maior do que a quantidade presente no carrinho.")
                    }
                } else {
                    println("Carrinho de Lanches vazio!")
                }
            }

            2 -> {
                if (carrinhoLanche.isNotEmpty()) {
                    println("Digite a quantidade que deseja remover")
                    val quantidadeRemovida = lerInteiro()
                    println("Quantidade removida foi: $quantidadeRemovida")

                    val itemRemover = carrinhoLanche.find { it.nome == "X-Salada" }
                    if (itemRemover != null && itemRemover.quantidade >= quantidadeRemovida) {
                        itemRemover.quantidade -= quantidadeRemovida
                        carrinho()
                    } else {
                        println("Quantidade inválida! A quantidade a ser removida não pode ser maior do que a quantidade presente no carrinho.")
                    }
                } else {
                    println("Carrinho de Lanches vazio!")
                }
            }

            3 -> {
                if (carrinhoBebida.isNotEmpty()) {
                    println("Digite a quantidade que deseja remover")
                    val quantidadeRemovida = lerInteiro()
                    println("Quantidade removida foi: $quantidadeRemovida")

                    val itemRemover = carrinhoBebida.find { it.nome == "Refrigerante" }
                    if (itemRemover != null && itemRemover.quantidade >= quantidadeRemovida) {
                        itemRemover.quantidade -= quantidadeRemovida
                        carrinho()
                    } else {
                        println("Quantidade inválida! A quantidade a ser removida não pode ser maior do que a quantidade presente no carrinho.")
                    }
                } else {
                    println("Carrinho de Bebidas vazio!")
                }
            }

            4 -> {
                if (carrinhoBebida.isNotEmpty()) {
                    println("Digite a quantidade que deseja remover")
                    val quantidadeRemovida = lerInteiro()
                    println("Quantidade removida foi: $quantidadeRemovida")

                    val itemRemover = carrinhoBebida.find { it.nome == "Suco Natural" }
                    if (itemRemover != null && itemRemover.quantidade >= quantidadeRemovida) {
                        itemRemover.quantidade -= quantidadeRemovida
                        carrinho()
                    } else {
                        println("Quantidade inválida! A quantidade a ser removida não pode ser maior do que a quantidade presente no carrinho.")
                    }
                } else {
                    println("Carrinho de Bebidas vazio!")
                }
            }

            else -> {
                println("Opção inválida")
            }
        }
    }

    fun lerInteiro(): Int {
        var valor: Int? = null
        while (valor == null) {
            try {
                valor = readln()?.toInt()
            } catch (e: NumberFormatException) {
                println("Formato inválido, para escolher o item, voce deve informar o numero dele")
            }
        }
        return valor
    }

    fun efetuarPagamento(total: Double) {
        println("Formas de pagamento:")
        println("1 -> Dinheiro")
        println("2 -> Cartão de Crédito")
        println("3 -> Cartão de Debito")
        println("4 -> Vale refeição")
        val opcaoPagamento = lerInteiro()

        when (opcaoPagamento) {
            1 -> {
                println("Digite o valor em dinheiro:")
                val valorEmDinheiro = readln()?.toDoubleOrNull() ?: 0.0

                if (valorEmDinheiro >= total) {
                    val troco = valorEmDinheiro - total
                    println("Pagamento realizado com sucesso! Troco: R$%.2f".format(troco))
                } else {
                    println("Valor insuficiente. Pagamento não efetuado.")
                    carrinho()
                }
            }
            2 -> {
                println("Pagamento no cartão de crédito realizado.")
            }

            3 -> {
                println("Pagamento no cartão de debito realizado.")
            }

            4 -> {
                println("Pagamento no cartão refeição realizado.")
            }
            else -> {
                println("Opção inválida. Pagamento não efetuado.")
                carrinho()
            }
        }
    }

    fun editarItem() {

        val editar = AutoAtendimento()

        println("Escolha a edição (1- Adicionar Lanche 2- Adicionar Bebida 3- Remover item): ")

        val opcaoEditar = lerInteiro()

        when (opcaoEditar) {
            1 -> lanche()
            2 -> bebidas()
            3 -> editar.removerItens()
            else -> {
                println("Opção invalida.")
            }
        }
    }
}
