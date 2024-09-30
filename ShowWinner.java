import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class ShowWinner {
    public ShowWinner(String name, Color c) {
        Image ic = null;
        if (c.equals(Color.BLUE))
            ic = new ImageIcon("./Assets/PlayerImages/Blue.png").getImage().getScaledInstance(100, 100,
                    Image.SCALE_SMOOTH);
        else if (c.equals(Color.decode("#50C878")))
            ic = new ImageIcon("./Assets/PlayerImages/Green.png").getImage().getScaledInstance(100, 100,
                    Image.SCALE_SMOOTH);
        else if (c.equals(Color.YELLOW))
            ic = new ImageIcon("./Assets/PlayerImages/Yellow.png").getImage().getScaledInstance(100, 100,
                    Image.SCALE_SMOOTH);
        else if (c.equals(Color.decode("#800080")))
            ic = new ImageIcon("./Assets/PlayerImages/Purple.png").getImage().getScaledInstance(100, 100,
                    Image.SCALE_SMOOTH);
        JFrame frame = new JFrame("Winner");
        frame.getContentPane().setBackground(Color.decode("#ecc19c"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        int frameWidth = 435, frameHeight = 400;
        Toolkit tk = Toolkit.getDefaultToolkit();
        frame.setBounds((int) (tk.getScreenSize().getWidth() - frameWidth) / 2,
                (int) (tk.getScreenSize().getHeight() - frameHeight) / 2, frameWidth, frameHeight);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("./Assets/Icon.png").getImage());
        JLabel l1 = new JLabel("Winner is: ");
        l1.setForeground(Color.decode("#077b8a"));
        l1.setBounds(20, 10, 300, 100);
        l1.setFont(new Font("Cascadia Code", Font.PLAIN, 30));
        JLabel l2 = new JLabel(name);
        l2.setBounds(225, 10, 300, 100);
        l2.setFont(new Font("Cascadia Code", Font.ITALIC, 30));
        l2.setForeground(c);
        JLabel l3 = new JLabel(new ImageIcon(ic));
        l3.setBounds(60, 93, 300, 150);
        JButton btn = new JButton("Play Again");
        btn.setFont(new Font("Arial", Font.ITALIC, 14));
        btn.setForeground(Color.decode("#cbf6db"));
        btn.setBackground(Color.decode("#ed3572"));
        btn.setBounds(157, 250, 110, 50);
        btn.setFocusable(false);
        btn.addActionListener(e -> {
            frame.dispose();
            new InitializeGame();
        });
        JButton btn2 = new JButton("See Credits");
        btn2.setFont(new Font("Arial", Font.ITALIC, 14));
        btn2.setForeground(Color.decode("#cbf6db"));
        btn2.setBackground(Color.decode("#ed3572"));
        btn2.setBounds(157, 310, 110, 35);
        btn2.setFocusable(false);
        btn2.addActionListener(e -> {
            frame.dispose();
            new ShowCredits();
        });
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(btn);
        frame.add(btn2);
        frame.setVisible(true);
    }
}
