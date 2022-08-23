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

class FeaturesListAdapter(private val items: Map<Int, AppFeatureName>) :
	RecyclerView.Adapter<FeaturesListAdapter.FeatureListItemViewHolder>() {

	inner class FeatureListItemViewHolder(view: View) : RecyclerView.ViewHolder(view), MyClickListener {
		fun bind(name: String) {
			itemView.run {
				findViewById<TextView>(R.id.tv_feature_name).text = name
				findViewById<Button>(R.id.btn_up).setOnClickListener {

				}
				findViewById<Button>(R.id.btn_down).setOnClickListener {

				}
			}
		}

		override fun onClickUp(p: Int) {
			TODO("Not yet implemented")
		}

		override fun onClickDown(p: Int) {
			TODO("Not yet implemented")
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureListItemViewHolder {
		val view = LayoutInflater.from(parent.context)
			.inflate(R.layout.lv_item, parent, false)

		return FeatureListItemViewHolder(view)
	}

	override fun onBindViewHolder(holder: FeaturesListAdapter.FeatureListItemViewHolder, position: Int) {
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
