package org.cwash.jmockitexample.pirate;

import static mockit.Mockit.setUpMock;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.either;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class PirateShipAttackProtocolTest {

  @Test
  public void captain_follows_protocol_when_attacking_nearest_vessel() {


    /* approach to create a FAKE implementation with asserts inside */ 
    setUpMock(Pirate.class, new Object() {

      @Mock(minInvocations = 1)
      public void say(String speech) {
        assertThat(speech, either(
              is("Yo Ho Ho!")).or(
              is("Yarg!")).or(
              is("Shiver Me Timbers!"))
        );
      }

      @Mock(minInvocations = 1)
      public void drink(Drink sip) {
        assertThat(sip, is(Drink.RUM));
      }

      @Mock(minInvocations = 1)
      public void flyFlag(Flag pirateFlag) {
        assertThat(pirateFlag, is(Flag.JOLLY_ROGER));
      }

    });  


    PirateShip ship = new PirateShip();
    ship.attackNearestVessel();

  }

}
