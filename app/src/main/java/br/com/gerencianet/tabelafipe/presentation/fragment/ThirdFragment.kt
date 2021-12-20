package br.com.gerencianet.tabelafipe.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.gerencianet.tabelafipe.adapter.ModelListAdapter
import br.com.gerencianet.tabelafipe.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private lateinit var mBinding: FragmentThirdBinding
    private val mController by lazy { findNavController() }
    private val mAdapter: ModelListAdapter = ModelListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentThirdBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}
