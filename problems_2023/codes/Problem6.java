package problems_2023.codes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem6 {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("problems_2023/inputs/problem6_input.txt"));
    List<Integer> times = new ArrayList<>();
    List<Integer> dist = new ArrayList<>();
    List<String> lines = new ArrayList<>();

    while(scanner.hasNext()) {
      lines.add(scanner.nextLine());
    }

    for(String part : lines.get(0).split(" ")) {
      times.add(Integer.parseInt(part));
    }

    for(String part : lines.get(1).split(" ")) {
      dist.add(Integer.parseInt(part));
    }


    int total = 1;
    for(int i = 0; i < times.size(); i++) {
      int cnt = 0;
      for(int j = 0; j < times.get(i); j++) {
        if((times.get(i) - j) * j > dist.get(i)) {
          cnt++;
        }
      }

      total *= cnt;
    }

    System.out.println(total);
  }
}
