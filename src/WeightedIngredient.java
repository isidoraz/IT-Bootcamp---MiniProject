public class WeightedIngredient extends Ingredient {
    private double weight;
    private double pricePerUnit;


    public WeightedIngredient() {
        super(null);
    }

    public WeightedIngredient(String nameOfIngredient) {
        super(nameOfIngredient);
    }

    public WeightedIngredient(String nameOfIngredient, double weight, double pricePerUnit) {
        super(nameOfIngredient);
        this.weight = weight;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public double getPrice() {
        return weight * pricePerUnit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
