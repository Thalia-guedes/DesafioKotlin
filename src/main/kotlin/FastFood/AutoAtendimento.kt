package FastFood

data class ItemLanche(var nome: String, var quantidade: Int, var valorUnitario: Double)
data class ItemBebida(var nome: String, var quantidade: Int, var valorUnitario: Double)

class FastFood {

    companion object {
        val Xburguer = mutableListOf<ItemLanche>()
        val Xsalada = mutableListOf<ItemLanche>()
        val refrigerante = mutableListOf<ItemBebida>()
        val suco = mutableListOf<ItemBebida>()
        val pagar = mutableListOf<Double>()
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
                val codigoXburguer = 1
                val valor = 10.0
                val total = quantidadeXburguer * valor
                println("Pedido adicionado no carrinho")
                val adicionarXburguer = ItemLanche("X-Burguer", quantidadeXburguer, valor)

                println(
                    "Resumo: Lanche: X-Burguer\n\t Quantidade: $quantidadeXburguer\n\t" +
                            " codigo: $codigoXburguer\n\t Total: R$${total}"
                )
                Xburguer.add(adicionarXburguer)

                carrinho()
            }

            2 -> {
                println("X-Salada selecionado: ")
                println("Digite a quantidade que deseja: ")
                val quantidadeXsalada = lerInteiro()
                val codigoXsalada = 2
                val valorXsalada = 12
                val total = quantidadeXsalada * valorXsalada
                val adicionarXsalada = ItemLanche("X-Salada", quantidadeXsalada, total.toDouble())
                println("PEDIDO ADICIONADO NO CARRINHO")

                println(
                    "RESUMO: Lanche: X-Salada\n\t Quantidade: $quantidadeXsalada\n\t" +
                            " Codigo: $codigoXsalada\n\t Total: R$${total}"
                )
                Xsalada.add(adicionarXsalada)

                carrinho()
            }

            else -> {
                println("Opção inválida")
                println("AVISO -> Retornando as opções do cardapio!")
            }
        }
    }

    fun carrinho() {

        println("Seu carrinho:")
        if (Xburguer.isNotEmpty()) {
            Xburguer.forEach { item ->
                val totalXburguer = item.valorUnitario * item.quantidade
                println("Lanche: ${item.nome}\nQuantidade: ${item.quantidade}\nTotal: R$${totalXburguer}")

                pagar.add(totalXburguer.toDouble())
            }
        }
        if (Xsalada.isNotEmpty()) {
            Xsalada.forEach { item ->
                val totalXsalada = item.valorUnitario * item.quantidade
                println("Lanche: ${item.nome}\nQuantidade: ${item.quantidade}\nTotal: R$$totalXsalada")

                pagar.add(totalXsalada)

                val somar = pagar.sum()
                println("Valor total : R$$somar")
            }

        }
        if (refrigerante.isNotEmpty()) {
            refrigerante.forEach { item ->
                val totalRefri = item.valorUnitario * item.quantidade
                println("Lanche: ${item.nome}\nQuantidade: ${item.quantidade}\nTotal: R$$totalRefri")

                pagar.add(totalRefri)

                val somar = pagar.sum()
                println("Valor total : R$$somar")
            }

        }
        if (suco.isNotEmpty()) {
            suco.forEach { item ->
                val totalSuco = item.valorUnitario * item.quantidade
                println("Lanche: ${item.nome}\nQuantidade: ${item.quantidade}\nTotal: R$$totalSuco")

                pagar.add(totalSuco)

                val somar = pagar.sum()
                println("Valor total : R$$somar")
            }
        }

        println("Escolha uma opção (1- Finalizar o pedido 2- Editar item)")
        val opcaoDigitada = lerInteiro()
        if (opcaoDigitada == 1) {
            efetuarPagamento()
        } else if (opcaoDigitada == 2) {
            editarItem()
        } else {
            println("Opção invalida! Escolha uma opção")
        }
    }

    fun bebidas() {
        val sair = false

        while (!sair) {
            println("Escolha sua Bebida")
            println("1 -> Refrigerante \n2 -> Suco Natural")
            val opcaoBebida = lerInteiro()

            when (opcaoBebida) {
                1 -> {
                    println("Refrigerante selecionado: ")
                    println("Dite a quantidade que deseja: ")
                    val quantidadeRefri = lerInteiro()
                    val codigoRefri = 3
                    val precoRefri = 8
                    val total = quantidadeRefri * precoRefri
                    val adicionarRefri = ItemBebida("Refrigerante", quantidadeRefri, precoRefri.toDouble())
                    println("PEDIDO ADICIONADO NO CARRINHO")
                    println(
                        "RESUMO: Refrigerante:\n\t Quantidade: $quantidadeRefri\n\t" +
                                " Codigo: $codigoRefri\n\t Total: R$${total}"
                    )
                    refrigerante.add(adicionarRefri)

                    carrinho()
                }

                2 -> {
                    println("Suco Natural selecionado: ")
                    println("Dite a quantidade que deseja: ")
                    val quantidadeSuco = lerInteiro()
                    val codigoSuco = 4
                    val precoSuco = 6
                    val total = quantidadeSuco * precoSuco
                    val adicionarSuco = ItemBebida("Suco Natural", quantidadeSuco, precoSuco.toDouble())
                    println("PEDIDO ADICIONADO NO CARRINHO")
                    println(
                        "RESUMO: Suco Natural:\n\t Quantidade: $quantidadeSuco\n\t" +
                                " Codigo: $codigoSuco\n\t Total: R$${total}"
                    )
                    suco.add(adicionarSuco)
                    carrinho()
                }
                else -> {
                    println("Opção inválida")
                    println("AVISO -> Retornando as opções do cardapio!")
                    continue
                }
            }
        }
    }

    fun removerItens() {

        println("Deseja remover algum item do carrinho? (1-Sim/2-Não)")
        val removerItens = lerInteiro()

        if (removerItens == 1) {
            println("Escolha uma opção para remover:")
            println("1-> X-Burguer \n2-> X-Salada \n3 -> Refrigerante \n4 -> Suco Natural")
            val opcaoRemover = lerInteiro()
            when (opcaoRemover) {
                1 -> {
                    if (Xburguer.isNotEmpty()) {
                        println("Digite a quantidade que deseja remover")
                        val quantidadeRemovida = lerInteiro()
                        println("Quantidade removida foi: $quantidadeRemovida")

                        println("Itens no carrinho -> ")
                        if (Xburguer.isNotEmpty()) {
                            Xburguer.forEach { item ->
                                val total = quantidadeRemovida - item.quantidade
                                val valorFinal = total * item.valorUnitario
                                println("Nome: ${item.nome}\nQuantidade: ${total}\nValor final R$$valorFinal")
                                pagar.add(valorFinal)
                                efetuarPagamento()


                            }
                        }
                    }
                }
                2 -> {
                    if (Xsalada.isNotEmpty()) {
                        println("Digite a quantidade que deseja remover")
                        val quantidadeRemovida = lerInteiro()
                        println("Quantidade removida foi: $quantidadeRemovida")

                        println("Pedido finalizado:")
                        println("Itens no carrinho -> ")
                        if (Xsalada.isNotEmpty()) {
                            Xsalada.forEach { item ->
                                val total = quantidadeRemovida - item.quantidade
                                val valorFinal = total * item.valorUnitario
                                println("Nome: ${item.nome}\nQuantidade: ${total}\nValor final R$$valorFinal")

                                pagar.add(valorFinal)
                                efetuarPagamento()
                            }
                        }
                    }
                }

                3 -> {
                    if (refrigerante.isNotEmpty()) {
                        println("Digite a quantidade que deseja remover")
                        val quantidadeRemovida = lerInteiro()
                        println("Quantidade removida foi: $quantidadeRemovida")

                        println("Pedido finalizado:")
                        println("Itens no carrinho -> ")
                        if (refrigerante.isNotEmpty()) {
                            refrigerante.forEach { item ->
                                val total = quantidadeRemovida - item.quantidade
                                val valorFinal = total * item.valorUnitario
                                println("Nome: ${item.nome}\nQuantidade: ${total}\nValor final R$$valorFinal")

                                pagar.add(valorFinal)
                                efetuarPagamento()
                            }
                        }
                    }
                }

                4 -> {
                    if (suco.isNotEmpty()) {
                        println("Digite a quantidade que deseja remover")
                        val quantidadeRemovida = lerInteiro()
                        println("Quantidade removida foi: $quantidadeRemovida")

                        println("Pedido finalizado:")
                        println("Itens no carrinho -> ")
                        if (suco.isNotEmpty()) {
                            suco.forEach { item ->
                                val total = quantidadeRemovida - item.quantidade
                                val valorFinal = total * item.valorUnitario
                                println("Nome: ${item.nome}\nQuantidade: ${total}\nValor final R$$valorFinal")

                                pagar.add(valorFinal)
                                efetuarPagamento()
                            }
                        }
                    }
                }
                else -> {
                    println("Opção inválida")
                }
            }
        } else {
            println("Opção invalida!")
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

    fun efetuarPagamento() {

        val total = pagar.sum()

        println("Formas de pagamento:")
        println("1 -> Dinheiro")
        println("2 -> Cartão de Crédito")
        println("3 -> Cartão de Debito")
        println("4 -> Vale refeição")

        val opcaoPagamento = lerInteiro()

        when (opcaoPagamento) {
            1 -> {
                println("Digite o valor em dinheiro:")
                val valorEmDinheiro = readln().toDouble()
                if (valorEmDinheiro >= total) {
                    val troco = valorEmDinheiro - total
                    println("Pagamento realizado com sucesso! Troco: R$%.2f".format(troco))
                } else {
                    println("Valor insuficiente. Pagamento não efetuado.")
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
            else -> println("Opção inválida. Pagamento não efetuado.")
        }
    }

    fun editarItem() {

        val editar = FastFood()

        println("Escolha o item (1- Lanche 2- Bebidas): ")
        val opcaoEditar = lerInteiro()

        when (opcaoEditar) {
            1 -> {
                println("1- Para adicionar 2- Para remover")
                val opcao = lerInteiro()
                if (opcao == 1) {
                    lanche()
                } else {
                    editar.removerItens()
                }
            }
            2 -> {
                println("1- Para adicionar 2- Para remover")
                val opcao = lerInteiro()
                if (opcao == 1) {
                    lanche()
                } else {
                    editar.removerItens()
                }
            }
        }
    }
}