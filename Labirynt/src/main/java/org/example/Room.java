package org.example;


import java.awt.*;

public class Room extends MapSite{
    private int nr;
    private MapSite[] sites = new MapSite[4];

    public Room (int nr, int x, int y){
        super(x,y);
        this.nr = nr;
    }

    public int getRoomNr() {
        return nr;
    }

    public void setSide(Directions d, MapSite mapSite){
        if (mapSite instanceof Wall){
            switch (d) {
                case North, West:
                    mapSite.setX(getX());
                    mapSite.setY(getY());
                    break;
                case East:
                    mapSite.setX(getX() + MapSite.LENGTH);
                    mapSite.setY(getY());
                    break;
                default:
                    mapSite.setX(getX());
                    mapSite.setY(getY()+MapSite.LENGTH);
            }
            ((Wall) mapSite).setDirection(d);
        }
        sites[d.ordinal()] = mapSite;
    }

    public int getNr(){
        return nr;
    }

    @Override
    public void draw(Image image){
        super.draw(image);
        for (MapSite mapSite: sites)
            if (mapSite != null)
                mapSite.draw(image);
    }
}
