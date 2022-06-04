package eu.rgryta.gmanager.lib.core.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import dalvik.system.PathClassLoader
import eu.rgryta.gmanager.lib.core.CoreApp

abstract class CoreActivityAppCompat(layout: Int) : CoreActivityInterface, AppCompatActivity(layout) {
    lateinit var pathClassLoader: PathClassLoader

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    fun resolveClassLoader() {
        pathClassLoader = resolveClassLoader(application as CoreApp)
    }

    fun resolveActivityIntent(pkg: String, cn: String): Intent {
        return resolveActivityIntent(app = application as CoreApp, pkg, cn)
    }

}