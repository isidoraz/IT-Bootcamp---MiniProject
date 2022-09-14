public abstract class Ingredient implements Priceable {
    private static int counter = 0;

    private int id;
    private String nameOfIngredient;

    public Ingredient(String nameOfIngredient) {
        this.id = ++counter;
        this.nameOfIngredient = nameOfIngredient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfIngredient() {
        return nameOfIngredient;
    }

    public void setNameOfIngredient(String nameOfIngredient) {
        this.nameOfIngredient = nameOfIngredient;
    }
}
