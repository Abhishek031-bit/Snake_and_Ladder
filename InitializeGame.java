import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class InitializeGame {
    JFrame frame;
    JLabel label;
    JButton button;
    int players;

    public InitializeGame() {
        players = 0;
        frame = new JFrame("Snake & Ladder");
        int frameWidth = 400, frameHeight = 300;
        Toolkit tk = Toolkit.getDefaultToolkit();
        frame.setBounds((int) (tk.getScreenSize().getWidth() - frameWidth) / 2,
                (int) (tk.getScreenSize().getHeight() - frameHeight) / 2, frameWidth, frameHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#ecc19c"));
        String font = "Arial";
        frame.setIconImage(new ImageIcon("./Assets/Icon.png").getImage());
        label = new JLabel("Enter number of players:");
        label.setFont(new Font("Comic Sans MS", Font.ITALIC, 26));
        label.setBounds(30, 3, 390, 100);
        label.setForeground(Color.decode("#077b8a"));
        JRadioButton b2 = new JRadioButton("2");
        b2.setFont(new Font(font, Font.BOLD, 20));
        b2.setFocusable(false);
        b2.setBounds(175, 75, 100, 40);
        b2.setForeground(Color.decode("#f37735"));
        b2.setBackground(Color.decode("#ecc19c"));
        JRadioButton b3 = new JRadioButton("3");
        b3.setBounds(175, 115, 100, 40);
        b3.setFont(new Font(font, Font.BOLD, 20));
        b3.setFocusable(false);
        b3.setForeground(Color.decode("#f37735"));
        b3.setBackground(Color.decode("#ecc19c"));
        JRadioButton b4 = new JRadioButton("4");
        b4.setFont(new Font(font, Font.BOLD, 20));
        b4.setBounds(175, 155, 100, 40);
        b4.setFocusable(false);
        b4.setForeground(Color.decode("#f37735"));
        b4.setBackground(Color.decode("#ecc19c"));
        ButtonGroup bg = new ButtonGroup();
        bg.add(b2);
        bg.add(b3);
        bg.add(b4);
        JButton btn = new JButton("Next");
        btn.setBounds(140, 200, 100, 50);
        btn.setFont(new Font("Arial", Font.ITALIC, 20));
        btn.setForeground(Color.decode("#cbf6db"));
        btn.setBackground(Color.decode("#ed3572"));
        btn.setFocusable(false);
        btn.addActionListener(e -> {
            if (b2.isSelected())
                players = 2;
            else if (b3.isSelected())
                players = 3;
            else if (b4.isSelected())
                players = 4;
            if (players != 0) {
                frame.dispose();
                new SetPlayers(players);
            }
        });
        frame.add(label);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
        frame.add(btn);
        frame.setVisible(true);
    }
}
