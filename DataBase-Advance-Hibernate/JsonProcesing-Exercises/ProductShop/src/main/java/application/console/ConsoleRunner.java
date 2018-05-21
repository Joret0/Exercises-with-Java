package application.console;

import application.dto.*;
import application.entities.Category;
import application.entities.Product;
import application.entities.User;
import application.io.JSONParser;
import application.services.impl.CategoryServiceImpl;
import application.services.impl.ProductServiceImpl;
import application.services.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner{

    private UserServiceImpl userService;
    private CategoryServiceImpl categoryService;
    private ProductServiceImpl productService;

    private JSONParser parser;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, CategoryServiceImpl categoryService, ProductServiceImpl productService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.parser = new JSONParser();
    }

    @Override
    public void run(String... strings) throws Exception {
        //seedDatabase();
        queryAndExportData();
    }

    private void queryAndExportData() throws IOException {
        //productInRange();
        //successfullySoldProducts();
        //categoriesByProductsCount();
        usersAndProducts();
    }

    private void usersAndProducts() throws IOException {
        Set<User> users = this.userService.userAndProducts();

        UsersProducts usersProducts = new UsersProducts();
        usersProducts.setCountUsers(users.size());

        Set<User3Dto> dtos = new HashSet<>();
        for (User user : users) {
            User3Dto dto = new User3Dto();
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            dto.setAge(user.getAge());

            SoldProducts soldProducts = new SoldProducts();
            soldProducts.setCount(user.getSoldProducts().size());
            Set<ProductDto> productDtoList = new HashSet<>();
            for (Product product : user.getSoldProducts()) {
                ProductDto productDto = new ProductDto();
                productDto.setName(product.getName());
                productDto.setPrice(product.getPrice());
                productDtoList.add(productDto);
            }
            soldProducts.setProducts(productDtoList);

            dto.setSoldProducts(soldProducts);
            dtos.add(dto);
        }
        usersProducts.setUsers(dtos);

        this.parser.outputJson(usersProducts, "C:\\Users\\User\\IdeaProjects\\ProductShop\\src\\main\\resources\\files\\exportFiles\\usersProducts.json");
    }

    private void categoriesByProductsCount() throws IOException {
        Set<Object[]> objects = this.categoryService.categoriesByProductsCount();
        List<Category2Dto> category2Dtos = new ArrayList<>();
        for (Object[] object : objects) {
            Category2Dto dto = new Category2Dto();
            dto.setName(object[0].toString());
            dto.setProductCount(Integer.valueOf(object[1].toString()));
            dto.setAveragePrice(BigDecimal.valueOf(Double.valueOf(object[2].toString())));
            dto.setTotalRevenue(BigDecimal.valueOf(Double.valueOf(object[3].toString())));
            category2Dtos.add(dto);
        }
        this.parser.outputJson(category2Dtos, "C:\\Users\\User\\IdeaProjects\\ProductShop\\src\\main\\resources\\files\\exportFiles\\categories.json");
    }

    private void successfullySoldProducts() throws IOException {
        Set<User> users = this.userService.successfullySoldProducts();
        List<UserOutDto> userOutDtos = new ArrayList<>();
        for (User user : users) {
            UserOutDto dto = new UserOutDto();
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            for (Product product : user.getSoldProducts()) {
                if (product.getBuyer() != null) {
                    ProductOutDto2 prDto = new ProductOutDto2();
                    prDto.setName(product.getName());
                    prDto.setPrice(product.getPrice());
                    prDto.setLastNameBuyer(product.getBuyer().getLastName());
                    prDto.setFirstNameBuyer(product.getBuyer().getFirstName());
                    dto.getSoldProducts().add(prDto);
                }
            }
            userOutDtos.add(dto);
        }
        this.parser.outputJson(userOutDtos, "C:\\Users\\User\\IdeaProjects\\ProductShop\\src\\main\\resources\\files\\exportFiles\\users.json");
    }

    private void productInRange() throws IOException {
        Set<Product> products = this.productService.findProductByBuyerIsNullAndPriceBetweenOrderByPrice(new BigDecimal(500), new BigDecimal(1000));
        List<ProductOutDto> productsDto = new ArrayList<>();
        for (Product product : products) {
            ProductOutDto productOutDto = new ProductOutDto();
            productOutDto.setName(product.getName());
            productOutDto.setPrice(product.getPrice());
            productOutDto.setSellerFullName(product.getSeller().getFirstName() + " " + product.getSeller().getLastName());

            productsDto.add(productOutDto);
        }
        this.parser.outputJson(productsDto, "C:\\Users\\User\\IdeaProjects\\ProductShop\\src\\main\\resources\\files\\exportFiles\\products.json");
    }

    private void seedDatabase() throws IOException {
        //importUsers();
        //importProducts();
        //importCategories();
        //importCategoryProduct();
    }

    private void importCategoryProduct() {
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

    private void importCategories() throws IOException {
        CategoryDto[] categoryDtos = this.parser.importJson(CategoryDto[].class, "/files/importFiles/categories.json");
        ModelMapper modelMapper = new ModelMapper();
        List<Category> categories = new ArrayList<>();
        for (CategoryDto dto : categoryDtos) {
            Category category = modelMapper.map(dto, Category.class);
            categories.add(category);
        }
        this.categoryService.saveList(categories);
    }

    private void importProducts() throws IOException {
        ProductDto[] productDtos = this.parser.importJson(ProductDto[].class, "/files/importFiles/products.json");
        ModelMapper modelMapper = new ModelMapper();
        List<Product> products = new ArrayList<>();
        int c = 0;
        for (ProductDto dto : productDtos) {
            Product newProduct = modelMapper.map(dto, Product.class);
            newProduct.setSeller(generateRandomUser());
            if (c % 5 != 0) {
                newProduct.setBuyer(generateRandomUser());
            }
            products.add(newProduct);
            c++;
        }
        this.productService.saveList(products);
    }

    private User generateRandomUser() {
        Random random = new Random();
        int num = random.nextInt(57);
        if (num == 0) {
            num += 1;
        }
        return this.userService.findById((long) num);
    }

    private void importUsers() throws IOException {
        UserDto[] usersDto = this.parser.importJson(UserDto[].class, "/files/importFiles/users.json");
        ModelMapper modelMapper = new ModelMapper();
        List<User> users = new ArrayList<>();
        for (UserDto dto : usersDto) {
            users.add(modelMapper.map(dto, User.class));
        }
        this.userService.saveList(users);
    }
}
