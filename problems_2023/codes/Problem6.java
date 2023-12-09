package problems_2023.codes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem6 {

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("problems_2023/inputs/problem6_input.txt"));
    List<Long> times = new ArrayList<>();
    List<Long> dist = new ArrayList<>();
    List<String> lines = new ArrayList<>();

    while(scanner.hasNext()) {
      lines.add(scanner.nextLine());
    }

    for(String part : lines.get(0).split(" ")) {
      times.add(Long.parseLong(part));
    }

    for(String part : lines.get(1).split(" ")) {
      dist.add(Long.parseLong(part));
    }


    long index1 = 0;
    long index2 = 0;
    for(int i = 0; i < times.size(); i++) {
      for(long j = 0; j < times.get(i); j++) {
        if(j * (times.get(i) - j) > dist.get(i)) {
          index1 = times.get(i) - j;
        }
      }

      for(long j = times.get(i) - 1; j >= 0; j--) {
        if((times.get(i) - j) * j > dist.get(i)) {
          index2 = times.get(i) - j;
        }
      }
    }
    System.out.println(index1 + " " + index2);
    System.out.println(index2 - index1 + 1);
  }
}
