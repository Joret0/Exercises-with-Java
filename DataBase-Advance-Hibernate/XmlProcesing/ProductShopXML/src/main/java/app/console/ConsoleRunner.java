package app.console;

import app.dto.*;
import app.io.XmlParser;
import app.modules.Category;
import app.modules.Product;
import app.modules.User;
import app.repositories.DTOConvertUtil;
import app.services.api.CategoryService;
import app.services.api.ProductService;
import app.services.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner{

    private UserService<User,Long> userService;
    private ProductService<Product, Long> productService;
    private CategoryService<Category, Long> categoryService;

    @Autowired
    public ConsoleRunner(UserService<User, Long> userService, ProductService<Product, Long> productService, CategoryService<Category, Long> categoryService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... strings) throws Exception {

        //importDataInformation();
        queryAndExportData();
    }

    private void queryAndExportData() {
        //productsInRange();
        //successfullySoldProducts();
        //categoriesByProductsCount();
        usersAndProducts();

    }

    private void usersAndProducts() {
        Set<User> users = this.userService.usersAndProducts();
        UsersDto user = new UsersDto();
        user.setCount(users.size());
        List<UserDto> userDtos = new ArrayList<>();
        for (User user1 : users) {
            ProductsDto productsDto = new ProductsDto();
            List<ProductDto> productDtos = new ArrayList<>();
            Set<Product> soldProducts = user1.getSoldProducts();
            for (Product product : soldProducts) {
                productDtos.add(DTOConvertUtil.convert(product, ProductDto.class));
            }
            productsDto.setProducts(productDtos);
            productsDto.setCount(productDtos.size());
            UserDto ui = DTOConvertUtil.convert(user1, UserDto.class);
            ui.setProducts(productsDto);
            userDtos.add(ui);
        }

        user.setUsers(userDtos);
        XmlParser xmlParser = new XmlParser();
        String fileName = "C:\\Users\\User\\IdeaProjects\\ProductShopXML\\src\\main\\resources\\files\\export\\users-and-products.xml";
        xmlParser.serialize(user, fileName);
    }

    private void categoriesByProductsCount() {
        Set<Object[]> objects = this.categoryService.categoriesByProductsCount();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Object[] object : objects) {
            CategoryDto dto = createCategoryDto(object);
            categoryDtos.add(dto);
        }

        CategoriesDto categoriesDto = new CategoriesDto();
        categoriesDto.setCategories(categoryDtos);
        XmlParser xmlParser = new XmlParser();
        String fileName = "C:\\Users\\User\\IdeaProjects\\ProductShopXML\\src\\main\\resources\\files\\export\\categories-products.xml";
        xmlParser.serialize(categoriesDto, fileName);
    }

    private CategoryDto createCategoryDto(Object[] object) {
        CategoryDto c = new CategoryDto();
        c.setName(object[0].toString());
        c.setProductsCount(Integer.valueOf(object[1].toString()));
        c.setAveragePrice(BigDecimal.valueOf(Double.valueOf(object[2].toString())));
        c.setTotalRevenue(BigDecimal.valueOf(Double.valueOf(object[3].toString())));
        return c;
    }

    private void successfullySoldProducts() {
        Set<User> users = this.userService.successfullySoldProducts();
        List<UserDto> userDtos = new ArrayList<>();

        for (User user : users) {
            UserDto dto = DTOConvertUtil.convert(user, UserDto.class);
            List<Product> products = user.getSoldProducts().stream().collect(Collectors.toList());
            ProductsDto productsDto = new ProductsDto();
            List<ProductDto> list = new ArrayList<>();
            for (Product product : products) {
                list.add(DTOConvertUtil.convert(product, ProductDto.class));
            }
            productsDto.setProducts(list);
            dto.setProducts(productsDto);
            userDtos.add(dto);
        }

        UsersDto main = new UsersDto();
        main.setUsers(userDtos);
        XmlParser xmlParser = new XmlParser();
        String fileName = "C:\\Users\\User\\IdeaProjects\\ProductShopXML\\src\\main\\resources\\files\\export\\sold-products.xml";
        xmlParser.serialize(main, fileName);
    }

    private void productsInRange() {
        Set<Object[]> products = this.productService.productsInRange();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Object[] arrayObjects : products) {
            ProductDto dto = new ProductDto();
            dto.setName(arrayObjects[0].toString());
            dto.setPrice(new BigDecimal(arrayObjects[1].toString()));
            productDtos.add(dto);
        }
        ProductsDto exportDto = new ProductsDto();
        exportDto.setProducts(productDtos);
        XmlParser xmlParser = new XmlParser();
        String fileName = "C:\\Users\\User\\IdeaProjects\\ProductShopXML\\src\\main\\resources\\files\\export\\products-export.xml";
        xmlParser.serialize(exportDto, fileName);
    }

    private void importDataInformation() {
        //users();
        //products();
        //categories();
        //categoryProductTable();
        //setBuyersToProducts();

    }

    private void setBuyersToProducts() {
        List<Product> products = this.productService.findAll();
        for (Product product : products) {
            product.setBuyer(generateRandomUser());
        }
        this.productService.saveList(products);
    }

    private void categoryProductTable() {
        for (int i = 1; i <= 11; i++) {
            Category category = this.categoryService.findById((long) i);
            category.setProducts(generateRandomProducts());
            this.categoryService.save(category);
        }
    }

    private Set<Product> generateRandomProducts() {
        Random random = new Random();
        int count = random.nextInt(5);
        Set<Product> products = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int id = random.nextInt(201);
            if (id == 0) {
                id = 1;
            }
            products.add(this.productService.findById((long) id));
        }
        return products;
    }

    private void categories() {
        String fileName = "/files/import/categories.xml";
        XmlParser xmlParser = new XmlParser();
        List<CategoryDto> categories = xmlParser.deserialize(CategoriesDto.class, fileName).getCategories();

        for (CategoryDto dto : categories) {
            Category category = DTOConvertUtil.convert(dto, Category.class);
            this.categoryService.save(category);
        }
    }

    private void products() {
        String fileName = "/files/import/products.xml";
        XmlParser xmlParser = new XmlParser();
        List<ProductDto> products = xmlParser.deserialize(ProductsDto.class, fileName).getProducts();

        for (ProductDto dto : products) {
            Product product = DTOConvertUtil.convert(dto, Product.class);
            product.setSeller(generateRandomUser());
            product.setBuyer(generateRandomUser());
            this.productService.save(product);
        }
    }

    private User generateRandomUser() {
        Random random = new Random();

        int num = random.nextInt(57);
        if (num == 0) {
            num += 1;
        }
        return this.userService.findById((long) num);
    }

    private void users() {
        String fileName = "/files/import/users.xml";
        XmlParser xmlParser = new XmlParser();
        UsersDto usersDto = xmlParser.deserialize(UsersDto.class, fileName);

        for (UserDto user : usersDto.getUsers()) {
            User u = DTOConvertUtil.convert(user, User.class);
            userService.save(u);
        }
    }
}
