package gsd.games.loading

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import gsd.games.R

class LoadingOneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_loading_one, container, false)

        with(view) {
            findViewById<TextView>(R.id.button1).setOnClickListener {
                findNavController()
                    .navigate(R.id.loadingTwoFragment)
            }
            findViewById<TextView>(R.id.skip1).setOnClickListener {
                findNavController()
                    .navigate(R.id.menuFragment)
            }
        }
        return view
    }
}