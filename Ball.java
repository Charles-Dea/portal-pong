import java.util.Random;
class Ball extends GameObject{
    private int dx,dy;
    private boolean t=false;
    public void move(Main m){
        this.x+=this.dx;
        this.y+=this.dy;
        bounce(m.p);
        bounce(m.b);
        if(this.y<=0){
            this.y=-this.y;
            this.dy=-this.dy;
        }else if(this.y+64>=1024){
            this.y=1024-(this.y+16-1024)-64;
            this.dy=-this.dy;
        }
        teleport(m.p1,m.p2);
        teleport(m.p2,m.p1);
    }
    private void bounce(GameObject g){
        if(this.x+this.w>=g.x&&this.x<=g.x+g.w&&this.y+this.h>=g.y&&this.y<=g.y+g.h){
            this.x=g.x-(this.x-g.x);
            this.dx=-this.dx;
            t=false;
        }
    }
    private void teleport(GameObject p1,GameObject p2){
        if(Math.sqrt(Math.pow(this.x+8-p1.x-p1.w/2,2)+Math.pow(this.y+8-p1.y-p1.h/2,2))<32&&!t){
            t=true;
            this.x=p2.x+p2.w;
            this.y=p2.y+p2.h;
        }
    }
    public Ball(){
        this.x=512-8;
        this.y=512-8;
        this.w=16;
        this.h=16;
        this.dx=new Random().nextInt(2)==1?-2:2;
        this.dy=new Random().nextInt(2)==1?-1:1;
    }
}