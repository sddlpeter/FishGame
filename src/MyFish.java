import java.awt.*;

public class MyFish {
    Image img = GameUtils.myFishImg_L;
    int x = 700;
    int y = 500;
    int width = 50;
    int height = 50;
    int speed = 20;
    int level = 1;

    public void paintSelf(Graphics g) {
        logic();
        g.drawImage(img, x, y, width + GameUtils.count, height + GameUtils.count, null);
    }
    void logic() {
        if (GameUtils.UP) {
            y = y - speed;
        }

        if (GameUtils.DOWN) {
            y = y + speed;
        }

        if (GameUtils.LEFT) {
            x = x - speed;
            img = GameUtils.myFishImg_L;
        }

        if (GameUtils.RIGHT) {
            x = x + speed;
            img = GameUtils.myFishImg_R;
        }


    }

    public Rectangle getRec() {
        return new Rectangle(x, y, width + GameUtils.count, height + GameUtils.count);
    }
}
