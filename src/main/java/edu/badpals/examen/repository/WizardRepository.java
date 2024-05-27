package edu.badpals.examen.repository;

import edu.badpals.examen.domain.Wizard;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WizardRepository implements PanacheRepositoryBase<Wizard,String> {
}
