import java.util.Random;

public class Direction{
    public Random x = new Random();
    public int Dx;
    public int Dy;
    public char dir;
    public char dirOpp;

    public void getRandom() {
        int n = x.nextInt(4);
        switch (n) {
            case 0 ->{
                Dx = -1;
                Dy = 0;
                dir = 'a';
                dirOpp = 'd';
            }
            case 1 ->{
                Dx = 1;
                Dy = 0;
                dir = 'd';
                dirOpp = 'a';
            }
            case 2 ->{
                Dx = 0;
                Dy = -1;
                dir = 'w';
                dirOpp = 's';
            }
            case 3 ->{
                Dx = 0;
                Dy = 1;
                dir = 's';
                dirOpp = 'w';
            }
        }
    }
}