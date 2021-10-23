package com.example.taskproject

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.taskproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    lateinit var  toggle: ActionBarDrawerToggle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        toggle = ActionBarDrawerToggle(requireActivity(), binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        (activity as MainActivity).supportActionBar?.apply {
            show()
            setDisplayHomeAsUpEnabled(true)
            setTitle(R.string.home_fragment)
        }
        getSelectedItem()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }
    
    private fun getSelectedItem() {
        binding.homeNavigationDrawer.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item_import -> showToast("Import")
                R.id.item_gallery -> showToast("Gallery")
                R.id.item_slide -> showToast("SlideShow")
                R.id.item_tools -> showToast("Tools")
                R.id.item_share -> showToast("Share")
                R.id.item_send -> showToast("Send")
            }
            true
        }
    }

    private fun showToast(name: String) = Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
}