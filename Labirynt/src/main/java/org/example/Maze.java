package org.example;

import java.awt.Image;
import java.util.ArrayList;

public class Maze {
    private ArrayList<Room> maze;
    public Maze(){
        maze = new ArrayList<>();
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
}
