package problems_2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4 {


  public static int solve(List<List<Integer>> winNums, List<List<Integer>> curNums) {
    int n = winNums.size();
    int totalScore = 0;
    for(int i = 0; i < n; i++) {
      int curScore = 0;
      int m = winNums.get(i).size();
      for(int j = 0; j < m; j++) {
        if(curNums.get(i).contains(winNums.get(i).get(j))) {
          if(curScore == 0) {
            curScore += 1;
          } else {
            curScore *= 2;
          }
        }
      }
      totalScore += curScore;
    }

    return totalScore;
  }
  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("C:\\Users\\Admin\\IdeaProjects\\aoc\\problem4_input.txt"));
    List<String> lines = new ArrayList<>();
    List<List<Integer>> winningNumbers = new ArrayList<>();
    List<List<Integer>> currentNumbers = new ArrayList<>();
    while(scanner.hasNext()) {
      lines.add(scanner.nextLine());
    }


    for(int i = 0; i < lines.size(); i++) {
      winningNumbers.add(new ArrayList<>());
      currentNumbers.add(new ArrayList<>());
    }


    for(int i = 0; i < lines.size(); i++) {
      String actual = lines.get(i).split(": ")[1];
      String[] nums = actual.split(" \\| ");
      for(String num : nums[0].trim().split("\\s+")) {
        winningNumbers.get(i).add(Integer.parseInt(num));
      }

      for(String num : nums[1].trim().split("\\s+")) {
        currentNumbers.get(i).add(Integer.parseInt(num));
      }
    }


    int res = solve(winningNumbers, currentNumbers);
    System.out.println(res);
  }
}
