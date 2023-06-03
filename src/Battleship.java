import java.util.Scanner;
public class Battleship {
    static String playerName1;
    static String playerName2;
    static Scanner scanner = new Scanner(System.in);
    static int[][] battleField1 = new int[10][10];
    static int[][] battleField2 = new int[10][10];
    static int[][] mon1 = new int[10][10];
    static int[][] mon2 = new int[10][10];
    public static void main(String[] args) {
        System.out.print(" Player#1, please enter your name: ");
        playerName1 = scanner.nextLine();
        System.out.print(" Player#2, please enter your name: ");
        playerName2 = scanner.nextLine();
        Ship.placeShips(playerName1, battleField1);
        Ship.placeShips(playerName2, battleField2);
        while (true) {
            Shot.turn(playerName1, mon1, battleField2);
            if (isWin()) break;
            Shot.turn(playerName2, mon2, battleField1);
            if (isWin()) break;
        }
    }
    public static boolean isWin() {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (mon1[i][j] == 2) count1++;
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (mon2[i][j] == 2) count2++;
            }
        }
        if (count1 >= 10) {
            System.out.println(playerName1 + " is winner!");
            return true;
        }
        if (count2 >= 10) {
            System.out.println(playerName2 + " is winner!");
            return true;
        }
        return false;
    }
}
