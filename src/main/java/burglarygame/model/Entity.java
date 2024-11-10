package burglarygame.model;

public abstract class Entity {

    protected String role;
    protected int health;
    protected int damage;

    public Entity(String role, int health, int damage) {
        this.role = role;
        this.health = health;
        this.damage = damage;

    }

    public String getRole() {
        return role;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) this.health = 0;
    }

    public void punch(Entity defender) {
        System.out.println(this.role + " attacks " + defender.getRole() + "!");

        defender.takeDamage(this.damage);

        System.out.println(defender.getRole() + " took " + this.damage + " damage");

        if (defender.isConscious()) {
            System.out.println(defender.getRole() + " has " + defender.getHealth() + " health remaining!");
        } else {
            System.out.println(defender.getRole() + " has passed out!");
        }
    }

    public boolean isConscious() {

        return this.health > 0;
    }

    public int getHealth() {

        return health;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

}