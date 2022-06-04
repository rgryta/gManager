package eu.rgryta.gmanager.lib.core

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import dalvik.system.PathClassLoader
import java.io.File
import java.net.URL

abstract class CoreApp : Application() {

    private lateinit var mContext: Context

    lateinit var pathClassLoader: PathClassLoader

    override fun onCreate() {
        super.onCreate()
        mContext = this
        pathClassLoader = initializeClassLoader()
    }

    open fun getContext(): Context? {
        return mContext
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun initializeClassLoader(): PathClassLoader {
        val pack: List<PackageInfo> =
            packageManager.getInstalledPackages(PackageManager.GET_META_DATA)
                .filter { packageInfo ->
                    packageInfo.packageName.startsWith(
                        applicationContext.packageName
                    )
                }
        val urls = pack.map { pkg -> getPluginURL(pkg.packageName) }.toTypedArray()
        return PathClassLoader(urls.joinToString(separator = File.pathSeparator), classLoader)
    }

    private fun getPluginURL(plugName: String): URL {
        val apk = packageManager.getApplicationInfo(plugName, 0)
        val apkName = apk.sourceDir

        val url: URL = ClassLoader.getSystemClassLoader().getResource(apkName)
        val file = File(url.toURI())

        return file.toURI().toURL()!!
    }

    fun resolveActivityIntent(pkg : String, cn : String): Intent {
        val clazz = Class.forName(cn, true, pathClassLoader)

        val fActivity = Intent(applicationContext, clazz)
        fActivity.setClassName(pkg, cn)
        return fActivity
    }
}