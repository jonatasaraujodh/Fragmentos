package com.example.fragmentos

// A Interface IComunicador é o contrato estabelecido para comunicação entre os fragmentos.
// Deve ser implementada na Activity que contém os fragmentos.
interface IComunicador {

    //Função responsável por incrementar o contador.
    fun somar()

    //Função responsável por decrementar o contador.
    fun diminuir()

}