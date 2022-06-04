package eu.rgryta.gmanager.lib.core.activity

import android.content.Context
import android.content.Intent
import dalvik.system.PathClassLoader
import eu.rgryta.gmanager.lib.core.CoreApp

interface CoreActivityInterface {

    fun resolveClassLoader(app: CoreApp): PathClassLoader {
        return app.pathClassLoader
    }

    fun resolveActivityIntent(app : CoreApp, pkg: String, cn: String): Intent {
        return app.resolveActivityIntent(pkg, cn)
    }

    fun resolveContext(app : CoreApp): Context? {
        return app.getContext()
    }
}