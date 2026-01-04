package org.example;

import java.awt.Image;
import java.util.ArrayList;

public class Maze {
    private ArrayList<Room> maze;
    public Maze(){
        maze = new ArrayList<>();
    }

    public int size(){
        return maze.size();
    }

    public Room getRoomAt(int index){
        if (index < maze.size()){
            return maze.get(index);
        }
        else{
            return null;
        }
    }

    public void addRoom(Room room){
        maze.add(room);
    }

    public Room getRoom(int nr){
        for (Room r: maze){
            if (r.getRoomNr() == nr)
                return r;
        }
        return null;
    }

    public void draw(Image image){
        for (Room r: maze){
            r.draw(image);
        }
    }

    public Room getRoomByCoordinates(int x, int y){
        for (Room r: maze){
            if (r.getX() == x && r.getY() == y) return r;
        }
        return null;
    }
}
