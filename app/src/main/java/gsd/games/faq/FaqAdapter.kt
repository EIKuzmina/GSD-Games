package gsd.games.faq

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import gsd.games.R

data class FaqItem(val titleRes: Int, val subtitleRes: Int, val fullTextRes: Int)

class FaqAdapter(
    private val items: List<FaqItem>,
    private val scrollView: ScrollView
) : RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {
    private var expandedPosition: Int? = null

    class FaqViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val faqItem: LinearLayout = view.findViewById(R.id.faq_item)
        val imgFaq: ImageView = view.findViewById(R.id.img_faq)
        val txtFaqTitle: TextView = view.findViewById(R.id.txt_faq)
        val txtFaqSubtitle: TextView = view.findViewById(R.id.txt_faq_2)
        val txtFaqFull: TextView = view.findViewById(R.id.txt_faq_full)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.faq_questions, parent, false)
        return FaqViewHolder(view)
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        val item = items[position]

        holder.txtFaqTitle.setText(item.titleRes)
        holder.txtFaqSubtitle.setText(item.subtitleRes)
        holder.txtFaqFull.setText(item.fullTextRes)

        val isExpanded = position == expandedPosition
        holder.txtFaqFull.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.imgFaq.setImageResource(if (isExpanded) R.drawable.close else R.drawable.plus)
        holder.faqItem.setBackgroundResource(if (isExpanded) R.drawable.faq_back else R.drawable.menu)

        holder.imgFaq.setOnClickListener {
            val previousExpanded = expandedPosition
            expandedPosition = if (isExpanded) null else position
            notifyItemChanged(previousExpanded ?: -1)
            notifyItemChanged(position)
            scrollView.post { scrollView.smoothScrollTo(0, holder.faqItem.top) }
        }
    }

    override fun getItemCount(): Int = items.size
}