package com.example.fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// A Interface IComunicador é implementada na MainActivity como uma forma de estabelecer a comunicação
// entre o fragmento A e o fragmento B, por meio da implementação das funções somar() e diminuir().
class MainActivity : AppCompatActivity(), IComunicador {

    //declaração dos fragmentos que são adicionados na Activity
    private lateinit var fragment1: FragmentA
    private lateinit var fragment2: FragmentB


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //função que vai inicializar e adicionar os fragmentos na activity
        initFragments()
    }

    //Função responsável por incrementar o contador, implementada a partir da interface IComunicador
    override fun somar() {
        //chamado da função que atualiza o valor do contador, no fragmento2, passando valor a ser somado
        fragment2.setResult(1)

    }

    //Função responsável por decrementar o contador, implementada a partir da interface IComunicador
    override fun diminuir() {
        //chamado da função que atualiza o valor do contador, no fragmento2, passando valor a ser diminuido
        fragment2.setResult(-1)

    }

    // Inicializa e comita os fragmentos na activity
    private fun initFragments(){

        // cria objetos dos fragmentos A e B
        fragment1 = FragmentA()
        fragment2 = FragmentB()

        //criando um gerenciador de fragmentos
        val fragmentmanager = supportFragmentManager
        // objeto que faz as transações dos fragmentos
        val fragmentTransaction = fragmentmanager.beginTransaction()

        //adicionando o fragmento1 no container A da main activity
        fragmentTransaction.add(R.id.container_a,fragment1)

        //adicionando o fragmento2 no container B da main activity
        fragmentTransaction.add(R.id.container_b,fragment2)

        //comitando as transações na activity
        fragmentTransaction.commit()

//        supportFragmentManager
//            .beginTransaction()
//            .add(R.id.container_a,fragment1)
//            .add(R.id.container_b,fragment2)
//            .commit()
    }
}