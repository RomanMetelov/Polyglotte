package com.polyglotte.menu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.polyglotte.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

	private lateinit var viewModel: MenuViewModel

	private var _binding: FragmentMenuBinding? = null
	private val binding get() = _binding!!
	// This property is only valid between onCreateView and onDestroyView.

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentMenuBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel = ViewModelProvider(this).get(MenuViewModel::class.java)
		setupObservers()
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	private fun setupObservers() {
		val centerTextView: TextView = binding.tvCenter
		viewModel.text.observe(viewLifecycleOwner, {
			centerTextView.text = it
		})

		val networkTextView: TextView = binding.result
		viewModel.networkResponse.observe(viewLifecycleOwner, {
			networkTextView.text = it
		})
	}

	companion object {
		fun newInstance() = MenuFragment()
	}
}
