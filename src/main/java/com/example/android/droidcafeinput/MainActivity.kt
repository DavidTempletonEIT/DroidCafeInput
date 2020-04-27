package com.example.android.droidcafeinput

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    companion object {
        val EXTRA_MESSAGE = "com.example.android.droidcafeinput.extra.MESSAGE"
    }

    lateinit var mOrderMessage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra(EXTRA_MESSAGE, mOrderMessage)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_order) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun showDonutOrder() {
        mOrderMessage = "You ordered a donut."
        displayToast(mOrderMessage)
    }

    fun showIceCreamOrder() {
        mOrderMessage = "You ordered an ice cream sandwich."
        displayToast(mOrderMessage)
    }

    fun showFroyoOrder() {
        mOrderMessage = "You ordered a FroYo."
        displayToast(mOrderMessage)
    }


}
