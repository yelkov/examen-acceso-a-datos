package edu.badpals.examen.repository;

import com.fasterxml.classmate.Annotations;
import edu.badpals.examen.domain.MagicalItem;
import edu.badpals.examen.domain.Wizard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.locationtech.jts.index.hprtree.Item;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class Repositorio {

    @Inject
    WizardRepository wizardRepository;

    @Inject
    MagicalItemRepository magicalItemRepository;


    public Optional<Wizard> loadWizard(String wizard_name) {
        Optional<Wizard> wizard = wizardRepository.findByIdOptional(wizard_name);
        return wizard;
    }

    public Optional<MagicalItem> loadItem(String item_name) {
        List<MagicalItem> itemList = magicalItemRepository.listAll();

        Optional<MagicalItem> magicalItem = itemList.stream()
                .filter(i -> i.getName().equals(item_name))
                .findFirst();
        return magicalItem;

    }
}
