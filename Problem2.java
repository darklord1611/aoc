import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem2 {


  public static int solve(List<String> games) {
    int totalSum = 0;
    Map<String, Integer> limit = new HashMap<>();
    limit.put("red", 12);
    limit.put("blue", 14);
    limit.put("green", 13);
    for(int j = 0; j < games.size(); j++) {
      int totalPower = 1;
      int minRedCube = 1;
      int minGreenCube = 1;
      int minBlueCube = 1;
      String temp = games.get(j).substring(games.get(j).indexOf(':') + 2);
      String[] records = temp.split("; ");
      for(int k = 0; k < records.length; k++) {
        String[] parts = records[k].split(", ");
        for(int i = 0; i < parts.length; i++) {
          int curNum = Integer.parseInt(parts[i].split(" ")[0]);
          String color = parts[i].split(" ")[1];
          switch (color) {
            case "red" -> minRedCube = Math.max(minRedCube, curNum);
            case "blue" -> minBlueCube = Math.max(minBlueCube, curNum);
            case "green" -> minGreenCube = Math.max(minGreenCube, curNum);
          }
        }
      }

      totalPower *= minRedCube * minGreenCube * minBlueCube;
      totalSum += totalPower;
    }

    return totalSum;
  }

  public static void main(String[] args) throws FileNotFoundException {
    // 12 red, 13 green, 14 blue
    File file = new File("problem2_input.txt");
    Scanner scanner = new Scanner(file);

    List<String> games = new ArrayList<>();

    while(scanner.hasNext()) {
      games.add(scanner.nextLine());
    }


    int res = solve(games);

    System.out.println(res);

  }
}
