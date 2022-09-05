package com.polyglotte.features.allfeatures

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.polyglotte.R
import com.polyglotte.app.data.AppFeatureName

class FeaturesListAdapter(private val items: MutableMap<Int, AppFeatureName>) :
    RecyclerView.Adapter<FeaturesListAdapter.FeatureListItemViewHolder>() {

    inner class FeatureListItemViewHolder(view: View) : RecyclerView.ViewHolder(view),
        MyClickListener {
        fun bind(name: String) {
            itemView.run {
                findViewById<TextView>(R.id.tv_feature_name).text = name
                findViewById<Button>(R.id.btn_up).setOnClickListener {
                    onClickUp(adapterPosition)
                }
                findViewById<Button>(R.id.btn_down).setOnClickListener {
                    onClickDown(adapterPosition)
                }
            }
        }

        override fun onClickUp(p: Int) {
            if (p != 0){
                val item = items[p]
                items[p-1]?.let { items.put(p, it) }
                if (item != null) {
                    items[p-1] = item
                }
                notifyItemMoved(p, p-1)
            }

        }

        override fun onClickDown(p: Int) {
            if (p != items.size-1){
                val item = items[p]
                items[p+1]?.let { items.put(p, it) }
                if (item != null) {
                    items[p+1] = item
                }
                notifyItemMoved(p, p+1)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lv_item, parent, false)

        return FeatureListItemViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: FeaturesListAdapter.FeatureListItemViewHolder,
        position: Int
    ) {
        val item = items[position]
        item?.name?.let { holder.bind(it) }
        holder.itemView.setOnClickListener {
            //TODO
            //open Fragment
        }
    }

    override fun getItemCount(): Int = items.size

    companion object MyDiffUtil : DiffUtil.ItemCallback<AppFeatureName>() {
        override fun areItemsTheSame(oldItem: AppFeatureName, newItem: AppFeatureName): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: AppFeatureName, newItem: AppFeatureName): Boolean {
            return oldItem == newItem
        }
    }

    interface MyClickListener {
        fun onClickUp(p: Int)
        fun onClickDown(p: Int)
    }
}
