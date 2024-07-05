package org.example.br.com.lucas.buscagames.modelos

data class InfoJogo(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}