package ee.ttu.candyfactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.nio.file.Files.lines;

public class LogAnalyser {
  public static void main(String[] args) throws IOException {
    new LogAnalyser().doWork();
  }

  private void doWork() throws IOException {
    Path path = Paths.get("candy-factory.log");

    System.out.println("Lines in file: " + lines(path).count());

    Predicate<String> productionLineWasLaunchedPredicate = s -> s.contains(" Produced ") && s.contains("candy");
    Stream<String> linesWithCandyBatchEnd = lines(path).filter(productionLineWasLaunchedPredicate);
    System.out.println(format("Production lines were producing: %d times", linesWithCandyBatchEnd.count()));

    String lastLine = lines(path).filter(productionLineWasLaunchedPredicate).reduce((a, b) -> b).orElse(null);
    if (lastLine != null) {
      String[] split = lastLine.split("\\|");
      String latestTime = split[0];
      System.out.println("Latest time when production line was launched: " + latestTime);
    }

    long packagerRunTimes = lines(path).filter(s -> s.contains("Successfully packed")).count();
    System.out.println(format("Packager was run %d times", packagerRunTimes));

  }
}
