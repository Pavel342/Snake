package game.top;

import java.util.Random;
import java.util.Scanner;

public class mehanika {
    public mehanika() {
        String[] a = new String[2];
        mehanika(a);
    }
    private static final Scanner in = new Scanner(System.in);
    private static final Random rrr = new Random();
    private static boolean eat = false;
    private static int lenth = 1;
    private static int a = 1, b = 1;
    private static final int[] masSnakex = new int[100];
    private static final int[] masSnakey = new int[100];
    public static boolean gameover = false;
    private static int fruitx;
    private static int fruity;
    private static final char[][] map = new char[13][13];

    public static void mehanika(String[] args) {
        masSnakex[1] = 1;
        masSnakey[1] = 1;
        do {
            fruitx = 1 + (rrr.nextInt(9));
            fruity = 1 + (rrr.nextInt(9));
        } while (fruitx == 1 && fruity == 1);

        System.out.print("\t\t\t");
        for (int i = 1; i < 13; i++) {
            map[0][i] = '-';
        }
        for (int i = 1; i < 13; i++) {
            System.out.print(map[0][i]);
        }
        System.out.println();
        for (int i = 1; i < 11; i++) {
            System.out.print("\t\t\t");
            for (int j = 1; j < 11; j++) {
                if (j == 1) {
                    map[i][j - 1] = '|';
                    System.out.print(map[i][j - 1]);
                }
                if (fruitx == i && fruity == j) System.out.print(map[i][j] = '2');
                else if (i == 1 && j == 1) System.out.print(map[i][j] = '1');
                else System.out.print(map[i][j] = '0');
                if (j == 10) {
                    map[i][j + 1] = '|';
                    System.out.print(map[i][j + 1]);
                }
            }
            System.out.println();
        }
        System.out.print("\t\t\t");
        for (int i = 1; i < 13; i++) {
            map[11][i] = '-';
        }
        for (int i = 1; i < 13; i++) {
            System.out.print(map[11][i]);
        }
        System.out.println();
        while (true) {
            String vvod;
            do {
                vvod = in.next();
                if (!vvod.equals("w") & !vvod.equals("s") & !vvod.equals("a") & !vvod.equals("d"))
                    System.out.println("Ты че ввел еблан?( w, a, s, d!!!) ");
            }
            while (!vvod.equals("w") & !vvod.equals("s") & !vvod.equals("a") & !vvod.equals("d"));
            int aa = a;
            int bb = b;
            switch (vvod) {
                case ("w"):
                    if (map[aa - 1][b] == '0') {
                        map[aa - 1][b] = '1';
                        int x = masSnakex[lenth];
                        int y = masSnakey[lenth];
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa - 1;
                        masSnakey[1] = b;
                        map[x][y] = '0';
                        a--;
                    } else if (map[a - 1][b] == '2') {
                        lenth++;
                        map[aa - 1][bb] = '1';
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa - 1;
                        masSnakey[1] = bb;
                        eat = true;
                        a--;
                    } else if (map[a - 1][b] == '-') {
                        map[aa + 9][b] = '1';
                        int x = masSnakex[lenth];
                        int y = masSnakey[lenth];
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa + 9;
                        masSnakey[1] = b;
                        map[x][y] = '0';
                        a += 9;
                    } else if (map[a - 1][b] == '1') gameover = true;
                    break;
                case ("s"):
                    if (map[aa + 1][b] == '0') {

                        map[aa + 1][b] = '1';
                        int x = masSnakex[lenth];
                        int y = masSnakey[lenth];
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa + 1;
                        masSnakey[1] = b;
                        map[x][y] = '0';
                        a++;
                    } else if (map[aa + 1][b] == '2') {
                        lenth++;
                        map[aa + 1][b] = '1';
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa + 1;
                        masSnakey[1] = bb;
                        eat = true;
                        a++;
                    } else if (map[a + 1][b] == '-') {
                        map[aa - 9][b] = '1';
                        int x = masSnakex[lenth];
                        int y = masSnakey[lenth];
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa - 9;
                        masSnakey[1] = b;
                        map[x][y] = '0';
                        a -= 9;
                    } else if (map[a + 1][b] == '1') gameover = true;
                    break;
                case ("a"):
                    if (map[aa][b - 1] == '0') {
                        map[aa][b - 1] = '1';
                        int x = masSnakex[lenth];
                        int y = masSnakey[lenth];
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa;
                        masSnakey[1] = b - 1;
                        map[x][y] = '0';
                        b--;
                    } else if (map[a][b - 1] == '2') {
                        lenth++;
                        map[aa][b - 1] = '1';
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa;
                        masSnakey[1] = bb - 1;
                        eat = true;
                        b--;
                    } else if (map[aa][b - 1] == '|') {
                        map[aa][b + 9] = '1';
                        int x = masSnakex[lenth];
                        int y = masSnakey[lenth];
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa;
                        masSnakey[1] = b + 9;
                        map[x][y] = '0';
                        b += 9;
                    } else if (map[a][b - 1] == '1') gameover = true;
                    break;
                case ("d"):
                    if (map[aa][b + 1] == '0') {
                        map[aa][b + 1] = '1';
                        int x = masSnakex[lenth];
                        int y = masSnakey[lenth];
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa;
                        masSnakey[1] = b + 1;
                        map[x][y] = '0';
                        b++;
                    } else if (map[a][b + 1] == '2') {
                        lenth++;
                        map[aa][bb + 1] = '1';
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa;
                        masSnakey[1] = bb + 1;
                        eat = true;
                        b++;
                    } else if (map[a][b + 1] == '|') {
                        map[aa][b - 9] = '1';
                        int x = masSnakex[lenth];
                        int y = masSnakey[lenth];
                        for (int i = lenth; i > 1; i--) {
                            masSnakex[i] = masSnakex[i - 1];
                            masSnakey[i] = masSnakey[i - 1];
                        }
                        masSnakex[1] = aa;
                        masSnakey[1] = b - 9;
                        map[x][y] = '0';
                        b -= 9;
                    } else if (map[a][b + 1] == '1') gameover = true;
                    break;
            }
            repaint();
        }
    }

    public static void repaint(){
        if(gameover){System.out.print("Вы проебали:-(");}
        System.out.print("\t\t\t");
        for(int i=1;i<13;i++){System.out.print(map[0][i]);}
        System.out.println();
        for(int i=1;i<11;i++){
            System.out.print("\t\t\t");
            for(int j=1;j<11;j++){
                if(j==1){        System.out.print('|');
                }
                if(eat) {do{fruitx = 1+(rrr.nextInt(9));
                    fruity = 1+(rrr.nextInt(9));}while(map[fruitx][fruity]!='0');eat=false;}
                if(fruitx==i && fruity==j ) System.out.print(map[i][j]='2');
                else System.out.print(map[i][j]);
                if(j==10){        System.out.print('|');
                }
            }
            System.out.println();
        }
        System.out.print("\t\t\t");
        for(int i=1;i<13;i++){System.out.print(map[11][i]);}
        System.out.println();
    }
}
