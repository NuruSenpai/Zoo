package model;


import enums.*;

public class Animal {
    public String name;
    public int legsCount;
    public boolean predator;

    public Color color;
    public Area area;


    public Animal(String name, int legsCount, boolean predator, Color color, Area area) {
        this.name = name;
        this.legsCount = legsCount;
        this.predator = predator;
        this.color = color;
        this.area = area;

    }

    @Override
    public String toString() {
        return getType() + "," + name + "," + legsCount + "," + predator + "," + color + "," + area;
    }

    public String getType() {
        return "animal";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegsCount() {
        return legsCount;
    }

    public void setLegsCount(int legsCount) {
        this.legsCount = legsCount;
    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
