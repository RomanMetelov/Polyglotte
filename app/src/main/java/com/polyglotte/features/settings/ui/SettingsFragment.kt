package com.polyglotte.features.settings.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.polyglotte.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

	private lateinit var viewModel: SettingsViewModel

	private var _binding: FragmentSettingsBinding? = null
	private val binding get() = _binding!!
	// This property is only valid between onCreateView and onDestroyView.

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentSettingsBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
		setupObservers()
		setupSettingsToolbarMenu()
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

	private fun setupSettingsToolbarMenu() {
		val menuHost: MenuHost = requireActivity()

		menuHost.addMenuProvider(object : MenuProvider {
			override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
				// Add menu items here
			}

			override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
				// Handle the menu selection
				if (menuItem.itemId == android.R.id.home)
					findNavController().navigateUp()
				return true
			}
		}, viewLifecycleOwner, Lifecycle.State.RESUMED)
	}

	companion object {
		fun newInstance() = SettingsFragment()
	}
}
