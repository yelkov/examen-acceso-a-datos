package edu.badpals.examen;

import edu.badpals.examen.domain.MagicalItem;
import edu.badpals.examen.domain.Order;
import edu.badpals.examen.repository.Repositorio;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

@QuarkusTest
public class LoadOrderTest {
    @Inject
    Repositorio repo;

    @Test
    public void test_load_order() {
        Assertions.assertThat(repo).isNotNull();

        Optional<Order> order = repo.loadOrder("Marius Black","Aged Brie");
        Assertions.assertThat(order).isNotEmpty();
        Assertions.assertThat(order.get().getWizard().getName()).isEqualTo("Marius Black");
        Assertions.assertThat(order.get().getItem().getName()).isEqualTo("Aged Brie");

    }
}
