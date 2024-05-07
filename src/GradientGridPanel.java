import javax.swing.*;
import java.awt.*;

public class GradientGridPanel extends JPanel
{
    private int[][] myGrid = {{  0,  1,  4,  5,  8,  9, 12, 13, 16, 17, 20, 21, 24, 25, 28, 29},
                              {  2,  3,  6,  7, 10, 11, 14, 15, 18, 19, 22, 23, 26, 27, 30, 31},
                              { 61, 60, 57, 56, 53, 52, 49, 48, 45, 44, 41, 40, 37, 36, 33, 32},
                              { 63, 62, 59, 58, 55, 54, 51, 50, 47, 46, 43, 42, 39, 38, 35, 34},
                              { 64, 65, 68, 69, 72, 73, 76, 77, 80, 81, 84, 85, 88, 89, 92, 93},
                              { 66, 67, 70, 71, 74, 75, 78, 79, 82, 83, 86, 87, 90, 91, 94, 95},
                              {125,124,121,120,117,116,113,112,109,108,105,104,101,100, 97, 96},
                              {127,126,123,122,119,118,115,114,111,110,107,106,103,102, 99, 98},
                              {128,129,132,133,136,137,140,141,144,145,148,149,152,153,156,157},
                              {130,131,134,135,138,139,142,143,146,147,150,151,154,155,158,159},
                              {189,188,185,184,181,180,177,176,173,172,169,168,165,164,161,160},
                              {191,190,187,186,183,182,179,178,175,174,171,170,167,166,163,162},
                              {192,193,196,197,200,201,204,205,208,209,212,213,216,217,220,221},
                              {194,195,198,199,202,203,206,207,210,211,214,215,218,219,222,223},
                              {253,252,249,248,245,244,241,240,237,236,233,232,229,228,225,224},
                              {255,254,251,250,247,246,243,242,239,238,235,234,231,230,227,226}};
    private int mode;
    private Font mainFont;

    public GradientGridPanel()
    {
        super();
    }

    public void setMode(int m)
    {
        if (m>-1 && m<3)
        {
            System.out.println("Setting mode to " + m + "." );
            mode = m;
            recalculate();
            repaint();
        }
        else
            throw new RuntimeException("Set a mode that is out of bounds.");
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int squareSize = Math.min(getWidth(), getHeight())/16;
        mainFont = new Font("Garamond",Font.BOLD, squareSize/3);
        g.setFont(mainFont);
        for (int r = 0; r < myGrid.length; r++)
            for (int c = 0; c<myGrid[0].length; c++)
            {
                g.setColor(Color.getHSBColor(myGrid[r][c]/256.0f, 1.0f, 1.0f));
                g.fillRect(c*squareSize, r*squareSize, squareSize, squareSize);
                g.setColor(Color.GRAY);
                g.drawRect(c*squareSize, r*squareSize, squareSize, squareSize);
                int numWidth = g.getFontMetrics().stringWidth(STR."\{myGrid[r][c]}");
                g.setColor(Color.LIGHT_GRAY);
                g.drawString(""+myGrid[r][c], (int)((c+0.5)*squareSize-numWidth/2)+1,
                        (int)((r+0.5)*squareSize+squareSize/6)+1);
                g.setColor(Color.DARK_GRAY);
                g.drawString(""+myGrid[r][c], (int)((c+0.5)*squareSize-numWidth/2),
                        (int)((r+0.5)*squareSize+squareSize/6));

            }
    }

    public void recalculate()
    {
        // TODO: you write this.
        int counter = 0;
        switch(mode)
        {
            case 0:
                for (int r = 0; r < 16; r++)
                {
                    for (int c=0; c<16; c++)
                    {
                        myGrid[r][c] = counter;
                        counter++;
                    }
                }
                break;
        }
    }

    public boolean confirmGridMeetsSpecifications()
    {
        return false;
    }

}
