import java.awt.*;
import java.util.*;
import java.util.List;

public class GameUtils {
    public static List<Enemy> enemyList = new ArrayList<>();
    public static Image bgimg = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\sea.jpg");
    public static Image enemy_l_img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\enemyFish\\fish1_L.png");
    public static Image enemy_r_img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\enemyFish\\fish1_R.png");
    public static Image enemy_l_2img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\enemyFish\\fish2_L.png");
    public static Image enemy_r_2img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\enemyFish\\fish2_R.png");
    public static Image enemy_l_3img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\enemyFish\\fish3_L.png");
    public static Image enemy_r_3img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\enemyFish\\fish3_R.png");
    public static Image boss_img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\enemyFish\\fish4_L.png");
    public static Image enemy_r_4img = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\enemyFish\\fish4_R.png");
    public static Image myFishImg_L = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\myFish\\fish_L.png");
    public static Image myFishImg_R = Toolkit.getDefaultToolkit().createImage("C:\\Users\\Admin\\IdeaProjects\\FishGame\\images\\myFish\\fish_R.png");

    public static String filePath1 = "C:\\Users\\Admin\\IdeaProjects\\FishGame\\sound\\effects\\action.wav";
    public static String filePath2 = "C:\\Users\\Admin\\IdeaProjects\\FishGame\\sound\\bgmusic\\bgmusic.wav";
    public static String filePath3 = "C:\\Users\\Admin\\IdeaProjects\\FishGame\\sound\\effects\\gameover.wav";

    static boolean UP = false;
    static boolean DOWN = false;
    static boolean LEFT = false;
    static boolean RIGHT = false;
    static int level = 0;

    static int count = 0;
    static {
        bgimg = bgimg.getScaledInstance(1440, 900, Image.SCALE_DEFAULT);
    }

    public static void drawWord(Graphics g, String str, Color color, int size, int x, int y) {
        g.setColor(color);
        g.setFont(new Font("黑体", Font.BOLD, size));
        g.drawString(str, x, y);
    }
}
