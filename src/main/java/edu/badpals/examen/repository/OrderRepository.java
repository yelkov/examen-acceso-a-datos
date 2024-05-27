package edu.badpals.examen.repository;

import edu.badpals.examen.domain.Order;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheRepositoryBase<Order,Long> {
}
