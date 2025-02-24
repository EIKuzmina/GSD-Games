package gsd.games.games

import android.os.Bundle
import androidx.fragment.app.*
import android.view.*
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import gsd.games.R
import gsd.games.activity.BottomNavHelper
import gsd.games.viewmodel.GamesViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private val viewModel: GamesViewModel by viewModels()
    private lateinit var adapter: GamesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController()
        BottomNavHelper.setupBottomNavigation(this, bottomNav, navController)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.menuGames)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = GamesAdapter(mutableListOf())
        recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.games.collect { games ->
                adapter.updateGames(games)
            }
        }
    }
}
