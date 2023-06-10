import java.util.Scanner;
public class Ship {
    static Scanner scanner = new Scanner(System.in);
    public static void placeShips(String playerName, int[][] battleField) {
        int deck = 4;
        int count = 1;
        while (deck >= 1) {
            for (int t = 0; t<count; t++){
                System.out.println();
                Field.drawField(battleField);
                System.out.print(playerName + ", please enter OX: ");
                int x = scanner.nextInt();
                System.out.print(playerName + ", please enter OY: ");
                int y = scanner.nextInt();
                System.out.println("Choose direction:");
                System.out.println("1. Vertical.");
                System.out.println("2. Horizontal.");
                int direction = scanner.nextInt();
                if (!isAvailable(x, y, deck, direction, battleField)) {
                    System.out.println("Wrong coordinates");
                    continue;
                }
                for (int i = 0; i < deck; i++) {
                    if (direction == 1) {
                        battleField[x][y + i] = 1;
                    } else {
                        battleField[x + i][y] = 1;

                    }
                }
            }
            count++;
            deck--;
        }
    }
    public static boolean isAvailable(int x, int y, int deck, int direction, int[][] battleField) {
        if (direction == 1) {
            if (y + deck > 10) return false;
        }
        if (direction==2) {
            if (x + deck >10) return false;
        }
        while (deck!=0){
            for (int i = 0; i < deck; i++) {
                int xi = 0;
                int yi = 0;
                if (direction == 1) yi = i;
                else xi=i;
                if (x+1+xi<10 && x+1+xi>=0) {
                    if (battleField[x+1+xi][y+yi]!=0) return false;
                }
                if (x-1+xi<10 && x-1+xi>=0) {
                    if (battleField[x-1+xi][y+yi]!=0) return false;
                }
                if (y+1+yi<10 && y+1+yi>=0) {
                    if (battleField[x+xi][y+1+yi]!=0) return false;
                }
                if (y-1+yi<10 && y-1+yi>=0) {
                    if (battleField[x+xi][y-1+yi]!=0) return false;
                }
            }
            deck--;
        }
        return true;
    }
}
