import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SetPlayers {
    public SetPlayers(int players) {
        JFrame frame = new JFrame("Snake & Ladder");
        frame.getContentPane().setBackground(Color.decode("#ecc19c"));
        int frameWidth = 400, frameHeight = players * 100 + (6 - players) * 25;
        Toolkit tk = Toolkit.getDefaultToolkit();
        frame.setBounds((int) (tk.getScreenSize().getWidth() - frameWidth) / 2,
                (int) (tk.getScreenSize().getHeight() - frameHeight) / 2, frameWidth, frameHeight);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("./Assets/Icon.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        JTextField[] tf = new JTextField[players];
        Image[] images = { new ImageIcon("./Assets/PlayerImages/Blue.png").getImage(),
                new ImageIcon("./Assets/PlayerImages/Green.png").getImage(),
                new ImageIcon("./Assets/PlayerImages/Yellow.png").getImage(),
                new ImageIcon("./Assets/PlayerImages/Purple.png").getImage() };
        JLabel label = new JLabel("Icon");
        label.setForeground(Color.decode("#077b8a"));
        label.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        label.setBounds(15, 0, 50, 45);
        frame.add(label);
        JLabel label1 = new JLabel("Name");
        label1.setBounds(175, 0, 100, 45);
        label1.setForeground(Color.decode("#077b8a"));
        label1.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));

        frame.add(label1);
        for (int i = 0; i < players; i++) {
            JLabel l = new JLabel(new ImageIcon(images[i].getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
            l.setBounds(10, 50 + 75 * i, 50, 50);
            tf[i] = new JTextField();
            tf[i].setBounds(100, 50 + 75 * i, 200, 50);
            tf[i].setFont(new Font("Cascadia Code", Font.LAYOUT_LEFT_TO_RIGHT, 24));
            tf[i].setForeground(Color.decode("#210070"));
            tf[i].setBackground(Color.decode("#ecc19c"));
            frame.add(l);
            frame.add(tf[i]);
        }
        String[] names = new String[players];
        JButton submit = new JButton("Play");
        submit.setBounds(150, frameHeight - 90, 100, 50);
        submit.setFocusable(false);
        submit.setForeground(Color.decode("#cbf6db"));
        submit.setBackground(Color.decode("#ed3572"));
        submit.setFont(new Font("Arial", Font.ITALIC, 20));
        submit.addActionListener(e -> {
            boolean flag = true;
            for (int i = 0; i < players; i++) {
                names[i] = tf[i].getText();
                if (names[i].isBlank())
                    flag = false;
            }
            if (flag) {
                frame.dispose();
                new SnakeLadder(players, names);
            }
        });
        frame.add(submit);
        frame.setVisible(true);
    }
}
