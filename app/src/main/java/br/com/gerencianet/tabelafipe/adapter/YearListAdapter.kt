package br.com.gerencianet.tabelafipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.gerencianet.tabelafipe.databinding.ItemYearBinding
import br.com.gerencianet.tabelafipe.domain.model.YearModel

class YearListAdapter(private val mClick: (year: YearModel) -> Unit) : // Dentro dos parenteses está o callback
    ListAdapter<YearModel, YearListAdapter.YearListViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<YearModel>() {
        override fun areItemsTheSame(
            oldItem: YearModel,
            newItem: YearModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: YearModel,
            newItem: YearModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    class YearListViewHolder(private val mBinding: ItemYearBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        companion object {
            fun from(parent: ViewGroup): YearListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemYearBinding.inflate(layoutInflater, parent, false)
                return YearListViewHolder(binding)
            }
        }

        // Essa função tem a finalidade de setar nome, cor de cada item da recycler, tudo dentro dessa função
        fun bind(
            year: YearModel,
            mClick: (manufacturer: YearModel) -> Unit
        ) {
            mBinding.tvYear.text = year.name
            mBinding.clYearItem.setOnClickListener {
                mClick(year)
            }
            mBinding.executePendingBindings() // Na última linha do binding sempre essar esse código, se tiver algum binding pendente ele executa
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): YearListViewHolder = YearListViewHolder.from(parent)

    override fun onBindViewHolder(
        holder: YearListViewHolder,
        position: Int
    ) {
        // A interrogação verifica se não é null e a palavra safeManufacturer substitui o it que é padrão
        getItem(position)?.let { safeYear ->
            holder.bind(safeYear, mClick)
        }
    }
}
