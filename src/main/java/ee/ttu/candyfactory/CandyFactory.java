package ee.ttu.candyfactory;

import ee.ttu.candyfactory.candy.Candy;
import ee.ttu.candyfactory.line.CandyProductionLine;
import ee.ttu.candyfactory.line.MedallionProductionLine;
import ee.ttu.candyfactory.line.Packager;
import ee.ttu.candyfactory.line.RecipeNotSetException;
import ee.ttu.candyfactory.recipe.Recipe;

import java.util.ArrayList;
import java.util.List;

public class CandyFactory {

  public static void main(String[] args) throws RecipeNotSetException {
    new CandyFactory().doWork();
  }

  private CandyProductionLine candyProductionLine;
  private MedallionProductionLine medallionProductionLine;
  private Packager packager;

  private void doWork() throws RecipeNotSetException {
    candyProductionLine = new CandyProductionLine();
    medallionProductionLine = new MedallionProductionLine();
    packager = new Packager();

    candyProductionLine.setRecipe(new Recipe("Kaseke", 150.0));
    candyProductionLine.produce(2000);

    candyProductionLine.setRecipe(new Recipe("Emmake", 200.0));
    candyProductionLine.produce(5000);

    medallionProductionLine.produce(1550);

    List<Candy> producedCandy = new ArrayList<>();
    producedCandy.addAll(candyProductionLine.getProducedCandyAndClearProductionOutput());
    producedCandy.addAll(medallionProductionLine.getProducedCandyAndClearProductionOutput());

    packager.pack(producedCandy);

    candyProductionLine.setRecipe(new Recipe("Valge biison", 250.0));
    candyProductionLine.produce(4000);

    producedCandy.clear();
    producedCandy.addAll(candyProductionLine.getProducedCandyAndClearProductionOutput());

    packager.pack(producedCandy);
  }

}
