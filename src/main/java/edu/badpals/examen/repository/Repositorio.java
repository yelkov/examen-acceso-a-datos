package edu.badpals.examen.repository;

import com.fasterxml.classmate.Annotations;
import edu.badpals.examen.domain.Wizard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class Repositorio {

    @Inject
    WizardRepository wizardRepository;


    public Optional<Wizard> loadWizard(String wizard_name) {
        Optional<Wizard> wizard = wizardRepository.findByIdOptional(wizard_name);
        return wizard;
    }
}
