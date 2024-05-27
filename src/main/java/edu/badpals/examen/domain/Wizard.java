package edu.badpals.examen.domain;

import jakarta.persistence.*;

@Entity
@Table(name="t_wizards")
public class Wizard {
    public Wizard() {
    }

    public Wizard(String name, int dexterity, Person person) {
        this.name = name;
        this.dexterity = dexterity;
        this.person = person;
    }

    @Id
    @Column(name="wizard_name")
    private String name = "";

    @Column(name="wizard_dexterity")
    private int dexterity = 0;

    @Column(name="wizard_person")
    @Enumerated(EnumType.STRING)
    private Person person;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "name='" + getName() + '\'' +
                ", dexterity=" + getDexterity() +
                ", person=" + getPerson() +
                '}';
    }
}
