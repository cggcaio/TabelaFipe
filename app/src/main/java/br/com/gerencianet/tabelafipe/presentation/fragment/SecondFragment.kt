package br.com.gerencianet.tabelafipe.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.gerencianet.tabelafipe.adapter.ModelListAdapter
import br.com.gerencianet.tabelafipe.databinding.FragmentSecondBinding
import br.com.gerencianet.tabelafipe.domain.model.ModelModel

class SecondFragment : Fragment() {

    private lateinit var mBinding: FragmentSecondBinding
    private val mController by lazy { findNavController() }

    private val mAdapter: ModelListAdapter = ModelListAdapter() { model ->
        Toast.makeText(requireContext(), model.name, Toast.LENGTH_LONG).show()
    }

    private var mList: List<ModelModel> = listOf(
        ModelModel(id = 0L, name = "147 Furgão"),
        ModelModel(id = 1L, name = "500 Abarth Nultiair 1.4"),
        ModelModel(id = 2L, name = "Palio Celebration 1.0 Fire Flex 8V 2p"),
        ModelModel(id = 3L, name = "Palio City 1.0 4p"),
        ModelModel(id = 4L, name = "Siena Stile\\/Sport MTV 1.6 mpi 16V"),
        ModelModel(id = 5L, name = "Stilo 1.8 ATTRACTIVE Flex 8V 5p"),
        ModelModel(id = 6L, name = "Stilo 1.8 MS Lim.Edit.\\/ MS Season 16V"),
        ModelModel(id = 7L, name = "Strada LX 1.6 mpi 16V"),
        ModelModel(id = 8L, name = "Strada LX 1.6 mpi 16V"),
        ModelModel(id = 9L, name = "Strada LX 1.6 mpi 16V"),
        ModelModel(id = 10L, name = "Strada LX 1.6 mpi 16V"),
        ModelModel(id = 11L, name = "Strada LX 1.6 mpi 16V"),
        ModelModel(id = 12L, name = "Strada LX 1.6 mpi 16V")

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentSecondBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvModel.adapter = mAdapter
        mAdapter.submitList(mList)
        mBinding.bNext.setOnClickListener {
            SecondFragmentDirections.actionSecondFragmentToThirdFragment()
                .run {
                    mController.navigate(this)
                }
        }
        mBinding.bBack.setOnClickListener {
            SecondFragmentDirections.actionSecondFragmentToStartFragment()
                .run {
                    mController.navigate(this)
                }
        }
    }
}
