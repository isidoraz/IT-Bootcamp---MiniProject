import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void addingIngredientsToFridge() {
        for (WeightedIngredient weightedIngredient : Database.allWeightedIngredients) {
            System.out.println(weightedIngredient.getId() + ". " + weightedIngredient.getNameOfIngredient());
        }
        System.out.println("Choose ingredient from the list that you want to add and write the index: ");

        int id = scanner.nextInt();
        for (WeightedIngredient weightedIngredient : Database.allWeightedIngredients) {
            if (weightedIngredient.getId() == id) {
                Database.fridge.addWI(weightedIngredient);
                System.out.println("You just added " + weightedIngredient.getNameOfIngredient() + " into the fridge.");
                break;
            }
        }
    }

    public static void removeIngredientsFromFridge() {
//        for (WeightedIngredient weightedIngredient : Database.allWeightedIngredients) {
//            System.out.println(weightedIngredient.getId() + ". " + weightedIngredient.getNameOfIngredient());
//        }
        printWhatsInFridge();
        System.out.println("Choose ingredient from the list that you want to remove and write the index: ");
        int id = scanner.nextInt();
        for (WeightedIngredient weightedIngredient : Database.allWeightedIngredients) {
            if (weightedIngredient.getId() == id) {
                Database.fridge.removeWI(weightedIngredient);
                System.out.println("You just removed " + weightedIngredient.getNameOfIngredient() + " from the fridge.");
                break;
            }
        }
    }

//    public static void reduceAmountOfIngredientsFromFridge(WeightedIngredient weightedIngredient, int weight) {
//        System.out.println("Enter id");
//        int id = scanner.nextInt();
//        System.out.println("Enter amount");
//        int amount = scanner.nextInt();
//        reduceAmountOfIngredientsFromFridge(Database.allWeightedIngredients.get(id - 1), amount);
////        Integer amount = Database.fridge.getAllWeightedIngredients().get(weightedIngredient);
////        if (amount <= weight) {
////            Database.fridge.removeWI(weightedIngredient);
////        } else {
////            Database.fridge.getAllWeightedIngredients().put(weightedIngredient, amount - weight);
////        }
//    }

    public static void whatMealsCanMake() {
        for (Recipe recipe : Database.allRecipes) {
            if (Database.fridge.canMakeAMeal(recipe)) {
                System.out.println(recipe.getRecipeName());
            }
        }
    }

    public static void whatScaledMealsCanMake() {
        for (Recipe recipe : Database.allRecipes) {
            if (Database.fridge.canMakeAMeal(recipe)) {
                Recipe scaledRecipe = recipe.getScaledRecipe(50);
                System.out.println(scaledRecipe.getRecipeName());
            }
        }
    }

    public static void makeMeal() {
        int index = 0;
        for (Recipe recipe : Database.allRecipes) {
            System.out.println(index + ". " + recipe.getRecipeName());
            index++;
        }
        int input = scanner.nextInt();
        Recipe recipe = Database.allRecipes.get(input);
        Database.fridge.makeMeal(recipe);
        System.out.println("You have successfully made " + recipe.getRecipeName());
    }

    public static void printWhatsInFridge() {
        for (WeightedIngredient weightedIngredient : Database.fridge.getAllWeightedIngredients().keySet()) {
            System.out.println(weightedIngredient.getId() + ". " + weightedIngredient.getNameOfIngredient() + " " + Database.fridge.getAllWeightedIngredients().get(weightedIngredient));
        }
        if (Database.fridge.getAllWeightedIngredients().isEmpty()) {
            System.out.println("Fridge is empty.");
        }
    }

    public static void whatMealCanMakeForXMoney() {
        Database.printPricesRec();
        System.out.println("How much money do you have? Please enter the amount: ");
        double price = scanner.nextDouble();
        System.out.println("With that amount you can prepare these meals: ");
        for (Recipe recipe : Database.allRecipes) {
            if (recipe.getPrice() <= price) {
                System.out.println(recipe.getRecipeName());
            }
        }
    }

    public static void mealsDifficulty() {
        try {
            System.out.println("Please enter level of difficulty (BEGINNER, EASY, MEDIUM, HARD or PRO): ");
            String input = scanner.next();
            RecipeDifficulty difficulty = RecipeDifficulty.valueOf(input.toUpperCase());
            System.out.println("At " + input + " level you can make" + ": ");
            for (Recipe recipe : Database.allRecipes) {
                if (difficulty == recipe.getRecipeDifficulty()) {
                    System.out.println(recipe.getRecipeName());
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter one of the recommended values above!");
        }
    }

    public static void mealsPriceAndDifficulty() {
        System.out.println("How much money do you have? Please enter the amount: ");
        double price = scanner.nextDouble();
        System.out.println("Please enter level of difficulty (BEGINNER, EASY, MEDIUM, HARD or PRO): ");
        String input = scanner.next();
        RecipeDifficulty difficulty = RecipeDifficulty.valueOf(input.toUpperCase());
        System.out.println("With that amount of money and level, you can make these meals: ");
        for (Recipe recipe : Database.allRecipes) {
            if ((recipe.getPrice() <= price) && (difficulty == recipe.getRecipeDifficulty())) {
                System.out.println(recipe.getRecipeName());
            }
        }
    }

    public static void sortingByRecipeDifficulty() {
        System.out.println("Sorted meals by difficulty: ");
        System.out.println("--------------------------");
        Database.allRecipes.sort((r1, r2) -> r1.getRecipeDifficulty().compareTo(r2.getRecipeDifficulty()));
        for (Recipe recipe : Database.allRecipes) {
            System.out.println(recipe.getRecipeDifficulty() + ": " + recipe.getRecipeName());
        }
    }

    public static void sortingByRecipePrice() {
        System.out.println("Sorted meals by price in ascending order: ");
        System.out.println("----------------------------------------");
        Database.allRecipes.sort((r1, r2) -> (int) (r1.getPrice() - r2.getPrice()));
        for (Recipe recipe : Database.allRecipes) {
            System.out.printf(recipe.getRecipeName() + ": %.1f\n", recipe.getPrice());
        }
    }

    public static void addFavRecipe() {
        int index = 0;
        for (Recipe recipe : Database.allRecipes) {
            System.out.println(index + ". " + recipe.getRecipeName());
            index++;
        }
        int input = scanner.nextInt();
        Recipe recipe = Database.allRecipes.get(input);
        Database.favourites.add(recipe);
        System.out.println("You just added " + recipe.getRecipeName() + " to favourites.");
    }

    public static void printFavRecipes() {
        Database.printFavRecipes();
    }

    public static void removeFavRecipe() {
        int index = 0;
        for (Recipe recipe : Database.favourites) {
            System.out.println(index + ". " + recipe.getRecipeName());
            index++;
        }
        int input = 0;
        Database.favourites.remove(input);
    }



    public static void printMenu() {
        System.out.println("----------------------------------------");
        System.out.println("1. What's in the Fridge?");
        System.out.println("2. Add to fridge.");
        System.out.println("3. Remove from the fridge.");
        System.out.println("4. What meals can be made with ingredients in the fridge?");
        System.out.println("5. Scaled meals making.");
        System.out.println("6. Make meal.");
        System.out.println("7. What meals can be made with your amount of money?");
        System.out.println("8. List of meals according to level of difficulty.");
        System.out.println("9. Combination of 7th and 8th.");
        System.out.println("10. Sort recipes by difficulty.");
        System.out.println("11. Sort recipes by price.");
        System.out.println("12. Add favourite recipe.");
        System.out.println("13. Remove favourite recipe.");
        System.out.println("14. Print favourite recipes.");
        System.out.println("0. for EXIT");
    }

    public static void menu() {
        boolean flag = true;
            while (flag) {
                printMenu();

                System.out.println("Choose the number:");
                int num = scanner.nextInt();

                switch (num) {
                    case 1 -> printWhatsInFridge();
                    case 2 -> addingIngredientsToFridge();
                    case 3 -> removeIngredientsFromFridge();
                    case 4 -> whatMealsCanMake();
                    case 5 -> whatScaledMealsCanMake();
                    case 6 -> makeMeal();
                    case 7 -> whatMealCanMakeForXMoney();
                    case 8 -> mealsDifficulty();
                    case 9 -> mealsPriceAndDifficulty();
                    case 10 -> sortingByRecipeDifficulty();
                    case 11 -> sortingByRecipePrice();
                    case 12 -> addFavRecipe();
                    case 13 -> removeFavRecipe();
                    case 14 -> printFavRecipes();
                    case 0 -> flag = false;
                    default -> System.out.println("Invalid input! Try again.");
                }
            }
        System.out.println("Menu is closed. Goodbye!");

    }
}


