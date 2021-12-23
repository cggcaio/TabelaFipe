package br.com.gerencianet.tabelafipe.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.gerencianet.tabelafipe.adapter.YearListAdapter
import br.com.gerencianet.tabelafipe.databinding.FragmentSecondBinding
import br.com.gerencianet.tabelafipe.databinding.FragmentThirdBinding
import br.com.gerencianet.tabelafipe.domain.model.YearModel

class ThirdFragment : Fragment() {

    private lateinit var mBinding: FragmentThirdBinding
    private val mController by lazy { findNavController() }

    // private val mAdapter: ModelListAdapter = ModelListAdapter()
    private val mAdapter: YearListAdapter = YearListAdapter() { year ->
        Toast.makeText(requireContext(), year.name, Toast.LENGTH_LONG).show()
    }

    private var mList: List<YearModel> = listOf(
        YearModel(id = 0L, name = "2000-1"),
        YearModel(id = 1L, name = "2010-1"),
        YearModel(id = 2L, name = "2010-2"),
        YearModel(id = 3L, name = "2011-1"),
        YearModel(id = 4L, name = "2011-2"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentThirdBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.rvYear.adapter = mAdapter
        mAdapter.submitList(mList)
        mBinding.bNext.setOnClickListener {
            ThirdFragmentDirections.actionThirdFragmentToFourthFragment()
                .run {
                    mController.navigate(this)
                }
        }
        mBinding.bBack.setOnClickListener {
            ThirdFragmentDirections.actionThirdFragmentToSecondFragment()
                .run {
                    mController.navigate(this)
                }
        }
    }
}
