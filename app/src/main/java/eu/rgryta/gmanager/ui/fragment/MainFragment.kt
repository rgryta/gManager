package eu.rgryta.gmanager.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import eu.rgryta.gmanager.R
import eu.rgryta.gmanager.lib.core.CoreFragment

class MainFragment : CoreFragment(R.layout.fragment_main) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = layout.findViewById<Button>(R.id.button_frag1)
        btn.setOnClickListener {
            Toast.makeText(context, "Application toast!", Toast.LENGTH_LONG).show()

            val pkg = "eu.rgryta.gmanager.lib.files"
            val cn = pkg.plus(".MainActivity")
            startActivity(resolveActivityIntent(pkg, cn))
        }
    }
}