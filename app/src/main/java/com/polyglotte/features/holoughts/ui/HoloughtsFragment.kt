package com.polyglotte.features.holoughts.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.polyglotte.databinding.FragmentHoloughtsBinding

class HoloughtsFragment : Fragment() {

	private lateinit var viewModel: HoloughtsViewModel

	private var _binding: FragmentHoloughtsBinding? = null
	private val binding get() = _binding!!
	// This property is only valid between onCreateView and onDestroyView.

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentHoloughtsBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel = ViewModelProvider(this).get(HoloughtsViewModel::class.java)
		setupObservers()
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	private fun setupObservers() {
		val textView: TextView = binding.tvCenter
		viewModel.text.observe(viewLifecycleOwner, {
			textView.text = it
		})
	}

	companion object {
		fun newInstance() = HoloughtsFragment()
	}
}
