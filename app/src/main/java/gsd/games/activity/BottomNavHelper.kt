package gsd.games.activity

import gsd.games.R
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.NavController

object BottomNavHelper {
    fun setupBottomNavigation(
        fragment: Fragment,
        bottomNav: BottomNavigationView,
        navController: NavController
    ) {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.faqFragment -> {
                    navController.navigate(R.id.faqFragment)
                    true
                }
                R.id.menuFragment -> {
                    navController.navigate(R.id.menuFragment)
                    true
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment)
                    true
                }
                else -> false
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.faqFragment -> bottomNav.menu.findItem(R.id.faqFragment).isChecked = true
                R.id.menuFragment -> bottomNav.menu.findItem(R.id.menuFragment).isChecked = true
                R.id.profileFragment -> bottomNav.menu.findItem(R.id.profileFragment).isChecked = true
            }
        }
    }
}
