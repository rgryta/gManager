package eu.rgryta.gmanager.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import eu.rgryta.gmanager.R
import eu.rgryta.gmanager.lib.core.CoreFragment

class BrowseFragment : CoreFragment(R.layout.fragment_browse) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn = layout.findViewById<Button>(R.id.button_frag1)
        btn.setOnClickListener {
            Toast.makeText(context,"Application toast second frag!",Toast.LENGTH_LONG).show()
        }
    }

}