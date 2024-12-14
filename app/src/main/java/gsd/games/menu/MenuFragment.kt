package gsd.games.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import gsd.games.R

class MenuFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController()
        BottomNavHelper.setupBottomNavigation(this, bottomNav, navController)

        val recyclerView = view.findViewById<RecyclerView>(R.id.menuGames)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val menuItems = listOf(
            MenuItem(R.drawable.mafia, getString(R.string.txt_menu_1), getString(R.string.txt_menu_1_2)),
            MenuItem(R.drawable.munchkin, getString(R.string.txt_menu_2), getString(R.string.txt_menu_2_2)),
            MenuItem(R.drawable.bunker, getString(R.string.txt_menu_3), getString(R.string.txt_menu_3_2)),
            MenuItem(R.drawable.monopoly, getString(R.string.txt_menu_4), getString(R.string.txt_menu_4_2))
        )
        recyclerView.adapter = MenuAdapter(menuItems)

        return view
    }
}