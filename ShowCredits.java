import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ShowCredits {
    public static final int size = 21;

    public ShowCredits() {
        JFrame frame = new JFrame("Credits");
        frame.setIconImage(new ImageIcon("./Assets/Icon.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int frameWidth = 400, frameHeight = 350;
        frame.setBounds((int) (tk.getScreenSize().getWidth() - frameWidth) / 2,
                (int) (tk.getScreenSize().getHeight() - frameHeight) / 2, frameWidth, frameHeight);
        frame.getContentPane().setBackground(Color.decode("#ecc19c"));
        frame.setResizable(false);
        frame.setLayout(null);
        String[] creators = { "Abhishek Gorai (031)", "Vivek Kumar (196)", "Biswanath Bhuyan (069)",
                "Manasi Das (203)" };
        JLabel label1 = new JLabel("Created by...");
        label1.setBounds(5, 2, 300, 100);
        label1.setFont(new Font("Consolas", Font.BOLD, 30));
        label1.setForeground(Color.decode("#210070"));
        frame.add(label1);
        JLabel label2 = new JLabel("1. " + creators[0]);
        label2.setForeground(Color.decode("#077b8a"));
        label2.setBounds(5, 75, 300, 75);
        label2.setFont(new Font("Cascadia Code", Font.ITALIC, size));
        label2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label2.setText("<html><u>1. " + creators[0] + "</u></html>");
                label2.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label2.setText("1. " + creators[0]);
                label2.setForeground(Color.decode("#077b8a"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Link.openURL("https://www.linkedin.com/in/abhishek-gorai-8643aa277/");
            }
        });
        frame.add(label2);
        JLabel label3 = new JLabel("2. " + creators[1]);
        label3.setForeground(Color.decode("#077b8a"));
        label3.setBounds(5, 125, 300, 75);
        label3.setFont(new Font("Cascadia Code", Font.ITALIC, size));
        label3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label3.setText("<html><u>2. " + creators[1] + "</u></html>");
                label3.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label3.setText("2. " + creators[1]);
                label3.setForeground(Color.decode("#077b8a"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Link.openURL(
                        "https://www.linkedin.com/in/vivek-kumar-94a224277?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app");
            }
        });
        frame.add(label3);
        JLabel label4 = new JLabel("3. " + creators[2]);
        label4.setForeground(Color.decode("#077b8a"));
        label4.setBounds(5, 175, 300, 75);
        label4.setFont(new Font("Cascadia Code", Font.ITALIC, size));
        label4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label4.setText("<html><u>3. " + creators[2] + "</u></html>");
                label4.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label4.setText("3. " + creators[2]);
                label4.setForeground(Color.decode("#077b8a"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Link.openURL("https://www.linkedin.com/in/biswanath-bhuyan");
            }
        });
        frame.add(label4);
        JLabel label5 = new JLabel("4. " + creators[3]);
        label5.setForeground(Color.decode("#077b8a"));
        label5.setBounds(5, 225, 300, 75);
        label5.setFont(new Font("Cascadia Code", Font.ITALIC, size));
        frame.add(label5);
        label5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label5.setText("<html><u>4. " + creators[3] + "</u></html>");
                label5.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label5.setText("4. " + creators[3]);
                label5.setForeground(Color.decode("#077b8a"));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Link.openURL("https://www.linkedin.com/in/mansi-dash123");
            }
        });
        frame.setVisible(true);
    }
}
