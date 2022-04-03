import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Panel extends JPanel implements ActionListener {

    public Timer timer;
    public Random random;
    public int Width;
    public int Height;
    public int unit = 12;
    public int x, y;
    public int RoadLen = 4;
    public final Box[][] box;

    Panel(int w, int h) {

        this.Width = w;
        this.Height = h;

        this.setPreferredSize(new Dimension( Width * unit, Height * unit));

        box = new Box[Width][Height];
        InitiateBox();

        random = new Random();
        x = random.nextInt(Width);
        y = random.nextInt(Height);
        box[x][y].filled = true;

        timer = new Timer(1, this);

        timer.start();
//        DoInstantly();
    }

    public void InitiateBox() {
        for (int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                box[i][j] = new Box();
                box[i][j].filled = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CreateMaze();
        if (Completed()) {
            timer.stop();
        }
    }

    public void DoInstantly() {
        while (!Completed()) {
            CreateMaze();
        }
    }

    public void CreateMaze() {
        Direction d = this.getDirection();
        if (!box[x + d.Dx][y + d.Dy].filled) {
            box[x][y].addon(d.dir);
            box[x + d.Dx][y + d.Dy].addon(d.dirOpp);
        }
        x += d.Dx;
        y += d.Dy;
        box[x][y].filled = true;
    }

    public Direction getDirection() {
        Direction d = new Direction();
        d.getRandom();
        while (!(x + d.Dx >= 0 && y + d.Dy >= 0 && x + d.Dx < Width && y + d.Dy < Height)) {
            d.getRandom();
        }
        return d;
    }

    public boolean Completed() {
        for (int i = 0; i < Width; i++)
            for (int j = 0; j < Height; j++)
                if (!box[i][j].filled)
                    return false;
        return true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < Width; i++) {
            for (int j = 0; j < Height; j++) {
                box[i][j].draw(g,i * unit, j * unit, unit, RoadLen);
            }
        }

        g.setColor(Color.GREEN);
        g.drawRect(x*unit, y*unit, unit, unit);
        super.repaint();
    }
}