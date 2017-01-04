package ee.ttu.candyfactory.candy;

public class ChocolateMedallion extends Candy {

  private String picture;

  public ChocolateMedallion() {
    super("Chocolate Medallion", 100.0);
  }

  public void setPicture(String picture) {
    this.picture = picture;
  }

  public String getPicture() {
    return picture;
  }
}
