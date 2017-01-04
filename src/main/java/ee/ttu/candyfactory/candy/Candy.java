package ee.ttu.candyfactory.candy;

import java.util.Date;

public class Candy {

  private String name;
  private double weight;
  private Date productionDate;
  private boolean packed;

  public Candy(String name, double weight) {
    this.name = name;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public double getWeight() {
    return weight;
  }

  public Date getProductionDate() {
    return productionDate;
  }

  public void setProductionDate(Date productionDate) {
    this.productionDate = productionDate;
  }

  public void pack() {
    this.packed = true;
  }

  public boolean isPacked() {
    return packed;
  }
}
