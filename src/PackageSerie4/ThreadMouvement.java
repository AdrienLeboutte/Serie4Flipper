package PackageSerie4;

import java.util.Iterator;

public class ThreadMouvement extends Thread {

    private Billard billard;

    public ThreadMouvement(Billard billard) {
        super("ThreadMouvement");
        this.billard = billard;
    }

    public void run() {
        while (true) {
            try {
                for (Balle balle : billard.getListeBalles()) {
                    balle.bouge();
                }

                Iterator<Balle> iter = billard.getListeBalles().iterator();
                while(iter.hasNext()){
                    if(iter.next().besoinSupression()){
                        iter.remove();
                    }
                }
                billard.repaint();
                Thread.sleep(3);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (java.util.ConcurrentModificationException e){
                e.printStackTrace();
            }
        }


    }
}
