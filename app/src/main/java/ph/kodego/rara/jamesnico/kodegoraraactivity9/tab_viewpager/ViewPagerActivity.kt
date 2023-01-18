package ph.kodego.rara.jamesnico.kodegoraraactivity9.tab_viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceControl
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import ph.kodego.rara.jamesnico.kodegoraraactivity9.adapter.FragmentAdapter
import ph.kodego.rara.jamesnico.kodegoraraactivity9.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var fragmentAdapter = FragmentAdapter(supportFragmentManager, lifecycle)

        fragmentAdapter.addFragment(ListFragment())
        fragmentAdapter.addFragment(SearchFragment())
        fragmentAdapter.addFragment(TransactionFragment())

        with(binding.viewPager2){
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = fragmentAdapter
        }

        var tabs: ArrayList<String> = ArrayList()

        tabs.add("List")
        tabs.add("Search")
        tabs.add("Transaction")

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) {
                tab, position ->
            tab.text = tabs[position]
        }.attach()

    }

    override fun onBackPressed() {
        if(binding.viewPager2.currentItem == 0) {
            super.onBackPressed()
        }else{
            binding.viewPager2.currentItem = binding.viewPager2.currentItem - 1
        }
    }



}