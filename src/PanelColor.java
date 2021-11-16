import autrevent.*;

import javax.swing.*;
import java.awt.*;

public class PanelColor extends JPanel implements AutreEventListener {
    private Color couleur;

    public PanelColor(Color c) {
        super();
        this.setPreferredSize(new Dimension(100, 100));
        couleur = c;
        this.setBackground(couleur);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
    }

    public void actionADeclancher(AutreEvent autreEvent) {
        if (autreEvent.getDonnee() instanceof Color) {
            couleur = (Color) autreEvent.getDonnee();
            setBackground(couleur);
            this.repaint();
        }
    }
}
