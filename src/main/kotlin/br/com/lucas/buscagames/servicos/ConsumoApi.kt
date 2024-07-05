package br.com.lucas.buscagames.servicos

import com.google.gson.Gson
import org.example.br.com.lucas.buscagames.modelos.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {

        fun buscaJogo(id: String):InfoJogo {

            val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

            val client: HttpClient = HttpClient.newHttpClient()
            val request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build()
            val response = client
                .send(request, HttpResponse.BodyHandlers.ofString())

            val json = response.body()
            println(json)

            val gson = Gson()
            val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

            return meuInfoJogo
        }

    }
