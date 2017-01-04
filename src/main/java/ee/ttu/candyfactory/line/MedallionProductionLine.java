package ee.ttu.candyfactory.line;

import ee.ttu.candyfactory.candy.ChocolateMedallion;

import java.util.Date;

public class MedallionProductionLine extends CandyProductionLine {

  private String picturePath;

  @Override
  public void produce(int amount) throws RecipeNotSetException {
    for (int i = 0; i < amount; i++) {
      ChocolateMedallion chocolateMedallion = new ChocolateMedallion();
      chocolateMedallion.setProductionDate(new Date());
      chocolateMedallion.setPicture(picturePath); /// ???

      addToProducedCandies(chocolateMedallion);
    }
    logBatchCompletion(new ChocolateMedallion().getName(), amount);
  }

  public void setPictureForBatch(String picturePath) {
    this.picturePath = picturePath;
  }
}
