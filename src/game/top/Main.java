package game.top;


import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Random rrr=new Random() ;
        boolean eat=false;
        int lenth=1;
        char [][][] masSnake=new char[100][11][11];
        masSnake[1][1][1]=1;
        int a=1,b=1;
        boolean gameover=false;
        int fruitx;
        int fruity;
        do{fruitx = 1+(rrr.nextInt(9));
            fruity = 1+(rrr.nextInt(9));}while(fruitx==1 && fruity==1);
        char[][] map=new char[13][13];
        System.out.print("\t\t\t");
        for(int i=1;i<13;i++){map[0][i]= '-';}
        for(int i=1;i<13;i++){System.out.print(map[0][i]);}
        System.out.println();
	for(int i=1;i<11;i++){
	    System.out.print("\t\t\t");
	    for(int j=1;j<11;j++){
	        if(j==1){        System.out.print('|');
            }
	        if(fruitx==i && fruity==j) System.out.print(map[i][j]='2');
	        else if(i==1 && j==1) System.out.print(map[i][j] = '1');
	        else System.out.print(map[i][j] = '0');
	        if(j==10){        System.out.print('|');
            }
        }
        System.out.println();
    }
        System.out.print("\t\t\t");
        for(int i=1;i<13;i++){map[11][i]= '-';}
        for(int i=1;i<13;i++){System.out.print(map[11][i]);}
        System.out.println();
	while (!gameover){
	    String vvod= in.next();
	    int aa=a;
	    int bb=b;
	    switch (vvod){
            case("w"): if(map[aa-1][b]=='0'){
                map[aa-1][b]='1';
                masSnake[lenth][aa-1][b]='1';
                map[aa+lenth-1][b]='0';
                masSnake[1][aa+lenth-1][b]='0';
                a--;
            }
            else if(map[a-1][b]=='2'){
                masSnake[lenth+1][aa-1][bb]='1';
                map[aa-1][bb]='1';
                eat=true;
                a--;
            }
            else if(map[a-1][b]=='-'){
                map[aa+lenth-1][b]='0';
                map[aa+9][b]='1';
                a+=9;
            }
                break;
            case("s"):if(map[aa+1][b]=='0'){
                map[aa+1][b]='1';
                masSnake[lenth][aa+1][b]='1';
                map[aa-(lenth-1)][b]='0';
                masSnake[1][aa-(lenth-1)][b]='0';
                a++;
            }
            else if(map[a-1][b]=='2'){
                masSnake[lenth+1][aa+1][bb]='1';
                map[aa+1][bb]='1';
                eat=true;
                a++;
            }
            else if(map[a+1][b]=='-'){
                map[aa-(lenth-1)][b]='0';
                map[aa-9][b]='1';
                a-=9;
            }
                break;
            case("a"):if(map[aa][b-1]=='0'){
                map[aa][b-1]='1';
                masSnake[lenth][aa][b-1]='1';
                map[aa][b+(lenth-1)]='0';
                masSnake[1][aa][b+(lenth-1)]='0';
                b--;
            }
            else if(map[a][b-1]=='2'){
                masSnake[lenth+1][aa][bb-1]='1';
                map[aa][bb-1]='1';
                eat=true;
                b--;
            }
            else if(map[a][b--]=='|'){
                map[aa][b+(lenth-1)]='0';
                map[aa][b+9]='1';
                b+=9;
            }
                break;
            case("d"):if(map[aa][b+1]=='0'){
                map[aa][b+1]='1';
                masSnake[lenth][aa][b+1]='1';
                map[aa][b-(lenth-1)]='0';
                masSnake[1][aa][b-(lenth-1)]='0';
                b++;
            }
            else if(map[a][b+1]=='2'){
                masSnake[lenth+1][aa][bb+1]='1';
                map[aa][bb+1]='1';
                eat=true;
                b++;
            }
            else if(map[a][b++]=='|'){
                map[aa][b-(lenth-1)]='0';
                map[aa][b-9]='1';
                b-=9;
            }
            break;
        }

        System.out.print("\t\t\t");
        for(int i=1;i<13;i++){System.out.print(map[0][i]);}
        System.out.println();
        for(int i=1;i<11;i++){
            System.out.print("\t\t\t");
            for(int j=1;j<11;j++){
                if(j==1){        System.out.print('|');
                }
                if(eat==true) {do{fruitx = 1+(rrr.nextInt(9));
                 fruity = 1+(rrr.nextInt(9));}while(map[fruitx][fruity]=='0');eat=false;}
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
	   // if(vvod.charAt(0)=='q')gameover=true;
    }

    }
}