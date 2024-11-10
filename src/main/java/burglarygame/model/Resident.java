package burglarygame.model;

public class Resident extends Entity {

    private String currentLocation;
    private boolean hasFryingPan;

    public static final String BEDROOM = "bedroom";
    public static final String KITCHEN = "kitchen";
    public static final String OFFICE = "office";
    public static final String CLOAKROOM = "cloakroom";
    public static final String LIVING_ROOM = "living room";
    public static final String START = "start";

    public Resident(){
        super("Resident", 12, 3);
        this.currentLocation = START;
        this.hasFryingPan = false;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void pickupFryingPan(){
        if(!hasFryingPan){
            this.damage += 3;
            this.hasFryingPan = true;
            System.out.println(this.role + " has picked up the frying pan, with this you feel more capable in a fight!");
        } else {
            System.out.println("You already have the frying pan!");
        }


    }

    public boolean hasFryingPan() {
        return hasFryingPan;
    }

}
