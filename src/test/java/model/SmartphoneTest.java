package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    @Test
    void startRadio() {
        Smartphone phone=new Smartphone(new Contact[0],"Galaxy","Samsung");
        phone.startRadio();
        Assertions.assertTrue(!phone.isRadioIsOff());
    }

    @Test
    void stopRadio() {
        Smartphone phone=new Smartphone(new Contact[0],"Galaxy","Samsung");
        phone.startRadio();
        phone.stopRadio();
        Assertions.assertTrue(phone.isRadioIsOff());
    }

    @Test
    void addContact() {
        Friend[] friends={new Friend("Lilli","8089808"),
                new Friend("Simon","0986765"),
                new Friend("Root","76868")};
        Smartphone phone=new Smartphone(friends,"Galaxy","Samsung" );

        phone.addContact(new Friend("Newman","3435354646"));
        System.out.println(phone);

        Assertions.assertEquals((friends.length+1),phone.getContacts().length);
    }

    @Test
    void getContactByName() {
        Friend[] friends={new Friend("Lilli","8089808"),
                new Friend("Simon","0986765"),
                new Friend("Root","76868")};
        Smartphone phone=new Smartphone(friends,"Galaxy","Samsung" );
        Contact expected=friends[1];
        Contact actual=phone.getContactByName("Simon");
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void removeContactByName() {
        Friend[] friends={new Friend("Lilli","8089808"),
                new Friend("Simon","0986765"),
                new Friend("Root","76868")};
        Smartphone phone=new Smartphone(friends,"Galaxy","Samsung" );

        Assertions.assertTrue(phone.removeContactByName("Simon"));
        Assertions.assertEquals((friends.length-1),phone.getContacts().length);

    }
}