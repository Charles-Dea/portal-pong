import java.util.Random;
class Portal extends GameObject{
    public Portal(){
        Random r=new Random();
        this.x=r.nextInt(1024);
        this.y=r.nextInt(1024);
        this.w=64;
        this.h=64;
    }
}
