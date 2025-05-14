public class Paddle extends GameObject{
    public Paddle(boolean left){
        this.x=left?128:1024-128;
        this.y=512-64;
        this.w=16;
        this.h=128;
    }
}
