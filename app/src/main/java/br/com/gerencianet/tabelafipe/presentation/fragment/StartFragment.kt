package br.com.gerencianet.tabelafipe.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.gerencianet.tabelafipe.adapter.ManufacturerListAdapter
import br.com.gerencianet.tabelafipe.databinding.FragmentStartBinding
import br.com.gerencianet.tabelafipe.domain.model.ManufacturerModel
import br.com.gerencianet.tabelafipe.presentation.TabelaFipeApp
import br.com.gerencianet.tabelafipe.presentation.viewmodel.FipeViewModel
import javax.inject.Inject

class StartFragment : Fragment() {

    private lateinit var mBinding: FragmentStartBinding
    private val mController by lazy { findNavController() }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val mViewModel: FipeViewModel by viewModels<FipeViewModel> { viewModelFactory }

    private val mAdapter: ManufacturerListAdapter = ManufacturerListAdapter() { manufacturer ->
        Toast.makeText(requireContext(), manufacturer.name, Toast.LENGTH_LONG).show()
    }

    private var mList: List<ManufacturerModel> = listOf(
        ManufacturerModel(id = 0L, name = "Acura"),
        ManufacturerModel(id = 5L, name = "Citroen"),
        ManufacturerModel(id = 1L, name = "Fiat"),
        ManufacturerModel(id = 2L, name = "Mercedes"),
        ManufacturerModel(id = 3L, name = "Toyota"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks"),
        ManufacturerModel(id = 4L, name = "Volks")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentStartBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        TabelaFipeApp.appComponent.inject(this)
        super.onViewCreated(view, savedInstanceState)
        mViewModel.getManufacturerList()
        mBinding.rvManufacturer.adapter = mAdapter
        mAdapter.submitList(mList)
        mBinding.bNext.setOnClickListener {
            StartFragmentDirections.actionStartFragmentToSecondFragment()
                .run {
                    mController.navigate(this)
                }
        }
    }
}
