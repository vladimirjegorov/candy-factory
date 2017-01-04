package ee.ttu.candyfactory.line;

import ee.ttu.candyfactory.candy.Candy;
import ee.ttu.candyfactory.recipe.Recipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;

public class CandyProductionLine {

  private static final Logger LOG = LogManager.getLogger(CandyProductionLine.class);

  private Recipe currentRecipe;
  private List<Candy> producedCandies = new ArrayList<>();

  public void setRecipe(Recipe recipe) {
    this.currentRecipe = recipe;
  }

  public void turnOn() {
    LOG.info("Recipe in use: " + currentRecipe);
  }

  public void produce(int amount) throws RecipeNotSetException {
    if (currentRecipe == null) {
      throw new RecipeNotSetException();
    }

    for (int i = 0; i < amount; i++) {
      Candy candy = new Candy(currentRecipe.getName(), currentRecipe.getWeight());

      candy.setProductionDate(new Date());

      addToProducedCandies(candy);
    }

    logBatchCompletion(currentRecipe.getName(), amount);
  }

  public List<Candy> getProducedCandyAndClearProductionOutput() {
    List<Candy> candiesForReturn = new ArrayList<>(producedCandies);
    producedCandies.clear();
    return candiesForReturn;
  }

  protected void addToProducedCandies(Candy candy) {
    this.producedCandies.add(candy);
  }

  protected void logBatchCompletion(String name, int amount) {
    LOG.info(format("Produced %d of '%s' candy", amount, name));
  }
}
