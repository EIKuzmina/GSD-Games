package gsd.games.faq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.navigation.fragment.findNavController
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
        BottomNavHelper.setupBottomNavigation(this, bottomNav, navController)

        listOf(
            Triple(R.id.faq_item_1, R.id.img_faq1, R.id.txt_faq01_full),
            Triple(R.id.faq_item_2, R.id.img_faq2, R.id.txt_faq02_full),
            Triple(R.id.faq_item_3, R.id.img_faq3, R.id.txt_faq03_full),
            Triple(R.id.faq_item_4, R.id.img_faq4, R.id.txt_faq04_full)
        ).forEach { (faqItemId, imgFaqId, txtFaqId) ->
            FaqMenu(
                faqItem = view.findViewById(faqItemId),
                imgFaq = view.findViewById(imgFaqId),
                txtFaqFull = view.findViewById(txtFaqId)
            )
        }
        return view
    }
}