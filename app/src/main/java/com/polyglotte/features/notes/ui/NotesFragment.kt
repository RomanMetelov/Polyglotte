package com.polyglotte.features.notes.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.polyglotte.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

	private lateinit var viewModel: NotesViewModel

	private var _binding: FragmentNotesBinding? = null
	private val binding get() = _binding!!
	// This property is only valid between onCreateView and onDestroyView.

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentNotesBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
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
		fun newInstance() = NotesFragment()
	}
}
