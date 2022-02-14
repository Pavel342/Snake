package game.top;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class mehanika extends JPanel implements ActionListener{

    Random r=new Random();
    private static int lenth = 1;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    public static boolean gameover = false;
    private static int fruitx;
    private static int fruity;
    private static final int DELAY=280;
    private static final int shirina=600;
    private static final int visota=500;
    private static final int allDots=3000;
    private static final int oneDot=25;
    private static final int[] masSnakex = new int[allDots];
    private static final int[] masSnakey = new int[allDots];
    private Timer timer;
    private Image telo;
    private Image hui;
    private Image head1;

    public mehanika() {
        initmehanika();
    }

    private void initmehanika() {

        addKeyListener(new TAdapter());
        setBackground(Color.cyan);
        setFocusable(true);
        setPreferredSize(new Dimension(shirina, visota));
        loadImages();
        initGame();
    }
    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/resurse/grud.png");
        telo = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resurse/chlen.png");
        hui = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resurse/dima.png");
        head1 = iih.getImage();
    }

    private void initGame() {
        masSnakex[1] = 1;
        masSnakey[1] = 1;
        locateFruit();
        timer = new Timer(DELAY, this);
        timer.start();
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    private void doDrawing(Graphics g) {

        if (!gameover) {

            g.drawImage(hui, fruitx, fruity, this);

            for (int i = 0; i < lenth; i++) {
                if (i == 0) {
                    g.drawImage(head1, masSnakex[i], masSnakey[i],this);
                } else {
                    g.drawImage(telo, masSnakex[i], masSnakey[i],this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {
            gameOver(g);
        }
    }
    private void gameOver(Graphics g) {

        String msg = "Потрачено...";
        Font small = new Font("Helvetica", Font.BOLD, 25);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.red);
        g.setFont(small);
        g.drawString(msg, (shirina - metr.stringWidth(msg)) / 2, visota / 2);
    }
    private void checkFruit() {

        if ((masSnakex[0] == fruitx) && (masSnakey[0] == fruity)) {

            lenth++;
            locateFruit();
        }
    }
    private void move() {

        for (int i = lenth; i > 0; i--) {
            masSnakex[i] = masSnakex[(i - 1)];
            masSnakey[i] = masSnakey[(i - 1)];
        }

        if (leftDirection) {
            masSnakex[0] -= oneDot;
        }

        if (rightDirection) {
            masSnakex[0] += oneDot;
        }

        if (upDirection) {
            masSnakey[0] -= oneDot;
        }

        if (downDirection) {
            masSnakey[0] += oneDot;
        }
    }
    private void checkCollision() {

        for (int i = lenth; i > 0; i--) {

            if ( (masSnakex[0] == masSnakex[i]) && (masSnakey[0] == masSnakey[i])) {
                gameover = true;
                break;
            }
        }

        if (masSnakex[0] >= shirina) {
            masSnakex[0] = 0;
        }

        if (masSnakex[0] < 0) {
            masSnakex[0] = shirina;
        }

        if (masSnakey[0] == visota) {
            masSnakey[0] = 0;
        }

        if (masSnakey[0] < 0) {
            masSnakey[0] = visota;
        }

        if (gameover) {
            timer.stop();
        }
    }

    private void locateFruit() {
        fruitx= oneDot* r.nextInt(shirina/oneDot);
        fruity=oneDot * r.nextInt(visota/oneDot);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!gameover) {

            checkFruit();
            checkCollision();
            move();
        }

        repaint();
    }


    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            char key2= e.getKeyChar();

            if ((key == KeyEvent.VK_LEFT || 'a'==key2) && (!rightDirection)) {
                timer.start();
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT || key2=='d') && (!leftDirection)) {
                timer.start();
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP|| key2=='w') && (!downDirection)) {
                timer.start();
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN || key2=='s') && (!upDirection)) {
                timer.start();
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            if (  key==KeyEvent.VK_ENTER || key==KeyEvent.VK_SPACE ) {
                timer.stop();
            }
        }
    }
}
