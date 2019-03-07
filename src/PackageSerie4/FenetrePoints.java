package PackageSerie4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FenetrePoints extends JFrame {

    private Compteur compteur;

    private Billard billard;

    private Container conteneur;


    public FenetrePoints(Billard billard)
    {
        super("Compteur de Points");

        this.billard = billard;

        setBounds(1000, 100, 500, 250);

        this.compteur = new Compteur(this.billard);

        conteneur = this.getContentPane();

        conteneur.add(compteur);

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });




    }



}
