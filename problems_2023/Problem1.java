package problems_2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem1 {
  // ownerproof-3538742-1701522064-ef00932ae19f

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("problem1_input.txt");
    Scanner scanner = new Scanner(file);
    List<String> strings = new ArrayList<>();
    while(scanner.hasNext()) {
      strings.add(scanner.nextLine());
    }
    scanner.close();


    Map<String, Integer> validNums = new HashMap<>();
    validNums.put("one", 1);
    validNums.put("two", 2);
    validNums.put("three", 3);
    validNums.put("four", 4);
    validNums.put("five", 5);
    validNums.put("six", 6);
    validNums.put("seven", 7);
    validNums.put("eight", 8);
    validNums.put("nine", 9);

    int res = 0;

    // sliding window size 3,4 and 5
    for(String string : strings) {
      int cur_num = 0;
      StringBuilder subStr3 = new StringBuilder();
      StringBuilder subStr4 = new StringBuilder();
      StringBuilder subStr5 = new StringBuilder();
      for(int i = 0; i < string.length(); i++) {
        if(subStr3.length() == 3) {
          subStr3.deleteCharAt(0);
        }

        if(subStr4.length() == 4) {
          subStr4.deleteCharAt(0);
        }


        if(subStr5.length() == 5) {
          subStr5.deleteCharAt(0);
        }

        subStr3.append(string.charAt(i));
        subStr4.append(string.charAt(i));
        subStr5.append(string.charAt(i));

        if(validNums.get(subStr3.toString()) != null) {
          cur_num += validNums.get(subStr3.toString()) * 10;
          break;
        }

        if(validNums.get(subStr4.toString()) != null) {
          cur_num += validNums.get(subStr4.toString()) * 10;
          break;
        }

        if(validNums.get(subStr5.toString()) != null) {
          cur_num += validNums.get(subStr5.toString()) * 10;
          break;
        }

        if(string.charAt(i) - '0' < 10) {
          cur_num += (string.charAt(i) - '0') * 10;
          break;
        }
      }
      subStr3 = new StringBuilder();
      subStr4 = new StringBuilder();
      subStr5 = new StringBuilder();

      for(int i = string.length() - 1; i >= 0; i--) {


        // sixteen
        // n -> ne -> een -> eet -> ... -> xis
        if(subStr3.length() == 3) {
          subStr3.deleteCharAt(0);
        }

        if(subStr4.length() == 4) {
          subStr4.deleteCharAt(0);
        }


        if(subStr5.length() == 5) {
          subStr5.deleteCharAt(0);
        }

        subStr3.append(string.charAt(i));
        subStr4.append(string.charAt(i));
        subStr5.append(string.charAt(i));

        String temp3 = new StringBuilder(subStr3.toString()).reverse().toString();
        String temp4 = new StringBuilder(subStr4.toString()).reverse().toString();
        String temp5 = new StringBuilder(subStr5.toString()).reverse().toString();

        if(validNums.get(temp3) != null) {
          cur_num += validNums.get(temp3);
          break;
        }

        if(validNums.get(temp4) != null) {
          cur_num += validNums.get(temp4);
          break;
        }

        if(validNums.get(temp5) != null) {
          cur_num += validNums.get(temp5);
          break;
        }


        if (string.charAt(i) - '0' < 10) {
          cur_num += string.charAt(i) - '0';
          break;
        }
      }
      System.out.println(cur_num);
      res += cur_num;
    }
    System.out.println(res);
  }
}
