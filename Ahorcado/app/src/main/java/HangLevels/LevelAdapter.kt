package HangLevels


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class LevelAdapter(private val levels: List<Level>) :
    RecyclerView.Adapter<LevelAdapter.LevelViewHolder>() {

    class LevelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val levelName: TextView = view.findViewById(R.id.levelName)
        val levelImage: ImageView = view.findViewById(R.id.levelImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_level, parent, false)
        return LevelViewHolder(view)
    }

    override fun onBindViewHolder(holder: LevelViewHolder, position: Int) {
        val item = levels[position]
        holder.levelName.text = item.name
        holder.levelImage.setImageResource(item.image)
    }

    override fun getItemCount() = levels.size
}
