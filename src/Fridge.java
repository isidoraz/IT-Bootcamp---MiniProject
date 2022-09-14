import java.util.HashMap;
import java.util.Map;

public class Fridge {
    private Map<WeightedIngredient, Integer> allWeightedIngredients = new HashMap<>();

    public void addWI(WeightedIngredient weightedIngredient) {
        if (allWeightedIngredients.containsKey(weightedIngredient)) {
            allWeightedIngredients.put(weightedIngredient, allWeightedIngredients.get(weightedIngredient) + 1);
        }
        else {
            allWeightedIngredients.put(weightedIngredient, 1);
        }
    }

    public void removeWI(WeightedIngredient weightedIngredient) {
        allWeightedIngredients.remove(weightedIngredient);
    }

    public boolean canMakeAMeal(Recipe recipe) {
        for (WeightedIngredient recipeWI : recipe.getWeightedIngredients()) {
            if (!allWeightedIngredients.containsKey(recipeWI)) {
                return false;
            }
        }
        return true;
    }

    public void makeMeal(Recipe recipe) {
        if (!canMakeAMeal(recipe)) {
            return;
        }
        for (WeightedIngredient recipeWI : recipe.getWeightedIngredients()) {
            if (allWeightedIngredients.get(recipeWI) == 1) {
                allWeightedIngredients.remove(recipeWI);
            }
            else {
                allWeightedIngredients.put(recipeWI, allWeightedIngredients.get(recipeWI) - 1);
            }
        }
    }

    public Map<WeightedIngredient, Integer> getAllWeightedIngredients() {
        return allWeightedIngredients;
    }

    public void setAllWeightedIngredients(Map<WeightedIngredient, Integer> allWeightedIngredients) {
        this.allWeightedIngredients = allWeightedIngredients;
    }
}
