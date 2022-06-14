import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.object.Product;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    Product bookFirst = new Book(1, "WhiteSpirit", 1500, "Antony Hopkins");
    Product bookSecond = new Book(2, "Lord of The Rings", 1700, "Tolkien");
    Product bookThird = new Book(3, "The Clean Coder: A Code of Conduct for Professional Programmers", 2700, "Robert Martin");
    Product smartphoneFirst = new Smartphone(4, "Galaxy A50", 12000, "Samsung");
    Product smartphoneSecond = new Smartphone(5, "iPhone13Pro", 129990, "Apple");
    Product smartphoneThird = new Smartphone(6, "Galaxy S21 FE", 50000, "Samsung");

    @Test
    void shouldSaveOneProduct() {
        repository.saveProduct(bookFirst);

        Product[] actual = repository.findAll();
        Product[] expected = {bookFirst};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSaveTwoProducts() {
        repository.saveProduct(bookFirst);
        repository.saveProduct(bookSecond);

        Product[] actual = repository.findAll();
        Product[] expected = {bookFirst, bookSecond};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldSaveSixProducts() {
        repository.saveProduct(bookFirst);
        repository.saveProduct(bookSecond);
        repository.saveProduct(bookThird);
        repository.saveProduct(smartphoneFirst);
        repository.saveProduct(smartphoneSecond);
        repository.saveProduct(smartphoneThird);

        Product[] actual = repository.findAll();
        Product[] expected = {bookFirst, bookSecond, bookThird, smartphoneFirst, smartphoneSecond, smartphoneThird};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void findAllWithoutProducts() {
        Product[] repo = repository.findAll();

        int actual = repo.length;
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void shouldRemoveByIdWithSixProducts() {
        repository.saveProduct(bookFirst);
        repository.saveProduct(bookSecond);
        repository.saveProduct(bookThird);
        repository.saveProduct(smartphoneFirst);
        repository.saveProduct(smartphoneSecond);
        repository.saveProduct(smartphoneThird);

        repository.removeById(5);
        Product[] actual = repository.findAll();
        Product[] expected = {bookFirst, bookSecond, bookThird, smartphoneFirst, smartphoneThird};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldRemoveByIdWithTwoProducts() {
        repository.saveProduct(bookFirst);
        repository.saveProduct(bookSecond);

        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = {bookSecond};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldRemoveByIdWithOneProduct() {
        repository.saveProduct(bookSecond);

        repository.removeById(2);
        Product[] repo = repository.findAll();
        int actual = repo.length;
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }
}
