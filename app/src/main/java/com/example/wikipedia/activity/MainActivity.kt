package com.example.wikipedia.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.wikipedia.R
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.FragmentExplore
import com.example.wikipedia.fragments.FragmentPhotographer
import com.example.wikipedia.fragments.FragmentTrend
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarMain)
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.toolBarMain,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationViewMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_writer -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    val dialog = SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                    dialog.titleText = "alert"
                    dialog.confirmText = "confirm"
                    dialog.cancelText = "Cancel"
                    dialog.contentText = "Wanna be a Writer?"
                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                        Toast.makeText(this, "you can be a writer, let's go :D", Toast.LENGTH_SHORT)
                            .show()
                    }

                    dialog.setCancelClickListener {
                        dialog.dismiss()
                    }
                    dialog.show()

                }
                R.id.menu_photographer -> {
                    //load fragment ->
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frameMainContainer, FragmentPhotographer())
                    transaction.addToBackStack(null)
                    transaction.commit()
                    //check item->
                    binding.navigationViewMain.menu.getItem(1).isChecked = true
                    //close drawer->
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                }
                R.id.menu_videoMaker -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)

//                    Toast.makeText(this, "you can create video!", Toast.LENGTH_SHORT).show()
                    Snackbar
                        .make(binding.root, "No Internet!", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Retry") {
                            Toast.makeText(this, "Checking Internet!", Toast.LENGTH_SHORT).show()
                        }
                        .setActionTextColor(
                            ContextCompat.getColor(
                                this,
                                cn.pedant.SweetAlert.R.color.blue_btn_bg_color
                            )
                        )
                        .show()
                }
                R.id.menu_translator -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    //open an activity->
                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)
                }
                R.id.menu_profile->{
                    val intent = Intent(this,MainActivity4::class.java)
                    startActivity(intent)
                }
                //-----------------------
                R.id.menu_open_wikipedia -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)

                    openWebsite("https://www.wikipedia.org/")
                }
                R.id.menu_openWikimedia -> {
                    binding.drawerLayout.closeDrawer(GravityCompat.START)

                    openWebsite("https://www.wikimedia.org/")
                }
            }
            true
        }
        firstRun()

        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_bottom_explore -> {
                    replaceFragment(FragmentExplore())
                }
                R.id.menu_bottom_trend -> {
                    replaceFragment(FragmentTrend())
                }

            }
            true
        }
        binding.bottomNavigationMain.setOnItemReselectedListener {}
    }

    private fun openWebsite(uri: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)

    }

    fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameMainContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        //check item off ->
        binding.navigationViewMain.menu.getItem(1).isChecked = false
    }

    fun firstRun() {
        replaceFragment(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_bottom_explore
    }

    override fun onBackPressed() {
        super.onBackPressed()
        //check item off->
        binding.navigationViewMain.menu.getItem(1).isChecked = false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_profile ->{
                Toast.makeText(this, "profile clicked", Toast.LENGTH_SHORT).show()

            }
        }



        return true

    }
}