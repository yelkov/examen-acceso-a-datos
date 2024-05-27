package edu.badpals.examen.domain;

import jakarta.persistence.*;

@Entity
@Table(name="t_orders")
public class Order {

    public Order() {
    }

    public Order(Wizard wizard, MagicalItem item) {
        this.wizard = wizard;
        this.item = item;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ord_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ord_wizard")
    private Wizard wizard;

    @ManyToOne
    @JoinColumn(name="ord_item")
    private MagicalItem item;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public MagicalItem getItem() {
        return item;
    }

    public void setItem(MagicalItem item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Order{" +
                "wizard=" + getWizard().toString() +
                ", item=" + getItem().toString() +
                '}';
    }
}
