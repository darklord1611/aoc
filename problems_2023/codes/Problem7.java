package problems_2023.codes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Problem7 {

  private static int FIVE_OF_A_KIND = 7;
  private static int FOUR_OF_A_KIND = 6;
  private static int FULL_HOUSE = 5;
  private static int THREE_OF_A_KIND = 4;

  private static int TWO_PAIRS = 3;

  private static int ONE_PAIR = 2;

  private static int HIGH_CARD = 1;

  private static List<Character> characters =
          new ArrayList<>(List.of('J', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'Q', 'K', 'A'));


  public static int identifyHand(String hand) {
    Map<Character, Integer> freq = new HashMap<>();
    char maxCh = hand.charAt(0);
    int maxFreq = 0;
    for(int i = 0; i < hand.length(); i++) {
      Character character = hand.charAt(i);
      if(freq.get(character) == null) {
        freq.put(character, 1);
      } else {
        freq.put(character, freq.get(character) + 1);
      }
    }

    for(Character ch : freq.keySet()) {
      if(freq.get(ch) > maxFreq && ch != 'J') {
        maxFreq = freq.get(ch);
        maxCh = ch;
      }
    }

    if(maxCh != 'J') {
      freq.put(maxCh, freq.get(maxCh) + freq.getOrDefault('J', 0));
      freq.remove('J');
    }


    switch(freq.size()) {
      case 1 -> {
        return FIVE_OF_A_KIND;
      }
      case 4 -> {
        return ONE_PAIR;
      }
      case 5 -> {
        return HIGH_CARD;
      }
      case 2 -> {
        for(Character ch : freq.keySet()) {
          if(freq.get(ch) == 4) {
            return FOUR_OF_A_KIND;
          }
        }

        return FULL_HOUSE;
      }

      case 3 -> {
        for(Character ch : freq.keySet()) {
          if(freq.get(ch) == 3) {
            return THREE_OF_A_KIND;
          }
        }
        return TWO_PAIRS;
      }

    }

    return 0;
  }

  public static int compare(String a, String b) {
    for(int i = 0; i < a.length(); i++) {
      int res = characters.indexOf(a.charAt(i)) - characters.indexOf(b.charAt(i));
      if(res > 0) {
        return 1;
      } else if (res < 0) {
        return -1;
      }
    }

    return 0;
  }



  public static int getTotalBids(List<String> hands, Map<String, Integer> handBids) {
    int totalBids = 0;
    for(int i = 0; i < hands.size(); i++) {
      totalBids += (i + 1) * handBids.get(hands.get(i));
    }

    return totalBids;
  }

  public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("problems_2023/inputs/problem7_input.txt"));
    Map<String, Integer> handBids = new HashMap<>();
    List<String> hands = new ArrayList<>();
    while(scanner.hasNext()) {
      String str = scanner.nextLine();
      String hand = str.split(" ")[0];
      int bid = Integer.parseInt(str.split(" ")[1]);
      hands.add(hand);
      handBids.put(hand, bid);
    }

    hands.sort((a, b) -> {
      int res = identifyHand(a) - identifyHand(b);
      if (res > 0) {
        return 1;
      } else if (res < 0) {
        return -1;
      } else {
        return compare(a, b);
      }
    });

    int res = getTotalBids(hands, handBids);
    System.out.println(res);
  }
}
