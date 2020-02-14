package com.hfad.myapplication.Kotlin

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.hfad.myapplication.R

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this,
                drawer,
                toolbar,
                R.string.nav_open_drawer,
                R.string.nav_close_drawer)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val fragment = InboxFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.content_frame, fragment)
        ft.commit()
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        val id = p0.itemId
        var fragment: Fragment? = null
        var intent: Intent? = null

        when (id) {
            R.id.nav_drafts -> fragment = DraftsFragment()
            R.id.nav_sent -> fragment = SentItemsFragment()
            R.id.nav_trash -> fragment = TrashFragment()
            R.id.nav_help -> intent = Intent(this, HelpActivity::class.java)
            R.id.nav_feedback -> intent = Intent(this, FeedbackActivity::class.java)
            else -> fragment = InboxFragment()
        }

        if (fragment != null) {
            val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.content_frame, fragment)
            ft.commit()
        } else {
            startActivity(intent)
        }

        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
