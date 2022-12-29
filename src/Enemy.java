import jdk.jfr.Enabled;

import java.awt.*;

public class Enemy {
    Image img;
    int x;
    int y;
    int width;
    int height;

    int speed;
    int dir;
    int type;
    int count;

    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, width, height, null);
    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}


class Enemy_1_L extends Enemy {
    Enemy_1_L() {
        this.x = -45;
        this.y = (int) (Math.random() * 700 + 100);
        this.width = 45;
        this.height = 69;
        this.speed = 10;
        this.count = 1;
        this.type = 1;
        this.img = GameUtils.enemy_l_img;
        this.dir = 1;
    }
}

class Enemy_1_R extends Enemy_1_L {
    Enemy_1_R() {
        this.x = 1400;
        this.dir = -1;
        this.img = GameUtils.enemy_r_img;
    }
}

class Enemy_2_L extends Enemy {
    Enemy_2_L() {
        this.x = -100;
        this.y = (int) (Math.random() * 700 + 100);
        this.width = 100;
        this.height = 100;
        this.speed = 5;
        this.count = 3;
        this.type = 2;
        this.img = GameUtils.enemy_l_2img;
    }
}

class Enemy_2_R extends Enemy_2_L {
    Enemy_2_R() {
        this.x = 1400;
        this.dir = -1;
        this.img = GameUtils.enemy_r_2img;
    }
}

class Enemy_3_L extends Enemy {
    Enemy_3_L() {
        this.x = -300;
        this.y = (int) (Math.random() * 700 + 100);
        this.width = 300;
        this.height = 150;
        this.speed = 15;
        this.count = 5;
        this.type = 5;
        this.img = GameUtils.enemy_l_3img;
    }

    public Rectangle getRec() {
        return new Rectangle(x + 40, y + 30, width - 80, height - 60);
    }
}

class Enemy_3_R extends  Enemy_3_L {
    Enemy_3_R() {
        this.x = 1400;
        this.dir = -1;
        this.img = GameUtils.enemy_r_3img;
    }
}

class Enemy_Boss extends Enemy {
    Enemy_Boss() {
        this.x = -1000;
        this.y = (int) (Math.random() * 700 + 100);
        this.width = 340;
        this.height = 340;
        this.speed = 100;
        this.count = 0;
        this.type = 10;
        this.dir = 1;
        this.img = GameUtils.boss_img;
    }
}