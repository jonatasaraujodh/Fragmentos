package com.example.fragmentos

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FragmentA : Fragment() {

    //variável responsável por referenciar o contexto (activity) que contém o fragmento.
    private lateinit var callback: IComunicador

    private var contador: Int = 0

    // variaveis que conterão os elementos de botão do layout
    private lateinit var botaoMais: Button
    private lateinit var botaoMenos: Button

    // na função onAttach, definimos uma referência para a activity, através do callback
    override fun onAttach(activity: Context) {
        super.onAttach(activity)

        // Se a activity que adicionou o fragmento implementa a Interface IComunicador, então
        // o callback passa a referenciar a propria activity.
        //Caso contrário, é lançada uma exceção em tempo de execução.
        if(activity is IComunicador){
            callback = activity

        }else{
            throw RuntimeException(activity.toString() + "Callback não implementado")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // variável que vai capturar o conteúdo do fragmento A
        val view: View =  inflater.inflate(R.layout.fragment_a, container, false)

        // recuperando os elementos de botão do layout
        botaoMais = view.findViewById(R.id.bt_mais)
        botaoMenos = view.findViewById(R.id.bt_menos)

        // aplicando tratamento aos eventos de clique nos botões
        botaoMais.setOnClickListener {
            // o callback chama a função somar, da interface IComunicador, implementada na MainActivity
            callback.somar()
        }
        botaoMenos.setOnClickListener {
            // o callback chama a função diminuir, da interface IComunicador, implementada na MainActivity
            callback.diminuir()
        }
        return view
    }


}