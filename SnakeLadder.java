import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class SnakeLadder {
    public static final Color[] color = { Color.BLUE, Color.decode("#50C878"), Color.YELLOW, Color.decode("#800080") };
    public static final Icon[] diceFaces = new Icon[6];
    int chance;
    JFrame frame;
    JLabel lb;
    JLabel[][] labels = new JLabel[10][10];
    String[] arr = new String[101];
    int[] snakeStart, snakeEnd;
    int[] ladderStart, ladderEnd;
    Coins[] coins;
    Map<Integer, Integer> snakeMapStart, snakeMapEnd;
    Map<Integer, Integer> ladderMapStart, ladderMapEnd;
    private Timer timer;
    JButton dice;
    Color oddColor = Color.decode("#FFFDD0");
    Random random = new Random();
    Icon crown = new ImageIcon(
            new ImageIcon("./Assets/crown.png").getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH));

    public SnakeLadder(int players, String[] names) {
        for (int i = 0; i < 6; i++) {
            Image img = new ImageIcon("./Assets/DiceImages/" + (i + 1) + ".png").getImage();
            diceFaces[i] = new ImageIcon(img.getScaledInstance(45, 45, Image.SCALE_SMOOTH));
        }
        chance = 0;
        snakeStart = new int[] { 97, 95, 88, 63, 48, 36, 32 };
        snakeEnd = new int[] { 78, 56, 24, 18, 26, 6, 10 };
        snakeMapStart = new HashMap<>();
        snakeMapEnd = new HashMap<>();
        for (int i = 0; i < snakeStart.length; i++) {
            snakeMapStart.put(snakeStart[i], snakeEnd[i]);
            snakeMapEnd.put(snakeEnd[i], snakeStart[i]);
        }
        ladderStart = new int[] { 1, 4, 8, 21, 28, 50, 71, 80 };
        ladderEnd = new int[] { 38, 14, 30, 42, 76, 67, 92, 99 };
        ladderMapStart = new HashMap<>();
        ladderMapEnd = new HashMap<>();
        for (int i = 0; i < ladderStart.length; i++) {
            ladderMapStart.put(ladderStart[i], ladderEnd[i]);
            ladderMapEnd.put(ladderEnd[i], ladderStart[i]);
        }
        frame = new JFrame("Snake & Ladder");
        frame.setIconImage(new ImageIcon("./Assets/Icon.png").getImage());
        int frameWidth = 515, frameHeight = 700;
        Toolkit tk = Toolkit.getDefaultToolkit();
        frame.setBounds((int) (tk.getScreenSize().getWidth() - frameWidth) / 2,
                (int) (tk.getScreenSize().getHeight() - frameHeight) / 2, frameWidth, frameHeight);
        frame.getContentPane().setBackground(Color.decode("#ecc19c"));
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel[][] labels = new JLabel[10][10];
        int val = 100;
        for (int i = 9; i >= 0; i--) {
            for (int j = 9; j >= 0; j--) {
                if ((i & 1) == 1) {
                    arr[val] = "" + i + j;
                    labels[i][j] = new JLabel(String.format("%4d", val));
                    labels[i][j].setBounds((9 - j) * 50, (9 - i) * 50, 50, 50);
                    labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    labels[i][j].setFont(new Font("Comic Sans MS", Font.HANGING_BASELINE, 20));
                    labels[i][j].setOpaque(true);
                    if (val == 100)
                        labels[i][j].setIcon(crown);
                    if ((val & 1) == 1)
                        labels[i][j].setBackground(Color.YELLOW);
                    else
                        labels[i][j].setBackground(oddColor);
                    if (snakeMapStart.containsKey(val)) {
                        labels[i][j].setForeground(Color.RED);
                        addSnakeHover(labels[i][j], labels, snakeMapStart, val);
                    }
                    if (snakeMapEnd.containsKey(val)) {
                        labels[i][j].setForeground(Color.RED);
                        addSnakeHover(labels[i][j], labels, snakeMapEnd, val);
                    }
                    if (ladderMapStart.containsKey(val)) {
                        labels[i][j].setForeground(Color.BLUE);
                        addLadderHover(labels[i][j], labels, ladderMapStart, val);
                    }
                    if (ladderMapEnd.containsKey(val)) {
                        labels[i][j].setForeground(Color.BLUE);
                        addLadderHover(labels[i][j], labels, ladderMapEnd, val);
                    }
                    frame.add(labels[i][j]);
                    val--;
                } else {
                    arr[val] = "" + i + (9 - j);
                    labels[i][9 - j] = new JLabel(String.format("%4d", val));
                    labels[i][9 - j].setBounds(j * 50, (9 - i) * 50, 50, 50);
                    labels[i][9 - j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    labels[i][9 - j].setFont(new Font("Comic Sans MS", Font.HANGING_BASELINE, 20));
                    labels[i][9 - j].setOpaque(true);
                    if ((val & 1) == 1)
                        labels[i][9 - j].setBackground(Color.YELLOW);
                    else
                        labels[i][9 - j].setBackground(oddColor);
                    if (snakeMapStart.containsKey(val)) {
                        labels[i][9 - j].setForeground(Color.RED);
                        addSnakeHover(labels[i][9 - j], labels, snakeMapStart, val);
                    }
                    if (snakeMapEnd.containsKey(val)) {
                        labels[i][9 - j].setForeground(Color.RED);
                        addSnakeHover(labels[i][9 - j], labels, snakeMapEnd, val);
                    }
                    if (ladderMapStart.containsKey(val)) {
                        labels[i][9 - j].setForeground(Color.BLUE);
                        addLadderHover(labels[i][9 - j], labels, ladderMapStart, val);
                    }
                    if (ladderMapEnd.containsKey(val)) {
                        labels[i][9 - j].setForeground(Color.BLUE);
                        addLadderHover(labels[i][9 - j], labels, ladderMapEnd, val);
                    }
                    frame.add(labels[i][9 - j]);
                    val--;
                }
            }
        }
        String s = "Turn: " + names[0];
        lb = new JLabel(String.format("%16s", s));
        lb.setBounds(150, 510, 200, 50);
        lb.setFont(new Font("Arial", Font.ITALIC, 26));
        lb.setForeground(color[0]);
        lb.setBackground(Color.decode("#ecc19c"));
        lb.setOpaque(true);
        frame.add(lb);
        coins = new Coins[players];
        dice = new JButton("Roll");
        dice.setIcon(null);
        dice.setBounds(200, 600, 100, 50);
        dice.setHorizontalTextPosition(SwingConstants.CENTER);
        dice.setVerticalTextPosition(SwingConstants.CENTER);
        dice.setFocusable(false);
        dice.setForeground(Color.decode("#cbf6db"));
        dice.setBackground(Color.decode("#ed3572"));
        dice.setFont(new Font("Arial", Font.ITALIC, 24));
        dice.addActionListener(e -> move(labels, dice, players, names));
        timer = new Timer(1500, e -> {
            Icon ic = labels[9][9].getIcon();
            int z = 0;
            for (int i = 0; i < players; i++) {
                if (coins[i].icon.equals(ic)) {
                    z = i;
                    break;
                }
            }
            frame.dispose();
            new ShowWinner(names[z], color[z]);
            timer.stop();
        });
        frame.add(dice);
        frame.setVisible(true);
    }

    public void move(JLabel[][] labels, JButton dice, int players, String[] names) {
        if (dice.getText().equals("Roll")) {
            for (int i = 0; i < players; i++)
                coins[i] = new Coins(players);
        }
        int x = rollDice();
        dice.setIcon(diceFaces[x - 1]);
        dice.setText(" ");
        int k = move(labels, x, players, names);
        String s = "Turn: " + names[k];
        lb.setText(String.format("%16s", s));
    }

    public int move(JLabel[][] labels, int x, int players, String[] names) {
        if (!coins[chance].used) {
            coins[chance].used = true;
            coins[chance].col = 10 - x;
            int pos = Integer.valueOf(labels[0][coins[chance].col].getText().trim());
            if (ladderMapStart.containsKey(pos)) {
                int[] z = findRowCol(ladderMapStart.get(pos));
                coins[chance].row = z[0];
                coins[chance].col = z[1];
            }
            labels[coins[chance].row][coins[chance].col].setIcon(coins[chance].icon);
        } else {
            int r = coins[chance].row;
            int c = coins[chance].col;
            int nr = r, nc = 0;
            int pos;
            if ((r & 1) == 0) {
                pos = r * 10 + 10 - c;
                nc = c - x;
                if (nc < 0) {
                    nr = r + 1;
                    nc = Math.abs(nc) - 1;
                }
            } else {
                pos = r * 10 + c + 1;
                nc = c + x;
                if (nc > 9) {
                    nr = r + 1;
                    nc = 20 - nc - 1;
                }
            }
            if (nr != 10) {
                if ((pos & 1) == 1)
                    labels[r][c].setBackground(Color.YELLOW);
                if (snakeMapStart.containsKey(pos) || snakeMapEnd.containsKey(pos)) {
                    labels[r][c].setForeground(Color.RED);
                }
                if (ladderMapStart.containsKey(pos) || ladderMapEnd.containsKey(pos)) {
                    labels[r][c].setForeground(Color.BLUE);
                }
                int idx = 5;
                for (int i = 0; i < players; i++) {
                    if (i == chance)
                        continue;
                    if (coins[i].row == r && coins[i].col == c) {
                        idx = i;
                        break;
                    }
                }
                if (idx == 5) {
                    labels[r][c].setIcon(null);
                    labels[r][c].setFont(new Font("Comic Sans MS", Font.HANGING_BASELINE, 20));
                    labels[r][c].setText(String.format("%4d", pos));
                } else {
                    labels[r][c].setIcon(coins[idx].icon);
                }
                int curPos = Integer.valueOf(labels[nr][nc].getText().trim());
                if (snakeMapStart.containsKey(curPos)) {
                    int[] index = findRowCol(snakeMapStart.get(curPos));
                    nr = index[0];
                    nc = index[1];
                }
                if (ladderMapStart.containsKey(curPos)) {
                    int[] index = findRowCol(ladderMapStart.get(curPos));
                    nr = index[0];
                    nc = index[1];
                }
                labels[nr][nc].setIcon(coins[chance].icon);
                coins[chance].row = nr;
                coins[chance].col = nc;
                if (nr == 9 && nc == 9) {
                    dice.setEnabled(false);
                    timer.start();
                }
            }
        }
        if (x == 6)
            return chance;
        chance = (chance + 1) % players;
        lb.setForeground(color[chance]);
        return chance;
    }

    public int rollDice() {
        return random.nextInt(1, 7);
    }

    public void addSnakeHover(JLabel label, JLabel[][] labels, Map<Integer, Integer> map, int val) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                int[] x = findRowCol(map.get(val));
                label.setForeground(label.getBackground().equals(oddColor) ? oddColor : Color.YELLOW);
                label.setBackground(Color.RED);
                labels[x[0]][x[1]].setForeground(
                        labels[x[0]][x[1]].getBackground().equals(oddColor) ? oddColor : Color.YELLOW);
                labels[x[0]][x[1]].setBackground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                int[] x = findRowCol(map.get(val));
                label.setForeground(Color.RED);
                if ((val & 1) == 1)
                    label.setBackground(Color.YELLOW);
                else
                    label.setBackground(oddColor);
                labels[x[0]][x[1]].setForeground(Color.RED);
                int z = map.get(val);
                if ((z & 1) == 1)
                    labels[x[0]][x[1]].setBackground(Color.YELLOW);
                else
                    labels[x[0]][x[1]].setBackground(oddColor);
            }
        });
    }

    public void addLadderHover(JLabel label, JLabel[][] labels, Map<Integer, Integer> map, int val) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                int[] x = findRowCol(map.get(val));
                label.setForeground(label.getBackground().equals(oddColor) ? oddColor : Color.YELLOW);
                label.setBackground(Color.BLUE);
                labels[x[0]][x[1]].setForeground(
                        labels[x[0]][x[1]].getBackground().equals(oddColor) ? oddColor : Color.YELLOW);
                labels[x[0]][x[1]].setBackground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                int[] x = findRowCol(map.get(val));
                label.setForeground(Color.BLUE);
                if ((val & 1) == 1)
                    label.setBackground(Color.YELLOW);
                else
                    label.setBackground(oddColor);
                labels[x[0]][x[1]].setForeground(Color.BLUE);
                int z = map.get(val);
                if ((z & 1) == 1)
                    labels[x[0]][x[1]].setBackground(Color.YELLOW);
                else
                    labels[x[0]][x[1]].setBackground(oddColor);
            }
        });
    }

    public int[] findRowCol(int val) {
        int row = arr[val].charAt(0) - 48;
        int col = arr[val].charAt(1) - 48;
        return new int[] { row, col };
    }

    public static void main(String[] args) {
        String[] names = { "Abhishek", "Biswanath" };
        new SnakeLadder(2, names);
    }
}
