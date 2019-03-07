package PackageSerie4;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Billard extends JPanel {

   private ArrayList<Paroi> arrayVerticale = new ArrayList<>();
   private ArrayList<Paroi> arrayHorizontale = new ArrayList<>();
   private ArrayList<Balle> arrayBalle = new ArrayList<>();
   private ArrayList<Piege> arrayPiege = new ArrayList<>();

   private  List<Paroi> paroisVerticale = Collections.synchronizedList(arrayVerticale);
   private  List<Paroi> paroisHorizontale = Collections.synchronizedList(arrayHorizontale);
   private List<Balle> listeBalles = Collections.synchronizedList(arrayBalle);
   private List<Piege> listePieges = Collections.synchronizedList(arrayPiege);


   public static int totalPoints ;

    public Billard()
    {
        paroisVerticale.add(new Paroi(100,50,2,600,0));
        paroisVerticale.add(new Paroi(300,50,2,150,0));
        paroisVerticale.add(new Paroi(650,500,2,150,0));
        paroisVerticale.add(new Paroi(950,50,2,600,0));


        paroisHorizontale.add(new Paroi(100,50,850,2,1));
        paroisHorizontale.add(new Paroi(100,650,850,2,1));

        listeBalles.add(new Balle(this,150,150,200,200));

        listePieges.add(new Piege(700,500,40,40));


        new ThreadMouvement(this).start();
        new ThreadCouleur(this).start();


    }

@Override
    public void paint(Graphics g)
    {
        super.paint(g);

        for(Paroi p : paroisHorizontale)// parcours la liste
        {
            p.dessine(g);
        }

        for(Paroi p : paroisVerticale) // parcours la liste
        {
            p.dessine(g);
        }

        for(Balle b : listeBalles)
        {
            b.dessine(g);
        }
        for(Piege p : listePieges)
        {
            p.dessine(g);
        }

    }

    public List<Piege> getListePieges() {
        return listePieges;
    }

    public List<Balle> getListeBalles() {
        return listeBalles;
    }


    public List<Paroi> getParoisVerticale() {
        return paroisVerticale;
    }

    public List<Paroi> getParoisHorizontale() {
        return paroisHorizontale;
    }


}
