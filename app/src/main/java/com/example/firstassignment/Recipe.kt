package com.example.firstassignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Recipe : Fragment() {

    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recipeList: List<RecipeData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.item_recipe, container, false)

        recipeRecyclerView = view.findViewById(R.id.recipe_recycler_view)
        recipeRecyclerView.layoutManager = LinearLayoutManager(context)

        recipeList = listOf(
            RecipeData(1, R.drawable.recipe_1, "Recipe 1", "Begin by combining the contents of the \"OCTO SAUCE\" jar with the \"SPICE\" jar, and add this amalgamation to the \"STEEP PODE\" pot. Position the octopus-like creature on a wooden board, ignite the candles affixed to its head, and meticulously incorporate the prepared mixture into the pot. Stir the concoction with precision to ensure the integration of flavors. Finally, present the dish with a slice of pizza."),
            RecipeData(2, R.drawable.recipe_2, "Recipe 2", "To create the delightful \"Fluffy Food,\" start by preparing the main ingredients, including fluffy food items such as small white marshmallows and colorful decorations. Mix these thoroughly until they form a cohesive blend. Shape the mixture into small, round, fluffy balls and place them in blue cupcake liners. Arrange the fluffy balls on a plate or in two blue bowls for a visually appealing presentation. Optionally, add a block of cheese with holes for contrasting texture and flavor.")
        )

        recipeAdapter = RecipeAdapter(recipeList)
        recipeRecyclerView.adapter = recipeAdapter

        return view
    }
}
