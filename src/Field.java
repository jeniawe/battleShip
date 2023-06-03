public class Field {
    public static void drawField(int[][] battleField) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                if (battleField[j][i] == 0) {
                    System.out.print("- ");
                } else System.out.print("X ");
            }
            System.out.println();
        }
    }
}
