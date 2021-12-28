package br.com.gerencianet.tabelafipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.gerencianet.tabelafipe.databinding.ItemPriceBinding
import br.com.gerencianet.tabelafipe.domain.model.PriceModel

class PriceListAdapter(private val mClick: (price: PriceModel) -> Unit) : // Dentro dos parenteses está o callback
    ListAdapter<PriceModel, PriceListAdapter.PriceListViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<PriceModel>() {
        override fun areItemsTheSame(
            oldItem: PriceModel,
            newItem: PriceModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PriceModel,
            newItem: PriceModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    class PriceListViewHolder(private val mBinding: ItemPriceBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        companion object {
            fun from(parent: ViewGroup): PriceListAdapter.PriceListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPriceBinding.inflate(layoutInflater, parent, false)
                return PriceListAdapter.PriceListViewHolder(binding)
            }
        }

        // Essa função tem a finalidade de setar nome, cor de cada item da recycler, tudo dentro dessa função
        fun bind(
            year: PriceModel,
            mClick: (manufacturer: PriceModel) -> Unit
        ) {
            mBinding.tvPrice.text = year.name
            mBinding.clPriceItem.setOnClickListener {
                mClick(year)
            }
            mBinding.executePendingBindings() // Na última linha do binding sempre essar esse código, se tiver algum binding pendente ele executa
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PriceListViewHolder = PriceListViewHolder.from(parent)

    override fun onBindViewHolder(
        holder: PriceListViewHolder,
        position: Int
    ) {
        // A interrogação verifica se não é null e a palavra safeManufacturer substitui o it que é padrão
        getItem(position)?.let { safePrice ->
            holder.bind(safePrice, mClick)
        }
    }
}
