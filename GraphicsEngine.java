import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;
public class GraphicsEngine extends JPanel{
    private Main m;
    protected void paintComponent(Graphics gr){
        Graphics2D g=(Graphics2D)gr;
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1024,1024);
        g.setColor(Color.WHITE);
        if(m.bw){
            g.setFont(new Font(Font.MONOSPACED,Font.BOLD,128));
            g.drawString("YOU LOSE!",512-64*4-32,512-64);
        }else if(m.pw){
            g.setFont(new Font(Font.MONOSPACED,Font.BOLD,128));
            g.drawString("YOU CHEATED!",512-64*6,512-64);
        }else{
            g.fillRect(m.b.x,m.b.y,m.b.w,m.b.h);
            g.fillRect(m.p.x,m.p.y,m.p.w,m.p.h);
            g.fillRect(m.ball.x,m.ball.y,m.ball.w,m.ball.h);
            g.setFont(new Font(Font.MONOSPACED,Font.BOLD,48));
            g.drawString(Integer.toString(m.bs),48,48);
            g.drawString(Integer.toString(m.ps),1024-48,48);
            g.setColor(Color.BLUE);
            g.fillOval(m.p1.x,m.p1.y,m.p1.w,m.p1.h);
            g.fillOval(m.p2.x,m.p2.y,m.p2.w,m.p2.h);
        }
    }
    public GraphicsEngine(Main m){
        this.m=m;
    }
}
