package PackageSerie4;

import javax.swing.*;
import java.awt.*;

public class Compteur extends JPanel {

    private Billard billard;
    private  static final String TITRE = "Nombre de points : ";


    public Compteur(Billard billard)
    {
        this.billard = billard;
        new ThreadComptagePoints(this).start();
    }

   @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawString(TITRE + Billard.totalPoints, 80, 90);
    }

}
