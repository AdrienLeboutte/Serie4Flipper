package PackageSerie4;

public class ThreadCouleur extends Thread {

    Billard billard;

    public ThreadCouleur(Billard billard)
    {
        super("ThreadCouleur");
        this.billard = billard;
    }

    public void run()
    {
        while(true)
        {
            try
            {
                for(Balle b : billard.getListeBalles())
                {
                    b.changeCouleur();
                }
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }




}
