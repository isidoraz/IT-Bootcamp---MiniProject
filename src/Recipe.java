import java.util.ArrayList;
import java.util.List;

public class Recipe implements Priceable {
    private String recipeName;
    private RecipeDifficulty recipeDifficulty;
    private List<WeightedIngredient> weightedIngredients;

    public Recipe(String recipeName, RecipeDifficulty recipeDifficulty, List<WeightedIngredient> weightedIngredients) {
        this.recipeName = recipeName;
        this.recipeDifficulty = recipeDifficulty;
        this.weightedIngredients = weightedIngredients;
    }

    public Recipe(String recipeName, RecipeDifficulty recipeDifficulty) {
        this.recipeName = recipeName;
        this.recipeDifficulty = recipeDifficulty;
        this.weightedIngredients = new ArrayList<>();
    }

    public void addWeightedIngredient(WeightedIngredient newWeightedIngredient) {
        weightedIngredients.add(newWeightedIngredient);
    }

    public void removeWeightedIngredient(WeightedIngredient weightedIngredient) {
        weightedIngredients.remove(weightedIngredient);
    }

    public Recipe getScaledRecipe(double percentage) {
        Recipe newRecipe = new Recipe(recipeName, recipeDifficulty);
        for (WeightedIngredient weightedIngredient : weightedIngredients) {
            WeightedIngredient newWI = new WeightedIngredient();
            newWI.setNameOfIngredient(weightedIngredient.getNameOfIngredient());
            newWI.setPricePerUnit(weightedIngredient.getPricePerUnit());
            newWI.setWeight(weightedIngredient.getWeight() * (percentage / 100));
            newRecipe.addWeightedIngredient(newWI);
        }
        return newRecipe;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public RecipeDifficulty getRecipeDifficulty() {
        return recipeDifficulty;
    }

    public void setRecipeDifficulty(RecipeDifficulty recipeDifficulty) {
        this.recipeDifficulty = recipeDifficulty;
    }

    public List<WeightedIngredient> getWeightedIngredients() {
        return weightedIngredients;
    }

    public void setWeightedIngredients(List<WeightedIngredient> weightedIngredients) {
        this.weightedIngredients = weightedIngredients;
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (WeightedIngredient weightedIngredient : weightedIngredients) {
            totalPrice += weightedIngredient.getPrice();
        }
        return totalPrice;
    }
}
