import autrevent.*;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ModeleColor implements Serializable {
    private int rouge, vert, bleu;
    private transient AutreEventNotifieur notifieur = new AutreEventNotifieur(); //transient pour ne pas le mettre dans le fichier

    public ModeleColor(int r, int v, int b) {
        rouge = r;
        vert = v;
        bleu = b;
    }

    public Color getColor() {
        return new Color(rouge, vert, bleu);
    }

    public void setColor(int r, int v, int b) {
        if ((r >= 0) && (r <= 255) && (v >= 0) && (v <= 255) && (b >= 0)
                && (b <= 255)) {
            rouge = r;
            vert = v;
            bleu = b;
            this.notifieur.diffuserAutreEvent(new AutreEvent(this, new Color(rouge, vert, bleu)));
        }
    }

    public void addAutreEventListener(AutreEventListener listener) {
        notifieur.addAutreEventListener(listener);
    }

    /**
     * Méthode qui permet d'instancier l'objet qui est transient
     */
    private void readObject(ObjectInputStream flotIn) throws IOException, ClassNotFoundException {
        flotIn.defaultReadObject();
        notifieur = new AutreEventNotifieur();
    }
}
