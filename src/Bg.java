import java.awt.*;

public class Bg {
    void paintSelf(Graphics g, int fishLevel) {
        g.drawImage(GameUtils.bgimg, 0, 0, null);
        switch (GameWin.state) {
            case 0 -> GameUtils.drawWord(g, "请开始点击游戏", Color.RED, 80, 450, 500);
            case 1 -> {
                GameUtils.drawWord(g, "时间：" + GameWin.time / 18, Color.ORANGE, 50, 200, 220);
                GameUtils.drawWord(g, "积分：" + GameUtils.count, Color.ORANGE, 50, 200, 120);
                GameUtils.drawWord(g, "难度：" + GameUtils.level, Color.ORANGE, 50, 600, 120);
                GameUtils.drawWord(g, "等级：" + fishLevel, Color.ORANGE, 50, 1000, 120);
            }
            case 2 -> {
                GameUtils.drawWord(g, "积分：" + GameUtils.count, Color.ORANGE, 50, 200, 120);
                GameUtils.drawWord(g, "难度：" + GameUtils.level, Color.ORANGE, 50, 600, 120);
                GameUtils.drawWord(g, "等级：" + fishLevel, Color.ORANGE, 50, 1000, 120);
                GameUtils.drawWord(g, "失败", Color.RED, 80, 600, 500);
            }
            case 3 -> {
                GameUtils.drawWord(g, "积分：" + GameUtils.count, Color.ORANGE, 50, 200, 120);
                GameUtils.drawWord(g, "难度：" + GameUtils.level, Color.ORANGE, 50, 600, 120);
                GameUtils.drawWord(g, "等级：" + fishLevel, Color.ORANGE, 50, 1000, 120);
                GameUtils.drawWord(g, "胜利", Color.RED, 80, 700, 500);
            }
            default -> {}
        }
    }
}
