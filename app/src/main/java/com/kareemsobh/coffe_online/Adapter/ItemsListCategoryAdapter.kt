import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kareemsobh.coffe_online.Activity.DetailActivity
import com.kareemsobh.coffe_online.Domain.ItemsModel
import com.kareemsobh.coffe_online.databinding.ViewholderItemListBinding
import kotlin.jvm.java


class ItemListCategoryAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<ItemListCategoryAdapter.Viewholder>() {

    lateinit var context: Context

    class Viewholder(val binding: ViewholderItemListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemListCategoryAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderItemListBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemListCategoryAdapter.Viewholder, position: Int) {
        holder.binding.titleTxt.text = items[position].title
        holder.binding.priceTxt.text = "$" + items[position].price.toString()
        holder.binding.subtitleTxt.text = items[position].extra.toString()

        Glide.with(context)
            .load(items[position].picUrl[0])
            .into(holder.binding.pic)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("object", items[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size

}