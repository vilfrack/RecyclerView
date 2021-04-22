package com.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_superhero.view.*


class HeroAdapter(val superhero: List<SuperHero>):RecyclerView.Adapter<HeroAdapter.HeroHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(superhero[position])
    }

    override fun getItemCount(): Int =superhero.size

    class HeroHolder(val view: View): RecyclerView.ViewHolder(view){

        fun render(superhero:SuperHero){
            view.tvRealName.text = superhero.realName
            view.tvSuperHeroName.text = superhero.superHeroName
            view.tvPublisher.text = superhero.publisher
            Picasso.get().load(superhero.Image).into(view.ivHero)

            view.setOnClickListener {
                Toast.makeText(view.context,"Has seleccionado ha ${superhero.superHeroName}", Toast.LENGTH_LONG).show()
            }
        }
    }
}