package HangLevels


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.GameActivity
import com.example.myapplication.R

class LevelAdapter(private val levels: List<Level>) :
    RecyclerView.Adapter<LevelAdapter.LevelViewHolder>() {

    class LevelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val levelName: TextView = view.findViewById(R.id.levelName)
        val levelImage: ImageView = view.findViewById(R.id.levelImage)

        val levelWord : TextView = view.findViewById(R.id.levelWord)
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
        holder.levelWord.text = "Palabra :${item.word}"

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, GameActivity::class.java)
            intent.putExtra("PalabraAdivinar",item.word)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = levels.size
}
