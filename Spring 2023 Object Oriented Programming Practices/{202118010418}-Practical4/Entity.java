public class Entity {
    private String name;
    private int x;
    private int y;

    public Entity(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println(name + " position (" + x + " , " + y + ")");
    }
    public void move(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public String getName() {
        return this.name;
    }public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }public void setY(int y) {
        this.y = y;
    }
}
