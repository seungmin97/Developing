package com.seungmin.android.android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when(v){
            home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            menu_1 -> {
                clearSelected()
                menu_1.isSelected = true
                replaceFragment(Menu_1())
            }
            menu_2 -> {
                clearSelected()
                menu_1.isSelected = true
                replaceFragment(Menu_2())
            }
            menu_3 -> {
                clearSelected()
                menu_1.isSelected = true
                replaceFragment(Menu_3())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(Menu_1())
        menu_1.isSelected = true
        menu_1.setOnClickListener(this)
        menu_2.setOnClickListener(this)
        menu_3.setOnClickListener(this)
        home.setOnClickListener(this)
    }

    fun addFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_frame, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment : Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun clearSelected(){
        menu_1.isSelected = false
        menu_2.isSelected = false
        menu_3.isSelected = false
        home.isSelected = false
    }

}
