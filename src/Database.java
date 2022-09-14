import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<WeightedIngredient> allWeightedIngredients = new ArrayList<>();
    public static List<Recipe> allRecipes = new ArrayList<>();
    public static Fridge fridge = new Fridge();

    public static List<Recipe> favourites = new ArrayList<>();


    static {
        WeightedIngredient wi1 = new WeightedIngredient("potato", 1, 40.2);
        WeightedIngredient wi2 = new WeightedIngredient("eggs", 1, 25);
        WeightedIngredient wi3 = new WeightedIngredient("flour", 0.5, 63);
        WeightedIngredient wi4 = new WeightedIngredient("milk", 1, 125.99);
        WeightedIngredient wi5 = new WeightedIngredient("cheese", 1, 250.5);
        WeightedIngredient wi6 = new WeightedIngredient("nutella", 1, 500.89);
        WeightedIngredient wi7 = new WeightedIngredient("sour cream", 1, 83);
        WeightedIngredient wi8 = new WeightedIngredient("strawberries", 1, 350);
        WeightedIngredient wi9 = new WeightedIngredient("cream", 0.1, 35.7);
        WeightedIngredient wi10 = new WeightedIngredient("oil", 1, 50);
        WeightedIngredient wi11 = new WeightedIngredient("onion", 0.5, 55);
        WeightedIngredient wi12 = new WeightedIngredient("ham", 100, 320);
        WeightedIngredient wi13 = new WeightedIngredient("bacon", 100, 350);
        WeightedIngredient wi14 = new WeightedIngredient("chicken breast", 1, 260.9);
        WeightedIngredient wi15 = new WeightedIngredient("pizza dough", 1, 198.9);
        WeightedIngredient wi16 = new WeightedIngredient("tomato", 1, 150.5);
        WeightedIngredient wi17 = new WeightedIngredient("olives", 0.5, 80.5);

        allWeightedIngredients.add(wi1);
        allWeightedIngredients.add(wi2);
        allWeightedIngredients.add(wi3);
        allWeightedIngredients.add(wi4);
        allWeightedIngredients.add(wi5);
        allWeightedIngredients.add(wi6);
        allWeightedIngredients.add(wi7);
        allWeightedIngredients.add(wi8);
        allWeightedIngredients.add(wi9);
        allWeightedIngredients.add(wi10);
        allWeightedIngredients.add(wi11);
        allWeightedIngredients.add(wi12);
        allWeightedIngredients.add(wi13);
        allWeightedIngredients.add(wi14);
        allWeightedIngredients.add(wi15);
        allWeightedIngredients.add(wi16);
        allWeightedIngredients.add(wi17);

        Recipe recipe1 = new Recipe("Pancakes - empty", RecipeDifficulty.EASY);
        recipe1.addWeightedIngredient(wi2);
        recipe1.addWeightedIngredient(wi3);
        recipe1.addWeightedIngredient(wi4);

        Recipe recipe2 = new Recipe("Sweet Pancakes", RecipeDifficulty.EASY);
        recipe2.addWeightedIngredient(wi2);
        recipe2.addWeightedIngredient(wi3);
        recipe2.addWeightedIngredient(wi4);
        recipe2.addWeightedIngredient(wi6);

        Recipe recipe3 = new Recipe("Salty Pancakes", RecipeDifficulty.EASY);
        recipe3.addWeightedIngredient(wi2);
        recipe3.addWeightedIngredient(wi3);
        recipe3.addWeightedIngredient(wi4);
        recipe3.addWeightedIngredient(wi7);


        Recipe recipe4 = new Recipe("Strawberry with Cream", RecipeDifficulty.BEGINNER);
        recipe4.addWeightedIngredient(wi8);
        recipe4.addWeightedIngredient(wi9);

        Recipe recipe5 = new Recipe("Greek Salad", RecipeDifficulty.MEDIUM);
        recipe5.addWeightedIngredient(wi5);
        recipe5.addWeightedIngredient(wi16);
        recipe5.addWeightedIngredient(wi17);

        Recipe recipe6 = new Recipe("Eggs with Bacon", RecipeDifficulty.EASY);
        recipe6.addWeightedIngredient(wi2);
        recipe6.addWeightedIngredient(wi10);
        recipe6.addWeightedIngredient(wi13);

        Recipe recipe7 = new Recipe("Muffins", RecipeDifficulty.HARD);
        recipe7.addWeightedIngredient(wi2);
        recipe7.addWeightedIngredient(wi3);
        recipe7.addWeightedIngredient(wi4);
        recipe7.addWeightedIngredient(wi5);
        recipe7.addWeightedIngredient(wi12);

        Recipe recipe8 = new Recipe("Pizza", RecipeDifficulty.HARD);
        recipe8.addWeightedIngredient(wi5);
        recipe8.addWeightedIngredient(wi12);
        recipe8.addWeightedIngredient(wi15);
        recipe8.addWeightedIngredient(wi16);
        recipe8.addWeightedIngredient(wi17);

        Recipe recipe9 = new Recipe("Lunch", RecipeDifficulty.PRO);
        recipe9.addWeightedIngredient(wi1);
        recipe9.addWeightedIngredient(wi10);
        recipe9.addWeightedIngredient(wi11);
        recipe9.addWeightedIngredient(wi14);

        Recipe recipe10 = new Recipe("Breakfast", RecipeDifficulty.HARD);
        recipe10.addWeightedIngredient(wi2);
        recipe10.addWeightedIngredient(wi4);
        recipe10.addWeightedIngredient(wi5);
        recipe10.addWeightedIngredient(wi6);
        recipe10.addWeightedIngredient(wi7);
        recipe10.addWeightedIngredient(wi12);
        recipe10.addWeightedIngredient(wi13);
        recipe10.addWeightedIngredient(wi17);

        Recipe recipe11 = new Recipe("Chips", RecipeDifficulty.EASY);
        recipe11.addWeightedIngredient(wi1);
        recipe11.addWeightedIngredient(wi10);

        allRecipes.add(recipe1);
        allRecipes.add(recipe2);
        allRecipes.add(recipe3);
        allRecipes.add(recipe4);
        allRecipes.add(recipe5);
        allRecipes.add(recipe6);
        allRecipes.add(recipe7);
        allRecipes.add(recipe8);
        allRecipes.add(recipe9);
        allRecipes.add(recipe10);
        allRecipes.add(recipe11);

    }

    public static void printPricesRec() {
        for (Recipe recipe : allRecipes) {
            System.out.println(recipe.getRecipeName() + " costs: " + recipe.getPrice());
        }
    }

    public static void printFavRecipes() {
        for (Recipe recipe : favourites) {
            System.out.println(recipe.getRecipeName());
        }
    }
}
