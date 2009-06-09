package org.cwash.jmockitexample.pirate;

public class PirateShip {
  
  private Pirate captain;

  public PirateShip() {
    this.captain = new Pirate();
  }

  public PirateShip(String captainName) {
    this.captain = new Pirate(captainName);
  }

  public void attackNearestVessel() {
    captain.say("Yarg!");
    captain.drink(Drink.RUM);
    captain.flyFlag(Flag.JOLLY_ROGER);
    // attack vessel
  }
}
