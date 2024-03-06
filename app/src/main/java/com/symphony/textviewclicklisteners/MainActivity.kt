package com.symphony.textviewclicklisteners

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.good.gd.GDAndroid
import com.good.gd.GDStateListener

class MainActivity : AppCompatActivity(), GDStateListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GDAndroid.getInstance().activityInit(this)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text_view).configureClickListeners()
        findViewById<TextView>(R.id.gd_text_view).configureClickListeners()
        findViewById<TextView>(R.id.gd_app_compat_text_view).configureClickListeners()
    }

    private fun TextView.configureClickListeners() {
        isClickable = true
        setOnClickListener {
            Toast.makeText(context, R.string.on_click_called, Toast.LENGTH_SHORT)
                .show()
        }

        isLongClickable = true
        setOnLongClickListener {
            Toast.makeText(context, R.string.on_long_click_called, Toast.LENGTH_SHORT)
                .show()

            true
        }
    }

    override fun onLocked() {}

    override fun onWiped() {}

    override fun onUpdateConfig(p0: MutableMap<String, Any>?) {}

    override fun onUpdateServices() {}

    override fun onAuthorized() {}

    override fun onUpdateEntitlements() {}

    override fun onUpdatePolicy(p0: MutableMap<String, Any>?) {}
}