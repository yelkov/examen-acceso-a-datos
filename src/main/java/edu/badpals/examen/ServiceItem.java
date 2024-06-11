package edu.badpals.examen;

import com.fasterxml.jackson.databind.util.NativeImageUtil;
import edu.badpals.examen.domain.MagicalItem;
import edu.badpals.examen.repository.Repositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ServiceItem {
    @Inject
    Repositorio repo;

    public Optional<MagicalItem> getItem(String item_name){
        return repo.loadItem(item_name);
    }

    public List<MagicalItem> getItems(String item_name){
        return repo.loadItems(item_name);
    }

    public boolean validateItem(MagicalItem magicalItem){
        if (magicalItem.getName().isEmpty() ||
                magicalItem.getType().isEmpty() ||
                magicalItem.getQuality() < 0 ){
            return false;
        }else{
            return true;
        }
    }

    @Transactional
    public Optional<MagicalItem> postItem(MagicalItem magicalItem){
        if (!validateItem(magicalItem)){
            return Optional.ofNullable(null);
        }
        repo.createItem(magicalItem.getName(),magicalItem.getQuality(),magicalItem.getType());
        return repo.loadItem(magicalItem);
    }

}
