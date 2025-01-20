package com.example.firstassignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private val _recipes = MutableStateFlow<List<RecipeData>>(emptyList())
    val recipes: StateFlow<List<RecipeData>> = _recipes.asStateFlow()

    private val allRecipes = listOf(
        RecipeData(1, R.drawable.recipe_1, "Recipe 1", "Begin by combining the contents of the \"OCTO SAUCE\" jar with the \"SPICE\" jar, and add this amalgamation to the \"STEEP PODE\" pot. Position the octopus-like creature on a wooden board, ignite the candles affixed to its head, and meticulously incorporate the prepared mixture into the pot. Stir the concoction with precision to ensure the integration of flavors. Finally, present the dish with a slice of pizza."),
        RecipeData(2, R.drawable.recipe_2, "Recipe 2", "To create the delightful \"Fluffy Food,\" start by preparing the main ingredients, including fluffy food items such as small white marshmallows and colorful decorations. Mix these thoroughly until they form a cohesive blend. Shape the mixture into small, round, fluffy balls and place them in blue cupcake liners. Arrange the fluffy balls on a plate or in two blue bowls for a visually appealing presentation. Optionally, add a block of cheese with holes for contrasting texture and flavor.")
    )

    init {
        _recipes.value = allRecipes
    }

    fun searchRecipes(query: String) {
        viewModelScope.launch {
            if (query.isEmpty() || query.length < 3) {
                _recipes.value = allRecipes
            } else {
                _recipes.value = allRecipes.filter { it.title.contains(query, ignoreCase = true) || it.description.contains(query, ignoreCase = true) }
            }
            println("Updated recipes: ${_recipes.value}")
        }
    }
}
