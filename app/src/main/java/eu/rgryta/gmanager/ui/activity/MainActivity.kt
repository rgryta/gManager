package eu.rgryta.gmanager.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import eu.rgryta.gmanager.R
import eu.rgryta.gmanager.databinding.ActivityMainBinding
import eu.rgryta.gmanager.lib.core.activity.CoreActivityFragment

class MainActivity : CoreActivityFragment(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    private val pkg = getString(eu.rgryta.gmanager.lib.core.R.string.main_package)
    private val cn = pkg.plus(getString(eu.rgryta.gmanager.lib.core.R.string.activity_main_path))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        resolveClassLoader()

        openFrag(cn)

        binding.frag1.setOnClickListener {
            overwriteFrag(cn)
        }
        binding.frag2.setOnClickListener {
            val cn = pkg.plus(".ui.fragment.SecondFrag")
            overwriteFrag(cn)
        }
        binding.frag3.setOnClickListener {
            val pkg = getString(eu.rgryta.gmanager.lib.core.R.string.lib_prefix).plus(".files")
            val cn = pkg.plus(getString(eu.rgryta.gmanager.lib.core.R.string.activity_main_path))
            openFrag(cn)
        }
    }

    private fun openFrag(cn: String) {
        val clazz = Class.forName(cn, true, pathClassLoader).kotlin

        addFragment(construct(clazz)!! as Fragment)
    }

    private fun overwriteFrag(cn: String) {
        val clazz = Class.forName(cn, true, pathClassLoader).kotlin

        replaceFragment(construct(clazz)!! as Fragment)
    }

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment).commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment).commit()
    }

}