package ee.ttu.candyfactory.recipe;

import static java.lang.String.format;

public class Recipe {
  private String name;
  private Double weight;

  public Recipe(String name, double weight) {
    this.name = name;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return format("name: '%s', weight: %.2f", name, weight);
  }
}
