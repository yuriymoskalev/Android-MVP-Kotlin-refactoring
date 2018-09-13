package ru.wootography.cryptotest.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.wootography.cryptotest.R
import ru.wootography.cryptotest.models.CryptoItem
import ru.wootography.cryptotest.models.CryptoItems

class CryptoAdapter(private val cryptos: CryptoItems) : RecyclerView.Adapter<CryptoAdapter.CryptoVH>(){

    companion object {
        val TYPE_MINE = 0
        val TYPE_FORKED = 1
    }

    override fun onBindViewHolder(holder: CryptoVH, position: Int) {
        holder.bind(cryptos[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoVH {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_for_list, parent,
                false)
        return CryptoVH(itemView)

    }

    override fun getItemCount(): Int {
        return cryptos.size
    }


    class CryptoVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        private val cryptoName by lazy {
            itemView!!.findViewById<TextView>(R.id.tv_name)
        }
        private val cryptoSymbol by lazy {
            itemView!!.findViewById<TextView>(R.id.tv_symbol)
        }


        fun bind(crypto: CryptoItem) {
            cryptoName.text = crypto.name
            cryptoSymbol.text = crypto.symbol


        }
    }
}