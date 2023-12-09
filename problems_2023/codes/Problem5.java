package problems_2023.codes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem5 {

  public static long solve(List<List<String>> conditions, String seedStr) {
    long minLocation = Long.MAX_VALUE;
    String[] seeds = seedStr.split(" ");
    int n = seeds.length;
    for(int i = 0; i < n; i += 2) {
      if(i + 1 >= n) {
        break;
      }
      long curNum = Long.parseLong(seeds[i]);
      long curRange = Long.parseLong(seeds[i + 1]) + curNum;
      for(long j = curNum; j <= curRange; j++) {
        long soilNum = findInRange(conditions, j, 0);
        long fertNum = findInRange(conditions, soilNum, 1);
        long waterNum = findInRange(conditions, fertNum, 2);
        long lightNum = findInRange(conditions, waterNum, 3);
        long tempNum = findInRange(conditions, lightNum, 4);
        long humidNum = findInRange(conditions, tempNum, 5);
        long locationNum = findInRange(conditions, humidNum, 6);
        System.out.println(locationNum);
        minLocation = Math.min(minLocation, locationNum);
      }
    }

    return minLocation;
  }

  public static long findInRange(List<List<String>> conditions, long curNum, int curIndex) {
    for(String condition : conditions.get(curIndex)) {
      String[] parts = condition.split(" ");
      long dest = Long.parseLong(parts[0]);
      long src = Long.parseLong(parts[1]);
      long range = Long.parseLong(parts[2]);

      if (curNum <= src + range - 1 && curNum >= src) {
        curNum = dest + (curNum - src);
        return curNum;
      }
    }
    return curNum;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("problems_2023/inputs/problem5_input.txt"));
    List<String> seed2Soil = new ArrayList<>();
    List<String> soil2Fert = new ArrayList<>();
    List<String> fert2Water = new ArrayList<>();
    List<String> water2Light = new ArrayList<>();
    List<String> light2Temp = new ArrayList<>();
    List<String> temp2Humid = new ArrayList<>();
    List<String> humid2Loc = new ArrayList<>();

    List<List<String>> conditions = new ArrayList<>();
    conditions.add(seed2Soil);
    conditions.add(soil2Fert);
    conditions.add(fert2Water);
    conditions.add(water2Light);
    conditions.add(light2Temp);
    conditions.add(temp2Humid);
    conditions.add(humid2Loc);
    String seeds = scanner.nextLine();
    int curIndex = -1;
    while(scanner.hasNext()) {
      String curStr = scanner.nextLine();
      if(curStr.contains("map")) {
        curIndex++;
      } else {
        conditions.get(curIndex).add(curStr);
      }
    }

    System.out.println(solve(conditions, seeds));
  }
}
