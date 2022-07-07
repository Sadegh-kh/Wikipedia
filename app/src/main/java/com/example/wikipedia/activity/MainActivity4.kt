package com.example.wikipedia.activity


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import com.example.wikipedia.R
import com.example.wikipedia.databinding.ActivityMain4Binding


class MainActivity4 : AppCompatActivity() {
    lateinit var binding:ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarProfile)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)




//        val text : Int=binding.collapsProfile.titleCollapseMode
//        if (text==0){
//            binding.imgProfile.setImageDrawable(null)
//        }else{
//            binding.imgProfile.setImageResource(R.drawable.img_profile)
//        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_profile,menu)
        return true
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
                android.R.id.home->{
                    onBackPressed()
                }
            R.id.menu_editName->{
                Toast.makeText(this, "edit name", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_addNewPhoto->{

            }
            R.id.menu_logOut->{

            }
        }
        return true
    }
}