import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleNuancier extends JPanel {
    private ModeleColor modele;

    public ControleNuancier(ModeleColor m) {
        super();
        this.setPreferredSize(new Dimension(100, 100));
        this.setLayout(new GridLayout(5, 5));
        modele = m;
        for (int i = 0; i < 25; i++) {
            JButton nuance = new JButton();
            nuance.setPreferredSize(new Dimension(20, 20));
            final int rouge = (int) (Math.random() * 255);
            final int vert = (int) (Math.random() * 255);
            final int bleu = (int) (Math.random() * 255);
            nuance.setBackground(new Color(rouge, vert, bleu));
            this.add(nuance);
            nuance.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    modele.setColor(rouge, vert, bleu);
                }
            });
        }
    }
}
