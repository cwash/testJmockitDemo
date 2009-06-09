package org.cwash.jmockitexample.pirate;

   
enum Drink {  RUM, BEER, COFFEE, SEAWATER } 
enum Flag { JOLLY_ROGER, UNION_JACK, STARS_AND_STRIPES } 

public class Pirate { 

    String name;

    public Pirate() { this.name = "A. Non Ymous"; }

    public Pirate(String name) { this.name = name; }

    public void setName(String name) { this.name = name; }

    public void say(String value) { 
      System.out.println(String.format("Pirate %s says \"%s\"", 
            this.name, value)); 
    }

    public void drink(Drink d) {
      System.out.println(String.format("Pirate %s drank %s",
            this.name, d.toString())); 
    }

    public void flyFlag(Flag f) {
      System.out.println(String.format("Pirate %s flew flag %s", 
          this.name, f.toString())); 
    } 

}
