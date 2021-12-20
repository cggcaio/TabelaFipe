package br.com.gerencianet.tabelafipe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.gerencianet.tabelafipe.databinding.ItemModelBinding
import br.com.gerencianet.tabelafipe.domain.model.ModelModel

class ModelListAdapter() :
    ListAdapter<ModelModel, ModelListAdapter.ModelListViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<ModelModel>() {
        override fun areItemsTheSame(
            oldItem: ModelModel,
            newItem: ModelModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ModelModel,
            newItem: ModelModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    class ModelListViewHolder(private val mBinding: ItemModelBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        companion object {
            fun from(parent: ViewGroup): ModelListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemModelBinding.inflate(layoutInflater, parent, false)
                return ModelListViewHolder(binding)
            }
        }

        // Essa função tem a finalidade de setar nome, cor de cada item da recycler, tudo dentro dessa função
        fun bind(model: ModelModel) {
            mBinding.tvModel.text = model.name
            mBinding.executePendingBindings() // Na última linha do binding sempre essar esse código, se tiver algum binding pendente ele executa
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ModelListViewHolder = ModelListViewHolder.from(parent)

    override fun onBindViewHolder(holder: ModelListAdapter.ModelListViewHolder, position: Int) {
        getItem(position)?.let { safeModel ->
            holder.bind(safeModel)
        }
    }
}
