package PackageSerie4;

import java.awt.*;

public class Piege {

    private Rectangle rectangle;

    public Piege(int coordX, int coordY, int largeur, int hauteur)
    {
        this.rectangle = new Rectangle(coordX,coordY,largeur,hauteur);
    }

    public void dessine(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillOval(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }


    public boolean disparition(Balle balle)
    {
        return rectangle.intersects(balle.getRectangle());
    }




}
