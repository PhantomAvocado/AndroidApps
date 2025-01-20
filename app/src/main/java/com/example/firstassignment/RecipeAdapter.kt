package com.example.firstassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private var recipeList: List<RecipeData>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = recipeList.size

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recipeImage: ImageView = itemView.findViewById(R.id.recipe_image)
        private val recipeTitle: TextView = itemView.findViewById(R.id.recipe_title)
        private val recipeDescription: TextView = itemView.findViewById(R.id.recipe_description)
        private val likeButton: Button = itemView.findViewById(R.id.like_button)
        private val shareButton: Button = itemView.findViewById(R.id.share_button)

        fun bind(recipe: RecipeData) {
            recipeImage.setImageResource(recipe.image)
            recipeTitle.text = recipe.title
            recipeDescription.text = recipe.description

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "Clicked item ID: ${recipe.id}", Toast.LENGTH_SHORT).show()
            }

            likeButton.setOnClickListener {
                Toast.makeText(itemView.context, "Liked item ID: ${recipe.id}", Toast.LENGTH_SHORT).show()
            }

            shareButton.setOnClickListener {
                Toast.makeText(itemView.context, "Shared item ID: ${recipe.id}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun updateRecipes(newRecipes: List<RecipeData>) {
        recipeList = newRecipes
        notifyDataSetChanged()
    }
}
