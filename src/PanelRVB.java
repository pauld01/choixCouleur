import autrevent.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelRVB extends JPanel implements AutreEventListener {
    private JTextField fieldR, fieldV, fieldB;

    public PanelRVB(ModeleColor m, Color couleur) {
        super(new GridLayout(3, 2));
        fieldR = new JTextField(3);
        fieldR.setEditable(true);
        fieldR.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int r = Integer.parseInt(fieldR.getText());
                    int v = Integer.parseInt(fieldV.getText());
                    int b = Integer.parseInt(fieldB.getText());

                    m.setColor(r, v, b);
                }
            }
        });

        fieldV = new JTextField(3);
        fieldV.setEditable(true);
        fieldV.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int r = Integer.parseInt(fieldR.getText());
                    int v = Integer.parseInt(fieldV.getText());
                    int b = Integer.parseInt(fieldB.getText());

                    m.setColor(r, v, b);
                }
            }
        });

        fieldB = new JTextField(3);
        fieldB.setEditable(true);
        fieldB.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int r = Integer.parseInt(fieldR.getText());
                    int v = Integer.parseInt(fieldV.getText());
                    int b = Integer.parseInt(fieldB.getText());

                    m.setColor(r, v, b);
                }
            }
        });
        this.add(new JLabel("R = "));
        this.add(fieldR);
        this.add(new JLabel("V = "));
        this.add(fieldV);
        this.add(new JLabel("B = "));
        this.add(fieldB);
        fieldR.setText("" + couleur.getRed());
        fieldV.setText("" + couleur.getGreen());
        fieldB.setText("" + couleur.getBlue());
    }

    public void actionADeclancher(AutreEvent autreEvent) {
        if (autreEvent.getDonnee() instanceof Color) {
            Color couleur = (Color) autreEvent.getDonnee();
            fieldR.setText("" + couleur.getRed());
            fieldV.setText("" + couleur.getGreen());
            fieldB.setText("" + couleur.getBlue());
        }
    }
}
