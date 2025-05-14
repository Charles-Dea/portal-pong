import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
class Listener implements KeyListener{
    private boolean jd,kd;
    public void move(Main m){
        if(jd&&m.p.y+m.p.w<1024-120)m.p.y+=2;
        if(kd&&m.p.y>0)m.p.y-=2;
    }
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_J)jd=true;
        else if(e.getKeyCode()==KeyEvent.VK_K)kd=true;
    }
    public void keyReleased(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_J)jd=false;
        else if(e.getKeyCode()==KeyEvent.VK_K)kd=false;
    }
    public Listener(){}
    public void keyTyped(KeyEvent e){}
}
