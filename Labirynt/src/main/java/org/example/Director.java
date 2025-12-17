package org.example;

public class Director {

    public void createMaze(MazeBuilder mazeBuilder) {
        int startX = 50;
        int startY = 100;
        int nr = 1;

        mazeBuilder.buildMaze();

        // Tworzenie pokoi tak jak w manualnym przykładzie
        mazeBuilder.buildRoom(startX, startY, nr++);
        mazeBuilder.buildRoom(startX, startY + MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX, startY + 2 * MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX + MapSite.LENGTH, startY + MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX + 2 * MapSite.LENGTH, startY, nr++);
        mazeBuilder.buildRoom(startX + 2 * MapSite.LENGTH, startY + MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX + 2 * MapSite.LENGTH, startY + 2 * MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX + 3 * MapSite.LENGTH, startY + MapSite.LENGTH, nr++);

        // Tworzenie drzwi
        mazeBuilder.buildDoor(1, 2);
        mazeBuilder.buildDoor(2, 3);
        mazeBuilder.buildDoor(2, 4);
        mazeBuilder.buildDoor(4, 6);
        mazeBuilder.buildDoor(6, 5);
        mazeBuilder.buildDoor(6, 7);
        mazeBuilder.buildDoor(6, 8);
    }

    public void createMazeWithOffset(MazeBuilder mazeBuilder, int offsetX) {
        int startX = 50 + offsetX;
        int startY = 100;
        int nr = 1;

        mazeBuilder.buildMaze();

        mazeBuilder.buildRoom(startX, startY, nr++);
        mazeBuilder.buildRoom(startX, startY + MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX, startY + 2 * MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX + MapSite.LENGTH, startY + MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX + 2 * MapSite.LENGTH, startY, nr++);
        mazeBuilder.buildRoom(startX + 2 * MapSite.LENGTH, startY + MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX + 2 * MapSite.LENGTH, startY + 2 * MapSite.LENGTH, nr++);
        mazeBuilder.buildRoom(startX + 3 * MapSite.LENGTH, startY + MapSite.LENGTH, nr++);

        mazeBuilder.buildDoor(1, 2);
        mazeBuilder.buildDoor(2, 3);
        mazeBuilder.buildDoor(2, 4);
        mazeBuilder.buildDoor(4, 6);
        mazeBuilder.buildDoor(6, 5);
        mazeBuilder.buildDoor(6, 7);
        mazeBuilder.buildDoor(6, 8);
    }
}
