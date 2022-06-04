package eu.rgryta.gmanager.lib.core.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.CallSuper
import androidx.fragment.app.FragmentActivity
import dalvik.system.PathClassLoader
import eu.rgryta.gmanager.lib.core.CoreApp
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

abstract class CoreActivityFragment(layout: Int) : CoreActivityInterface, FragmentActivity(layout) {
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

    fun <T : Any> construct(kClass: KClass<T>): T? {
        val constructor = kClass.primaryConstructor
        return if (constructor != null && constructor.parameters.isEmpty())
            constructor.call() else
            null
    }
}