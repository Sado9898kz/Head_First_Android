package com.hfad.bitsandpizzas.Kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.ShareActionProvider
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.hfad.bitsandpizzas.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.fragment.app.FragmentPagerAdapter as FragmentPagerAdapter1

class MainActivity : AppCompatActivity() {

    private lateinit var sharedActionProvider: ShareActionProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = toolbar as Toolbar
        setSupportActionBar(toolbar)

        //Связывание SectionsPagerAdapter c ViewPager
        val pagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        val pager = findViewById<ViewPager>(R.id.pager)
        pager.adapter = pagerAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Заполнение меню; элементы действий добавляются на панель приложения
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu!!.findItem(R.id.action_share)
        sharedActionProvider = MenuItemCompat.getActionProvider(menuItem) as ShareActionProvider
        setShareActionProvider("Хотите присоединиться ко мне для пиццы?")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_create_order -> {
                val intent = Intent(this, OrderActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setShareActionProvider(text: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, text)
        sharedActionProvider.setShareIntent(intent)
    }

    class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter1(fm) {
        override fun getCount(): Int {
            return 4
        }

        override fun getItem(position: Int): Fragment = when (position) {
            0 -> TopFragment()
            1 -> PizzaFragment()
            2 -> PastaFragment()
            3 -> StoresFragment()
            else -> Fragment()
        }
    }
}
