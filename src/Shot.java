import java.util.Scanner;
public class Shot {
    static Scanner scanner = new Scanner(System.in);
    public static void turn(String playerName, int[][] mon, int[][] battleField) {
        while (true) {
            System.out.println(playerName + ", please, make your turn.");
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < 10; j++) {
                    if (mon[i][j] == 0) {
                        System.out.print(". ");
                    } else if (mon[i][j] == 1) System.out.print(". ");
                    else System.out.println("X ");
                }
                System.out.println();
            }
            System.out.print("Please enter OX: ");
            int x = scanner.nextInt();
            System.out.print("Please enter OY: ");
            int y = scanner.nextInt();
            if (battleField[x][y] == 1) {
                System.out.println("HIT! Make your turn again!");
                mon[x][y] = 2;
            } else {
                System.out.println("MISS! Your opponent turn.");
                mon[x][y] = 1;
                break;
            }
        }
    }
}
