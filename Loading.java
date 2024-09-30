import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class Loading {
    JFrame frame;
    JProgressBar pb;
    Timer timer;
    JLabel title, label;
    JButton button;

    Loading() {
        frame = new JFrame("Snake & Ladder");
        int frameWidth = 500, frameHeight = 500;
        Toolkit tk = Toolkit.getDefaultToolkit();
        frame.setBounds((int) (tk.getScreenSize().getWidth() - frameWidth) / 2,
                (int) (tk.getScreenSize().getHeight() - frameHeight) / 2, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("./Assets/Icon.png").getImage());
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.decode("#ecc19c"));
        title = new JLabel("Snake & Ladder");
        title.setBounds(0, 0, frame.getWidth(), 100);
        title.setFont(new Font("Comic Sans MS", Font.ITALIC, 65));
        title.setForeground(Color.decode("#077b8a"));
        label = new JLabel();
        label.setBounds(0, 90, frame.getWidth(), 281);
        label.setIcon(new ImageIcon(
                new ImageIcon("./Assets/loading_screen.jpg").getImage().getScaledInstance(label.getWidth(),
                        label.getHeight(),
                        Image.SCALE_SMOOTH)));
        pb = new JProgressBar();
        pb.setBounds(5, 380, 475, 25);
        pb.setVisible(false);
        timer = new Timer(500, e -> {
            if (pb.getValue() == 100) {
                timer.stop();
                frame.dispose();
                new InitializeGame();
            }
            pb.setValue(pb.getValue() + 20);
        });
        button = new JButton("Start");
        button.setBounds(200, 410, 100, 50);
        button.setFocusable(false);
        button.setFont(new Font("Arial", Font.ITALIC, 20));
        button.setForeground(Color.decode("#cbf6db"));
        button.setBackground(Color.decode("#ed3572"));
        button.addActionListener(e -> {
            pb.setVisible(true);
            button.setEnabled(false);
            timer.start();
        });
        pb.setForeground(Color.decode("#1978a5"));
        pb.setBackground(Color.decode("#f57e7e"));
        frame.add(pb);
        frame.add(title);
        frame.add(label);
        frame.add(button);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
