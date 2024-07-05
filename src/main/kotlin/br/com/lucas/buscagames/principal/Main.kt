package org.example.br.com.lucas.buscagames.principal

import br.com.lucas.buscagames.servicos.ConsumoApi
import org.example.br.com.lucas.buscagames.modelos.Jogo
import java.util.*


fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite o Codigo do jogo: ")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()
    val informacaoJogo = buscaApi.buscaJogo(busca)

    var meuJogo: Jogo? = null


    val resultado = runCatching {
        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )

        println(meuJogo)
    }

    resultado.onFailure {
        println("Jogo Inexistente")
    }

    resultado.onSuccess {
        println("Deseja inserir uma Descricao personalizada? (S/N)")
        val opcao = leitura.nextLine()
        if (opcao.equals("S", true)) {
            println("Insira a Descricao personalizada para o Game:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }
        println(meuJogo)
    }


}
