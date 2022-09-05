package com.polyglotte.features.allfeatures.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.polyglotte.R
import com.polyglotte.app.NavigationActivity
import com.polyglotte.app.data.AppFeatureName
import com.polyglotte.app.data.AppFeaturesRepository
import com.polyglotte.databinding.FragmentAllFeaturesBinding
import com.polyglotte.features.allfeatures.FeaturesListAdapter

class AllFeaturesFragment : Fragment() {

    private lateinit var viewModel: AllFeaturesViewModel

    private var _binding: FragmentAllFeaturesBinding? = null
    private val binding get() = _binding!!
    // This property is only valid between onCreateView and onDestroyView.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllFeaturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AllFeaturesViewModel::class.java)
        setupObservers()
        setupAllFeaturesToolbarMenu()
        setupRecyclerView()
        //TODO
        //or maybe in other commit?
        //get from prefs
        //setOnClickListeners (recycler view)
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

    private fun setupAllFeaturesToolbarMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menu.clear()
                val menuItem =
                    AppFeaturesRepository.getFeaturesListItemByKey(AppFeatureName.SETTINGS)
                menuItem?.run {
                    menu.add(Menu.NONE, menuItem.destinationId, index, menuItem.labelId)
                        .setIcon(menuItem.imageId)
                        .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
                }
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                if (menuItem.itemId == R.id.navigation_settings)
                    findNavController().navigate(R.id.navigation_settings)
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setupRecyclerView() {
        val prefs: SharedPreferences? = activity?.getSharedPreferences(
            NavigationActivity.PREFERENCES_NAVIGATION,
            Context.MODE_PRIVATE
        )
        val dataset = prefs?.run { viewModel.getItemsList(this) }
        binding.list.run {
            adapter = dataset?.let { FeaturesListAdapter(it as MutableMap<Int, AppFeatureName>) }
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                DividerItemDecoration(context, RecyclerView.VERTICAL)
            )
        }

    }

    companion object {
        fun newInstance() = AllFeaturesFragment()
    }
}
