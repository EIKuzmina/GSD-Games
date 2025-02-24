package gsd.games.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import gsd.games.R
import gsd.games.activity.BottomNavHelper

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController()
        BottomNavHelper.setupBottomNavigation(this, bottomNav, navController)

        return view
    }
}
