package br.com.gerencianet.tabelafipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.gerencianet.tabelafipe.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private lateinit var mBinding: FragmentStartBinding
    private val mController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.bNext.setOnClickListener {
            StartFragmentDirections.actionStartFragmentToSecondFragment().run {
                mController.navigate(this)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentStartBinding.inflate(inflater, container, false)
        return mBinding.root
    }
}
