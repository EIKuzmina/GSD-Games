package gsd.games.games

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import gsd.games.BuildConfig
import gsd.games.R

data class Games(
    val id: Int,
    val title: String,
    val description: String,
    val rules: String,
    val image: String,
    val min_people: Int,
    val max_people: Int,
    val is_active: Boolean
)

class GamesAdapter(private var items: MutableList<Games>)
    : RecyclerView.Adapter<GamesAdapter.GameViewHolder>() {

    class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val menuImage: ImageView = view.findViewById(R.id.img_menu)
        val titleView: TextView = view.findViewById(R.id.txt_menu_title)
        val menu: TextView = view.findViewById(R.id.txt_menu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_games, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val item = items[position]
        val imageUrl = "${BuildConfig.BASE_URL}/media/${item.image}"

        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.logo) // Заглушка, пока загружается картинка
            .error(R.drawable.error) // Картинка ошибки, если загрузка не удалась
            .into(holder.menuImage)

        holder.titleView.text = item.title
        holder.menu.text = item.description
    }

    override fun getItemCount() = items.size

    fun updateGames(newItems: List<Games>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}