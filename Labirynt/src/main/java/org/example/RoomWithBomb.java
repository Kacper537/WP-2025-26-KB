package org.example;

import java.awt.*;

public class RoomWithBomb extends Room{
    private boolean isBomb;
    private boolean isDetonated;

    public RoomWithBomb(int nr, int x, int y){
        super(nr, x, y);
    }

    public RoomWithBomb(int nr, int x, int y, boolean isBomb){
        super(nr, x, y);
        this.isBomb = isBomb;
    }

    public void setBomb(boolean bomb){
        isBomb = bomb;
    }

    public void setDetonated(){
        if (isBomb) {
            detonate();
        }
    }

    public void detonate(){
        if (isBomb) {
            isDetonated = true;
            isBomb = false;
            MapSite[] sides = getSides();
            if (sides != null) {
                for (MapSite m : sides) {
                    if (m instanceof Wall) {
                        Wall w = (Wall) m;
                        w.setExploded(true);
                        System.out.println("Room " + getRoomNr() + " detonate -> mark wall: dir=" + w.getDirection() + " at ("+w.getX()+","+w.getY()+")");
                    }
                }
            }
        }
    }

    public boolean hasBomb(){
        return isBomb;
    }

    public boolean isDetonated(){
        return isDetonated;
    }

    public void draw(Image image) {
        super.draw(image);
        if (!isDetonated) {
            if (isBomb) {
                Graphics g = image.getGraphics();
                if (g != null) {
                    g.setColor(Color.BLACK);
                    g.drawString("B", getX() + MapSite.LENGTH / 2, getY() + MapSite.LENGTH / 2);
                }
            }
        } else {
            // detonated: walls were already marked exploded in detonate()
            // no additional filled markers inside room to avoid duplicate circles
        }
    }
}
