package PackageSerie4;

public class ThreadComptagePoints extends Thread {


    private Compteur compteur;



    public ThreadComptagePoints(Compteur compteur)
    {
        super("ThreadComptagePoints");
        this.compteur = compteur;
    }

@Override
    public void run()
    {
        while(true)
        {
            try {
             compteur.repaint();
             Thread.sleep(100);

            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    }

}
