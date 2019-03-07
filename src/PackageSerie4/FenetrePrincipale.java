package PackageSerie4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FenetrePrincipale extends JFrame {

    private Billard billard;

    private Container conteneur;

    private JPanel panneauBouton;

    private JButton boutonStart;

    public FenetrePrincipale() {
        super("Billard");

        setBounds(10, 10, 1000, 1000);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        billard = new Billard();
        billard.setBounds(0,0,1000,699);

        conteneur = this.getContentPane();

        conteneur.setLayout(null);
      //  conteneur.add(billard);



        panneauBouton = new JPanel();
        boutonStart = new JButton("START");
        boutonStart.addActionListener(new StartButtonListner());


        panneauBouton.add(boutonStart);
        panneauBouton.setBounds(450,700,75,30);

        conteneur.add(billard);
        conteneur.add(panneauBouton);


        setVisible(true);


        new FenetrePoints(billard);


    }



    private class StartButtonListner implements ActionListener {

        @Override
        public synchronized void actionPerformed(ActionEvent ae) {
            billard.getListeBalles().add(new Balle(billard, 150, 150, 15, 15));
        }

    }
}
