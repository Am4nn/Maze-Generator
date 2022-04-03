import java.awt.*;
import java.util.HashSet;

public class Box {
    public HashSet<Character> arr;
    public boolean filled;
    Box() {
        arr = new HashSet<>();
    }
    public void addon(char direction){
        this.arr.add(direction);
    }
    public void draw(Graphics graphics, int x, int y, int unit, int RoadLen) {

        graphics.setColor(Color.BLACK);
        graphics.fillRect(x, y, unit, unit);

        graphics.setColor(Color.WHITE);
        if(arr.contains('w'))
            graphics.fillRect(x + RoadLen, y, RoadLen, RoadLen * 2);
        if(arr.contains('s'))
            graphics.fillRect(x + RoadLen, y + RoadLen, RoadLen, RoadLen * 2);
        if(arr.contains('a'))
            graphics.fillRect(x, y + RoadLen, RoadLen * 2, RoadLen);
        if(arr.contains('d'))
            graphics.fillRect(x + RoadLen, y + RoadLen, RoadLen * 2, RoadLen);
    }
}