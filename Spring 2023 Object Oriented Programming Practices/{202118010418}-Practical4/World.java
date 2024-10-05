public class World {
    private String name;
    private Entity[] entities;
    private int numEntities;

    public World(String name) {
        this.name = name;
        entities = new Entity[10];
        numEntities = 0;
    }

    public String getName() {
        return name;
    }public void setName(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("#"+getName());
        System.out.println("#The number of the entities: "+numEntities);
        if(numEntities > 0) {
            for(int i = 0;i < numEntities;i++) {
                System.out.println("#Entity name: "+entities[i].getName()+", the position is ("+entities[i].getX()+","+entities[i].getY()+")");
            }
        }
    }

    public Entity getEntity(int position) {
        return entities[position];
    }
    public void addEntity(Entity entity) {
        if (numEntities <= 10) {
            entities[numEntities] = entity;//at end of array entities
            numEntities ++;//add an entity
        }else {
            System.out.print("Middle Earth has reached the maximum capacity!");
        }
    }

    public void deleteEntity(int position) {
        if(position < numEntities) {
            entities[position] = entities[position + 1];//copy down
            position ++;//for all array
        }
        numEntities --;
    }

    public int findEntity(String name) {
        int position = -1;
        for(int i = 0;i < numEntities;i++) {
            String nameEntity = entities[i].getName();
            if(nameEntity.equals(name)) {
                position = i;
            }
        }return position;
    }

    public void moveEntity(String name, int x, int y) {
        int n = 0;//know if the name is all not same
        for(int i = 0;i < numEntities;i++) {
            String nameEntity = entities[i].getName();
            if (nameEntity.equals(name)) {
                entities[i].setX(x);
                entities[i].setY(y);
                n++;
            }
        }if(n == 0) {
            System.out.print("The entity is not exist");
        }
    }
}
