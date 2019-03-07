package PackageSerie4;

import java.awt.*;

public class Balle {

    private Rectangle rectangle;

    private Billard billard;

    private int deltaX, deltaY;
    private int indice;
    private int TAILLETABLEAUCOULEURLISTE = 10;

    private boolean aSupprimer = false;

    private Color couleur;


    public static  final Color[] COULEURLISTE = {Color.BLACK,Color.BLUE,Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.RED, Color.PINK, Color.ORANGE, Color.YELLOW, Color.LIGHT_GRAY};

    public Balle(Billard billard, int coordX, int coordY, int largeur, int hauteur )
    {
        this.billard = billard;
        this.rectangle = new Rectangle(coordX,coordY,largeur,hauteur);

        deltaY = 1;
        deltaX = 1;

        this.couleur = Balle.COULEURLISTE[0];


    }

    public void bouge()
    {
        rectangle.x += this.deltaX;
        rectangle.y += this.deltaY;

        for(Paroi p :  billard.getParoisVerticale())
        {
            if(p.collision(this))
            {
                deltaX = -deltaX;
                Billard.totalPoints += p.getPoints();
            }
        }

        for(Paroi p : billard.getParoisHorizontale())
        {
            if(p.collision(this)) {
                deltaY = -deltaY;
                Billard.totalPoints += p.getPoints();;

            }
        }

        for(Balle balle : billard.getListeBalles())
        {
            if(!this.equals(balle))
            {
                if(balle.collision(balle))
                {
                    if(balle.collision(this))
                    {
                        deltaX = -deltaX;
                        deltaY = -deltaY;
                    }
                }
            }
        }

        for(Piege piege : billard.getListePieges())
        {
            if(piege.disparition(this))
            {
                this.aSupprimer = true;
            }
        }

    }


    public void changeCouleur()
    {
        if(indice >= TAILLETABLEAUCOULEURLISTE)
        {
            indice = 0;
        }
        this.couleur = Balle.COULEURLISTE[indice];
        indice++;
    }


    public Rectangle getRectangle() {
        return rectangle;
    }

    public void dessine(Graphics g)
    {
        g.setColor(couleur);
        g.fillOval(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }

    public boolean besoinSupression()
    {
        return aSupprimer;
    }

    public boolean collision(Balle balle){
        return rectangle.intersects(balle.getRectangle());
    }

}
