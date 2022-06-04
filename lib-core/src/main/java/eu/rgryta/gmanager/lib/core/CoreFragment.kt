package eu.rgryta.gmanager.lib.core


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import dalvik.system.PathClassLoader

abstract class CoreFragment(layout: Int) : Fragment(layout) {
    lateinit var layout: View

    lateinit var pathClassLoader: PathClassLoader

    private val mContentLayoutId = layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pathClassLoader = (requireActivity().application as CoreApp).pathClassLoader
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val clazzName = this::class.java.kotlin.qualifiedName.toString()

        val pkgName = if (clazzName.startsWith("eu.rgryta.gmanager.lib")) {
            clazzName.split(".").take(5).joinToString(separator = ".")
        } else {
            "eu.rgryta.gmanager"
        }

        val res =
            resolveContext()?.packageManager?.getResourcesForApplication(pkgName)!!

        val resourceId = res.getIdentifier(
            res.getResourceEntryName(mContentLayoutId),
            "layout",
            pkgName
        )

        val resource = res.getLayout(resourceId)
        layout = LayoutInflater.from(resolveContext())
            .inflate(resource, container, false)!! as ConstraintLayout
        return layout
    }

    fun resolveActivityIntent(pkg: String, cn: String): Intent {
        return (requireActivity().application as CoreApp).resolveActivityIntent(pkg, cn)
    }

    fun resolveContext(): Context? {
        return (requireActivity().application as CoreApp).getContext()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layout.visibility = View.VISIBLE
    }

    override fun onStop() {
        super.onStop()
        layout.visibility = View.GONE
    }
}