package model;
import enums.Color;
import enums.Area;
public class Penguin extends Animal {
    public Penguin(String name, int legsCount, boolean predator, Color color, Area area) {
        super(name, legsCount, predator, color, area);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getLegsCount() {
        return super.getLegsCount();
    }

    @Override
    public void setLegsCount(int legsCount) {
        super.setLegsCount(legsCount);
    }

    @Override
    public boolean isPredator() {
        return super.isPredator();
    }

    @Override
    public void setPredator(boolean predator) {
        super.setPredator(predator);
    }

    @Override
    public Color getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(Color color) {
        super.setColor(color);
    }

    @Override
    public Area getArea() {
        return super.getArea();
    }

    @Override
    public void setArea(Area area) {
        super.setArea(area);
    }

    @Override
    public String getType() {
        return "penguin";
    }
}
