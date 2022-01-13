package ru.bersenev_kirill.need_for_wheels.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.bersenev_kirill.need_for_wheels.R
import ru.bersenev_kirill.need_for_wheels.model.Tire

typealias OnTireClickListener = (Tire) -> Unit

class TireAdapter(
    private val tires : List<Tire>,
    private val listener : OnTireClickListener
): RecyclerView.Adapter<TireAdapter.TireVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TireVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TireVH(
            layoutInflater.inflate(R.layout.item_tire,parent,false),
            listener
        )
    }

    override fun onBindViewHolder(holder: TireVH, position: Int) = holder.bind(tires[position])

    override fun getItemCount(): Int = tires.size

    class TireVH(
        view : View,
        listener : OnTireClickListener
    ) : RecyclerView.ViewHolder(view) {

        private val ivAvatar = view.findViewById<ImageView>(R.id.ivAvatar)
        private val tvName = view.findViewById<TextView>(R.id.tvName)
        private val tvDescription = view.findViewById<TextView>(R.id.tvDescription)


        private lateinit var tire : Tire

        init {
            view.setOnClickListener { listener(tire)}
        }


        @SuppressLint("SetTextI18n")
        fun bind (tire : Tire){
            this.tire = tire
            tvName.text = tire.manufacturer.toString() + tire.name
            tvDescription.text = tire.price.toString()
            ivAvatar.setImageResource(tire.coverResId)
            Glide
                .with(itemView)
                .load(tire.coverResId)
                .centerCrop()
                .placeholder(R.drawable.ic_splash)
                .into(ivAvatar)
        }

    }
}