package eu.rgryta.gmanager.lib.realmdb.ui.activity

import android.os.Bundle
import eu.rgryta.gmanager.lib.core.activity.CoreActivityAppCompat
import eu.rgryta.gmanager.lib.realmdb.databinding.ActivityMainBinding
import eu.rgryta.gmanager.lib.realmdb.R

class MainActivity : CoreActivityAppCompat(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}