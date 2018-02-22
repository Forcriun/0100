import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simula el numero de bolas indicadas por parametro. Tamaño y color aleatorios. La posicion
     * de inicio es aleatoria dentro del cuadrante superior izquierdo.
     */
    public void bounce(int bolas)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        ArrayList<BouncingBall> listaBolas = new ArrayList<>();
        Random aleatorio = new Random();

        // lista las bolas con caracteristicas aleatorias
        for(int i=0;i<bolas;i++){
            Color color = new Color(aleatorio.nextInt(256),aleatorio.nextInt(256),aleatorio.nextInt(256));
            listaBolas.add(new BouncingBall(aleatorio.nextInt(301), aleatorio.nextInt(251), aleatorio.nextInt(31)+10, color, ground, myCanvas));
        }

        // hace que se muevan
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(BouncingBall bola : listaBolas){
                bola.move();
                // para en cuanto una de las bolas sobrepasa el limite
                if(bola.getXPosition() >= 550) {
                    finished = true;
                }
            }
        }
    }
}
