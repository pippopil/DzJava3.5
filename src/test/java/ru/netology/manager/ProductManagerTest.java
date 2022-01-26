package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    Product first = new Book(1, "Война и Мир", 1000, "Толстой");
    Product second = new Book(2, "Отрочество", 1100, "Толстой");
    Product third = new Book(3, "Прошу,убей меня!", 900, "Маккейн");
    Product fourth = new Smartphone(4, "Iphone", 400, "Apple");
    Product fifth = new Smartphone(5, "A70", 300, "Samsung");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }


    @Test
    void searchByName() {


        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Прошу,убей меня!");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameBook() {


        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy("Отрочество");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesAuthor() {


        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy("Маккейн");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesManufacture() {


        Product[] expected = new Product[]{fifth};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchMatchesNameSmartphone() {


        Product[] expected = new Product[]{fourth};
        Product[] actual = manager.searchBy("Iphone");
        assertArrayEquals(expected, actual);
    }

    //    поиск всех книг одного автора
    @Test
    void searchAllByAuthor() {


        Product[] expected = new Product[]{second, first};
        Product[] actual = manager.searchBy("Толстой");
        assertArrayEquals(expected, actual);
    }

    //    Запрос, на который нет ответа
    @Test
    void searchAll() {

        Product[] expected = new Product[]{};
        Product[] actual = manager.search("Пушкин");
        assertArrayEquals(expected, actual);
    }

}
