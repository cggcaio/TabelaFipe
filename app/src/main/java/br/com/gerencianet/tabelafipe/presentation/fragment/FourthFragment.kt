package br.com.gerencianet.tabelafipe.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.gerencianet.tabelafipe.adapter.PriceListAdapter
import br.com.gerencianet.tabelafipe.databinding.FragmentFourthBinding
import br.com.gerencianet.tabelafipe.domain.model.PriceModel

class FourthFragment : Fragment() {

    private lateinit var mBinding: FragmentFourthBinding
    private val mController by lazy { findNavController() }

    private val mAdapter: PriceListAdapter = PriceListAdapter() { model ->
        Toast.makeText(requireContext(), model.name, Toast.LENGTH_LONG).show()
    }

    private var mList: List<PriceModel> = listOf(
        PriceModel(id = 0L, name = "147 Furgão"),
        PriceModel(id = 0L, name = "147 Furgão")

    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentFourthBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvPrice.adapter = mAdapter
        mAdapter.submitList(mList)

        mBinding.bBack.setOnClickListener {
            SecondFragmentDirections.actionSecondFragmentToStartFragment()
                .run {
                    mController.navigate(this)
                }
        }
    }
}
