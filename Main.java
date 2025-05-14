import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.Instant;
class Main extends JFrame{
    public Paddle b=new Paddle(true);
    public Paddle p=new Paddle(false);
    public Ball ball=new Ball();
    public Portal p1=new Portal();
    public Portal p2=new Portal();
    public int bs=0;
    public int ps=0;
    public boolean bw=false;
    public boolean pw=false;
    public static void main(String[]a){
        new Main();
    }
    private void reset(){
        ball=new Ball();
        p1=new Portal();
        p2=new Portal();
    }
    public Main(){
        setSize(1024,1024);
        setResizable(false);
        setLayout(new BorderLayout());
        //abreviate the variable name like a mature adult
        JButton butt=new JButton("Restart");
        Main t=this;
        butt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t.bs=0;
                t.ps=0;
                t.reset();
            }
        });
        add(butt,BorderLayout.NORTH);
        GraphicsEngine g=new GraphicsEngine(this);
        add(g);
        Listener l=new Listener();
        addKeyListener(l);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        for(;;){
            Instant s=Instant.now();
            if(this.bs>=10&&!this.pw)this.bw=true;
            else if(this.ps>=10&&!this.bw)this.pw=true;
            else{
                ball.move(this);
                l.move(this);
                if(ball.y>b.y&&b.y+b.w<1024-128)b.y+=2;
                else if(ball.y<b.y)b.y-=2;
                if(ball.x<0||ball.x>1024){
                    if(ball.x<0)this.ps++;
                    else if(ball.x>1024)this.bs++;
                    reset();
                }
                requestFocus();
                repaint();
                try{
                    Thread.sleep(1000/120-Instant.now().minusNanos(s.getNano()).getNano()/1000000);
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}