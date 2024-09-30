import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Coins {
	int row, col;
	Icon icon;
	static int i = 0;
	boolean used = false;
	public static final Image[] icons = { new ImageIcon("./Assets/PlayerImages/Blue.png").getImage(),
			new ImageIcon("./Assets/PlayerImages/Green.png")
					.getImage(),
			new ImageIcon("./Assets/PlayerImages/Yellow.png").getImage(),
			new ImageIcon("./Assets/PlayerImages/Purple.png").getImage() };

	public Coins(int players) {
		this.row = 0;
		this.col = 9;
		this.icon = new ImageIcon(icons[i++].getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		if (i == players)
			i = 0;
	}
}
