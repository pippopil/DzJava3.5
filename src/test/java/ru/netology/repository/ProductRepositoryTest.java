package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    Product first = new Book(1, "Война и Мир", 1000, "Толстой");
    Product second = new Book(2, "Отрочество", 1100, "Толстой");

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);

        int idToRemove=1;
        repository.removeById(idToRemove);

        Product[] expected = new Product[] {};
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);

    }


}
