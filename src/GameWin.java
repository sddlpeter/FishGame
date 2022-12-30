import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWin extends JFrame {
    int width = 1440;
    int height = 900;
    static int state = 0;
    Bg bg = new Bg();
    Enemy enemy;
    MyFish myFish = new MyFish();
    public static int time = 0;
    Image offScreenImage;
    double random;
    Enemy boss;
    boolean isBoss = false;
    SoundEffect se;

    public GameWin() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        se = new SoundEffect();
        se.play2();
        this.setVisible(true);
        this.setBounds(0, 1000, 1440, 900);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("大鱼吃小鱼");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1 && state == 0) {
                    state = 1;
                    repaint();
                }

                if (e.getButton() == 1 && (state == 2 || state == 3)) {
                    reGame();
                    state = 1;
                }
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 38) {
                    GameUtils.UP = true;
                }
                if (e.getKeyCode() == 40) {
                    GameUtils.DOWN = true;
                }
                if (e.getKeyCode() == 37) {
                    GameUtils.LEFT = true;
                }
                if (e.getKeyCode() == 39) {
                    GameUtils.RIGHT = true;
                }
                if (e.getKeyCode() == 32) {
                    switch (state) {
                        case 1:
                            state = 4;
                            GameUtils.drawWord(getGraphics(), "游戏暂停", Color.RED, 50, 600, 400);
                            break;
                        case 4:
                            state = 1;
                            break;
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 38) {
                    GameUtils.UP = false;
                }
                if (e.getKeyCode() == 40) {
                    GameUtils.DOWN = false;
                }
                if (e.getKeyCode() == 37) {
                    GameUtils.LEFT = false;
                }
                if (e.getKeyCode() == 39) {
                    GameUtils.RIGHT = false;
                }
            }
        });

        while(true) {
            repaint();
            time++;
            Thread.sleep(40);
        }
    }

    @Override
    public void paint(Graphics g) {
        offScreenImage = createImage(width, height);
        Graphics gImage = offScreenImage.getGraphics();
        bg.paintSelf(gImage, myFish.level);


        // 游戏状态：0-未开始，1-游戏中，2-游戏失败，3-游戏胜利，4-游戏暂停，5-重新开始
        switch(state) {
            case 0:
                break;
            case 1:
                myFish.paintSelf(gImage);
                try {
                    logic();
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Enemy enemy : GameUtils.enemyList) {
                    enemy.paintSelf(gImage);
                }

                if (isBoss) {
                    boss.x += boss.dir * boss.speed;
                    boss.paintSelf(gImage);
                    if (boss.x < 0) {
                        gImage.setColor(Color.RED);
                        gImage.fillRect(boss.x + boss.height / 2, boss.y + boss.width / 2, 2800,boss.height / 20);
                    }
                }
                break;
            case 2:
                try {

                    logic();
                } catch (UnsupportedAudioFileException e) {
                    throw new RuntimeException(e);
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                for (Enemy e : GameUtils.enemyList) {
                    e.paintSelf(gImage);
                }
                if (isBoss) {
                    boss.paintSelf(gImage);
                }
                break;
            case 3:
                myFish.paintSelf(gImage);
                break;
            case 4:
                return;
            default:
                break;
        }
        g.drawImage(offScreenImage, 0, 0, null);
    }

    void reGame() {
        GameUtils.enemyList.clear();
        time = 0;
        myFish.level = 0;
        GameUtils.count = 0;
        myFish.x = 700;
        myFish.y = 500;
        myFish.width = 50;
        myFish.height = 50;
        boss = null;
        isBoss = false;
    }

    void logic() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(GameUtils.count < 5) {
            GameUtils.level = 0;
            myFish.level = 1;
        } else if (GameUtils.count <= 15) {
            GameUtils.level = 1;
        } else if (GameUtils.count <= 50) {
            GameUtils.level = 2;
            myFish.level = 2;
        }else if (GameUtils.count <= 150) {
            GameUtils.level = 3;
            myFish.level = 3;
        }else if (GameUtils.count <= 300) {
            GameUtils.level = 4;
            myFish.level = 3;
        } else {
            state = 3;
        }

        random = Math.random();


        switch (GameUtils.level) {
            case 4:
                if (time % 60 == 0) {
                    if (random > 0) {
                        boss = new Enemy_Boss();
                        isBoss = true;
                    }
                }
            case 3:
            case 2:
                random = Math.random();
                if (time % 30 == 0) {
                    if (random > 0.5) {
                        enemy = new Enemy_3_L();
                    } else {
                        enemy = new Enemy_3_R();
                    }
                    GameUtils.enemyList.add(enemy);
                }
            case 1:
                if (time % 20 == 0) {
                    random = Math.random();
                    if (random > 0.5) {
                        enemy = new Enemy_2_L();
                    } else {
                        enemy = new Enemy_2_R();
                    }
                    GameUtils.enemyList.add(enemy);
                }
            case 0:
                if (time % 10 == 0) {
                    random = Math.random();
                    if (random > 0.5) {
                        enemy = new Enemy_1_L();
                    } else {
                        enemy = new Enemy_1_R();
                    }
                    GameUtils.enemyList.add(enemy);
                }
                break;
            default:
                break;
        }


        for (Enemy e : GameUtils.enemyList) {
            e.x = e.x + e.dir * e.speed;

            if (isBoss) {
                if (boss.getRec().intersects(e.getRec())) {
                    e.x = -200;
                    e.y = -200;
                }
                if (boss.getRec().intersects(myFish.getRec())) {
                    state = 2;
                    myFish.x = -500;
                    myFish.y = -500;
                    se.play3();
                }
            }

            if (myFish.getRec().intersects(e.getRec())) {
                if (myFish.level >= e.type) {
                    e.x = -200;
                    e.y = -200;
                    if (state == 2) continue;
                    se.play1();
                    GameUtils.count += e.count;
                } else {
                    state = 2;
                    myFish.x = -500;
                    myFish.y = -500;
                    se.play3();
                }

            }
        }
    }
}
