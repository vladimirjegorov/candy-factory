package ee.ttu.candyfactory.line;

import ee.ttu.candyfactory.candy.Candy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static java.lang.String.format;

public class Packager {

  static final Logger LOG = LogManager.getLogger(Packager.class);

  public void pack(List<Candy> candyList) {
    LOG.info("Starting to pack candies");
    candyList.forEach(Candy::pack);
    LOG.info(format("Successfully packed %d candies", candyList.size()));
  }
}
