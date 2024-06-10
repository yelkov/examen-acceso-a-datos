package edu.badpals.examen;

import edu.badpals.examen.domain.MagicalItem;
import edu.badpals.examen.repository.Repositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class ServiceItem {
    @Inject
    Repositorio repo;

    public Optional<MagicalItem> getItem(String item_name){
        return repo.loadItem(item_name);
    }

    @Transactional
    public Optional<MagicalItem> postItem(MagicalItem magicalItem){
        if (magicalItem.getName().isEmpty() ||
                magicalItem.getType().isEmpty() ||
                magicalItem.getQuality() < 0 ){
            return Optional.ofNullable(null);
        }
        repo.createItem(magicalItem.getName(),magicalItem.getQuality(),magicalItem.getType());
        return repo.loadItem(magicalItem);
    }

}
