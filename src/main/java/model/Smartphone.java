package model;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class Smartphone implements Radio, Gps{
    private static final String[] positions={"Lion","Berlin","Hildesheim","Brighton"};
    private boolean radioIsOff=true;
    private String position="unknown";
    private Contact[] contacts;
    private String modelName;
    private String manufacturer;

    public boolean isRadioIsOff() {
        return radioIsOff;
    }

    public void setRadioIsOff(boolean radioIsOff) {
        this.radioIsOff = radioIsOff;
    }

    public Smartphone(Contact[] contacts, String modelName, String manufacturer) {
        this.contacts = contacts;
        this.modelName = modelName;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "contacts=" + Arrays.toString(contacts) +
                ", modelName='" + modelName + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    public Smartphone() {
    }

    public Contact[] getContacts() {
        return contacts;
    }

    public void setContacts(Contact[] contacts) {
        this.contacts = contacts;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getPosition() {
        randomizePosition();
        return position;
    }

    private void randomizePosition() {
        position=positions[new Random().nextInt(positions.length)];
    }

    @Override
    public void startRadio() {
        radioIsOff=false;
        System.out.println("Radio is on");
    }

    @Override
    public void stopRadio() {
        radioIsOff=true;
        System.out.println("Radio is off");
    }

    public void addContact(Contact contact){
        contacts=Arrays.copyOf(contacts, (contacts.length+1));
        contacts[contacts.length-1]=contact;
    }
    public Contact getContact(int i){
        if(i<contacts.length&&i>0)return contacts[i];
        else return null;
    }

    public Contact getContactByName(String name){
        Optional<Contact> op=Arrays.stream(contacts).filter(a->a.getName().equals(name)).findFirst();
        return op.get();
    }

    public boolean removeContactByName(String name){
        int oldLen=contacts.length;
        contacts=Arrays.stream(contacts)
                .filter(a->!a.getName().equals(name))
                .toArray(arr -> new Contact[arr]);
        return oldLen>contacts.length;
    }
}
