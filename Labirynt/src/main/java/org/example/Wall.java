package org.example;


import java.awt.*;

public class Wall extends MapSite {
    private boolean exploded = false;

    public Wall(Directions d) {
        super(0, 0);
        direction = d;
    }

    public void setDirection(Directions d){
            direction = d;
    }

    private Directions direction;

    public Directions getDirection(){
        return direction;
    }

    public void setExploded(boolean exploded) {
        this.exploded = exploded;
    }

    @Override
    public void draw(Image image) {
        super.draw(image);
        Graphics g = image.getGraphics();
        g.setColor(Color.BLUE);  // ustawiamy kolor
        switch (direction)
        {
            case South:
            case North: // linia pozioma
                g.drawLine(getX(), getY(), getX() + MapSite.LENGTH, getY());
                break;
            case East:
            case West:
                g.drawLine(getX(), getY(), getX(), getY() + MapSite.LENGTH);
                break;  // linia pionowa
            default:
                break;
        }
        if (exploded) {
            g.setColor(Color.RED);
            int d = 4; // smaller diameter
            int r = d / 2;
            switch (direction) {
                case North -> {
                    int x1 = getX() + MapSite.LENGTH/4 - r;
                    int x2 = getX() + MapSite.LENGTH/2 - r;
                    int x3 = getX() + 3 * MapSite.LENGTH/4 - r;
                    int y = getY() - r; // center on the north wall line
                    g.drawOval(x1, y, d, d);
                    g.drawOval(x2, y, d, d);
                    g.drawOval(x3, y, d, d);
                }
                case South -> {
                    int x1 = getX() + MapSite.LENGTH/4 - r;
                    int x2 = getX() + MapSite.LENGTH/2 - r;
                    int x3 = getX() + 3 * MapSite.LENGTH/4 - r;
                    int y = getY() + MapSite.LENGTH - r; // just below the south wall
                    g.drawOval(x1, y, d, d);
                    g.drawOval(x2, y, d, d);
                    g.drawOval(x3, y, d, d);
                }
                case East -> {
                    int y1 = getY() + MapSite.LENGTH/4 - r;
                    int y2 = getY() + MapSite.LENGTH/2 - r;
                    int y3 = getY() + 3 * MapSite.LENGTH/4 - r;
                    int x = getX() - r; // center on the east wall line
                    g.drawOval(x, y1, d, d);
                    g.drawOval(x, y2, d, d);
                    g.drawOval(x, y3, d, d);
                }
                case West -> {
                    int y1 = getY() + MapSite.LENGTH/4 - r;
                    int y2 = getY() + MapSite.LENGTH/2 - r;
                    int y3 = getY() + 3 * MapSite.LENGTH/4 - r;
                    int x = getX() - r; // center on the west wall line
                    g.drawOval(x, y1, d, d);
                    g.drawOval(x, y2, d, d);
                    g.drawOval(x, y3, d, d);
                }
                default -> {}
            }
        }
        // debug print removed


    }
}