package eu.rgryta.gmanager.ui.activity

import android.os.Bundle
import eu.rgryta.gmanager.R
import eu.rgryta.gmanager.databinding.ActivityInitBinding
import eu.rgryta.gmanager.lib.core.activity.CoreActivityAppCompat


class InitActivity : CoreActivityAppCompat(R.layout.activity_init) {
    private lateinit var binding: ActivityInitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        resolveClassLoader()
    }

    override fun onResume() {
        super.onResume()

        //TODO Check if it's the first time
        try {
            val pkg = getString(eu.rgryta.gmanager.lib.core.R.string.main_package)
            val cn = pkg.plus(".ui.activity.MainActivity")

            startActivity(resolveActivityIntent(pkg, cn))

        } catch (exception: Exception) {
            exception.printStackTrace()
        }
    }
}