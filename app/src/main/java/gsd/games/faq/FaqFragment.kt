package gsd.games.faq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import android.widget.ScrollView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import gsd.games.R
import gsd.games.menu.BottomNavHelper

class FaqFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_faq, container, false)
        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navController = findNavController()
        val scrollView = view.findViewById<ScrollView>(R.id.scrollView) // Оставляем
        BottomNavHelper.setupBottomNavigation(this, bottomNav, navController)
        val recyclerView = view.findViewById<RecyclerView>(R.id.faqRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val faqItems = listOf(
            FaqItem(R.string.txt_faq01, R.string.txt_faq01_2, R.string.txt_faq01_full),
            FaqItem(R.string.txt_faq02, R.string.txt_faq02_2, R.string.txt_faq02_full),
            FaqItem(R.string.txt_faq03, R.string.txt_faq03_2, R.string.txt_faq03_full),
            FaqItem(R.string.txt_faq04, R.string.txt_faq04_2, R.string.txt_faq04_full)
        )

        recyclerView.adapter = FaqAdapter(faqItems, scrollView)

        return view
    }
}