package edu.badpals.examen;

import edu.badpals.examen.domain.MagicalItem;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;
@QuarkusTest
class ValidateItemTest {
    @Inject
    ServiceItem service;

    @Test
    public void validateItem_test(){

        MagicalItem okItem = new MagicalItem("Resurrection Stone",666,"MagicalItem");
        MagicalItem fakeItem = new MagicalItem("",50,"MagicalItem");
        MagicalItem foolItem = new MagicalItem("Sorting Hat",50,"");
        MagicalItem notItem = new MagicalItem("",50,"");
        assertThat(service.validateItem(okItem)).isEqualTo(true);
        assertThat(service.validateItem(fakeItem)).isEqualTo(false);
        assertThat(service.validateItem(foolItem)).isEqualTo(false);
        assertThat(service.validateItem(notItem)).isEqualTo(false);
    }
}