package br.com.gerencianet.tabelafipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.gerencianet.tabelafipe.databinding.ItemManufacturerBinding
import br.com.gerencianet.tabelafipe.domain.model.ManufacturerModel

// ManufacturerModel é o meu Data Class que cria/define um objeto

class ManufacturerListAdapter(private val mClick: (manufacturer: ManufacturerModel) -> Unit) : // Dentro dos parenteses está o callback
    ListAdapter<ManufacturerModel, ManufacturerListAdapter.ManufacturerListViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<ManufacturerModel>() {
        override fun areItemsTheSame(
            oldItem: ManufacturerModel,
            newItem: ManufacturerModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ManufacturerModel,
            newItem: ManufacturerModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    class ManufacturerListViewHolder(private val mBinding: ItemManufacturerBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        companion object {
            fun from(parent: ViewGroup): ManufacturerListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemManufacturerBinding.inflate(layoutInflater, parent, false)
                return ManufacturerListViewHolder(binding)
            }
        }

        // Essa função tem a finalidade de setar nome, cor de cada item da recycler, tudo dentro dessa função
        fun bind(
            manufacturer: ManufacturerModel,
            mClick: (manufacturer: ManufacturerModel) -> Unit
        ) {
            mBinding.tvManufacturer.text = manufacturer.name
            mBinding.clManufacturerItem.setOnClickListener {
                mClick(manufacturer)
            }
            mBinding.executePendingBindings() // Na última linha do binding sempre essar esse código, se tiver algum binding pendente ele executa
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ManufacturerListViewHolder = ManufacturerListViewHolder.from(parent)

    override fun onBindViewHolder(
        holder: ManufacturerListViewHolder,
        position: Int
    ) {
        // A interrogação verifica se não é null e a palavra safeManufacturer substitui o it que é padrão
        getItem(position)?.let { safeManufacturer ->
            holder.bind(safeManufacturer, mClick)
        }
    }
}
