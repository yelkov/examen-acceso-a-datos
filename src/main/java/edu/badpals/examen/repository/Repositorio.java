package edu.badpals.examen.repository;

import com.fasterxml.classmate.Annotations;
import edu.badpals.examen.domain.MagicalItem;
import edu.badpals.examen.domain.Wizard;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.locationtech.jts.index.hprtree.Item;

import java.util.ArrayList;
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

    public Optional<MagicalItem> loadItem(MagicalItem item){
        List<MagicalItem> itemList = magicalItemRepository.listAll();

        Optional<MagicalItem> magicalItem = itemList.stream()
                .filter(i -> i.getName().equals(item.getName()))
                .filter(i -> i.getType().equals(item.getType()))
                .filter(i ->i.getQuality() == item.getQuality())
                .findFirst();
        return magicalItem;
    }

    public List<MagicalItem> loadItems(String item_name){
        List<MagicalItem> allItemList = magicalItemRepository.listAll();
        List<MagicalItem> filteredList = new ArrayList<>();

        for (MagicalItem magicalItem : allItemList){
            if (magicalItem.getName().equals(item_name))
                filteredList.add(magicalItem);
        }
        return filteredList;
    }
}
