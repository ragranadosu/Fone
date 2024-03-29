package com.fone.fonetesting.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.fone.fonetesting.R
import com.fone.fonetesting.architecture_components.GameViewModel
import kotlinx.android.synthetic.main.fragment_complete_words.*
import kotlinx.android.synthetic.main.fragment_complete_words.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Complete_words : Fragment() {

    lateinit var fragmentView: View

    var listenerTool :  SearchNewMovieListener? = null

    interface SearchNewMovieListener{

        fun nextWord()

        fun option1()
        fun option2()
        fun speak(text: String)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        val view= inflater.inflate(R.layout.fragment_complete_words, container, false).apply {

        }

        viewModel.getLevel().observe(this, Observer { gam->
            gam?.let {
                tv_cont.text=gam.nivel_juego1.toString()
            }

        })

        fragmentView = view

        fragmentView.indicaciones_walter.setOnClickListener {
            listenerTool?.speak("Selecciona la letra correcta que complete la palabra mostrada")
        }

        initSearchButton(view)

        initOption1(view)
        initOption2(view)



        return view

    }


    fun initSearchButton(container:View) = container.btn_verification.setOnClickListener {
        listenerTool?.nextWord()
    }

    fun initOption1(container:View) = container.opc1.setOnClickListener {
        listenerTool?.option1()
    }
    fun initOption2(container:View) = container.opc2.setOnClickListener {
        listenerTool?.option2()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SearchNewMovieListener) {
            listenerTool = context
        } else {
            throw RuntimeException("Se necesita una implementación de  la interfaz")
        }
    }
    override fun onDetach() {
        super.onDetach()
        listenerTool = null
    }


}
