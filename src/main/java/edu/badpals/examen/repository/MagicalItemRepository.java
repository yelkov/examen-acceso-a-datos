package edu.badpals.examen.repository;

import edu.badpals.examen.domain.MagicalItem;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MagicalItemRepository implements PanacheRepositoryBase<MagicalItem,Long> {
}
