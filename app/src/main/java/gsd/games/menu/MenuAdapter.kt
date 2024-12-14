package gsd.games.menu

import android.view.*
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import gsd.games.R

data class MenuItem(val imageMenu: Int, val menuTitle: String, val menu: String)

class MenuAdapter(private val items: List<MenuItem>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val menuTitle: ImageView = view.findViewById(R.id.img_menu)
        val titleView: TextView = view.findViewById(R.id.txt_menu_title)
        val menu: TextView = view.findViewById(R.id.txt_menu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_games, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = items[position]
        holder.menuTitle.setImageResource(item.imageMenu)
        holder.titleView.text = item.menuTitle
        holder.menu.text = item.menu
    }

    override fun getItemCount() = items.size
}
