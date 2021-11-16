import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class ChoixCouleur extends JFrame {
    public static ModeleColor modele;

    public ChoixCouleur(final ModeleColor modelInitial) {
        if (modelInitial == null)
            this.modele = new ModeleColor(255, 255, 255);
        else
            this.modele = modelInitial;

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // sauvegarder la couleur actuelle dans le fichier .choixcouleur
                try {
                    FileOutputStream fos = new FileOutputStream(".choixcouleur");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(modele);
                    oos.close();
                    modele = null;
                } catch (Exception ex) {
                    System.out.println(" erreur output :" + ex.toString());
                }
            }
        });

        Box box = new Box(BoxLayout.Y_AXIS);
        ControleNuancier choix = new ControleNuancier(modele);
        box.add(choix);
        PanelColor panelColor = new PanelColor(modele.getColor());
        modele.addAutreEventListener(panelColor);
        box.add(panelColor);
        PanelRVB panelRVB = new PanelRVB(modele, modele.getColor());
        modele.addAutreEventListener(panelRVB);
        box.add(panelRVB);
        this.getContentPane().add(box);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                File fichierPersistant = new File(".choixcouleur");
                if (fichierPersistant.isFile()) {
                    // récupérer la dernière couleur dans le fichier .choixcouleur
                    try {
                        FileInputStream fis = new FileInputStream(".choixCouleur");
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        modele = (ModeleColor) ois.readObject();
                        ois.close();
                        new ChoixCouleur(modele);   //on lance avec le modele précédant

                    } catch (Exception ex) {
                        System.out.println(" erreur input :" + ex.toString());
                    }
                } else
                    new ChoixCouleur(null);
            }
        });
    }
}
