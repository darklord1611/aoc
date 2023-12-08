package problems_2023.codes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem3 {


//  public static int solve(List<String> lines) {
//    int n = lines.size();
//    int m = lines.get(0).length();
//    for(int i = 0; i < n; i++) {
//      String curStr = lines.get(i);
//      String temp = "";
//      for(int j = 0; j < m; j++) {
//        if(Character.isDigit(curStr.charAt(j))) {
//          temp += String.valueOf(curStr.charAt(j));
//        }
//
//        if(curStr.charAt(j) == '.' && !temp.isEmpty()) {
//          if(isValid(lines, i, temp.i))
//        }
//      }
//    }
//  }

  public static boolean isValid(List<String> lines, int curRow, int start, int end) {
      return true;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("C:\\Users\\Admin\\IdeaProjects\\aoc\\sample_3.txt"));
    List<String> lines = new ArrayList<>();

    while(scanner.hasNext()) {
      lines.add(scanner.nextLine());
    }
//    int res = solve(lines);

    int maxDots = lines.get(0).length();
    Pattern pattern = Pattern.compile("\\d+(?:\\.\\.\\d+){1," + maxDots + "}");

    for(String line : lines) {
      Matcher matcher = pattern.matcher(line);
      while(matcher.find()) {
        System.out.println(matcher.group());
      }
    }
  }
}
