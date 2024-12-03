package gsd.games.loading

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import gsd.games.R

class LoadingTwoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_loading_two, container, false)

        with(view) {
            findViewById<TextView>(R.id.button2).setOnClickListener {
                findNavController()
                    .navigate(R.id.menuFragment)
            }
            findViewById<TextView>(R.id.skip2).setOnClickListener {
                findNavController()
                    .navigate(R.id.menuFragment)
            }
        }
      return view
    }
}