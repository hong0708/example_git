package com.thinlineit.ctrlf.page

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.thinlineit.ctrlf.R
import com.thinlineit.ctrlf.databinding.FragmentPageBinding
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment : Fragment() {

    private var mDrawerToggle : ActionBarDrawerToggle? = null

    private lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var contextadapter : ListAdapter

    var contentlist = arrayListOf<PageDao>(
        PageDao(1,"asd1",1,"ddd"),
        PageDao(1,"asd2",1,"ddd"),
        PageDao(1,"asd3",1,"ddd"),
        PageDao(1,"asd4",1,"ddd")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPageBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_page, container, false
        )
        val noteId = PageFragmentArgs.fromBundle(requireArguments()).noteId
        val viewModelFactory = PageViewModelFactory(noteId)
        val pageViewModel = ViewModelProvider(this, viewModelFactory).get(PageViewModel::class.java)
        binding.pageViewModel = pageViewModel
        binding.lifecycleOwner = this

        setHasOptionsMenu(true)

        contextadapter = ListAdapter()
        binding.PageListRecyclerView.adapter = contextadapter
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.toolbar, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // navigate to settings screen
                //nv_main_navigation_root.setNavigationItemSelectedListener(this) //navigation ?????????
                dl_main_drawer_root.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}