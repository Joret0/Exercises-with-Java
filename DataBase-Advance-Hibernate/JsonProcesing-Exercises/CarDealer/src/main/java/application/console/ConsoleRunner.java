package application.console;

import application.dto.export.*;
import application.dto.inport.CarDto;
import application.dto.inport.CustomerDto;
import application.dto.inport.PartDto;
import application.dto.inport.SupplierDto;
import application.io.JSONParser;
import application.model.*;
import application.services.impl.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner{

    private CarServiceImpl carService;
    private CustomerServiceImpl customerService;
    private PartServiceImpl partService;
    private SaleServiceImpl saleService;
    private SupplierServiceImpl supplierService;
    private JSONParser parser;

    @Autowired
    public ConsoleRunner(CarServiceImpl carService, CustomerServiceImpl customerService, PartServiceImpl partService, SaleServiceImpl saleService, SupplierServiceImpl supplierService) {
        this.carService = carService;
        this.customerService = customerService;
        this.partService = partService;
        this.saleService = saleService;
        this.supplierService = supplierService;
        this.parser = new JSONParser();
    }

    @Override
    public void run(String... strings) throws Exception {
        //carDealerImportData();
        queryingAndExportData();
    }

    private void queryingAndExportData() throws IOException {
        //orderedCustomers();
        //carsFromMakeToyota();
        //localSuppliers();
        //carsWithTheirListOfParts();
        //totalSalesByCustomer();
        salesWithAppliedDiscount();
    }

    private void salesWithAppliedDiscount() throws IOException {
        List<Object[]> objects = this.saleService.salesWithAppliedDiscount();
        List<SaleDto> dtoList = new ArrayList<>();
        for (Object[] object : objects) {
            SaleDto dto = createSaleDto(object);
            dtoList.add(dto);
        }
        this.parser.outputJson(dtoList, "C:\\Users\\User\\IdeaProjects\\CarDealer\\src\\main\\resources\\files\\output\\sales.json");
    }

    private SaleDto createSaleDto(Object[] object) {
        SaleDto dto = new SaleDto();
        Car car = createCar(object[0], object[1], object[2]);
        ModelMapper modelMapper = new ModelMapper();

        dto.setCar(modelMapper.map(car, CarDto.class));
        dto.setCustomerName(object[3].toString());
        dto.setDiscount(BigDecimal.valueOf(Double.valueOf(object[4].toString())));
        dto.setPrice(BigDecimal.valueOf(Double.valueOf(object[5].toString())));
        dto.setPriceWithDiscount(BigDecimal.valueOf(Double.valueOf(object[6].toString())));

        return dto;
    }

    private Car createCar(Object o, Object o1, Object o2) {
        Car car = new Car();
        car.setMake(o.toString());
        car.setModel(o1.toString());
        car.setTravelledDistance(BigDecimal.valueOf(Double.valueOf(o2.toString())));
        return car;
    }

    private void totalSalesByCustomer() throws IOException {
        List<Customer> customers = this.customerService.totalSalesByCustomer();
        List<Customer3Dto> dtoList = new ArrayList<>();
        for (Customer customer : customers) {
            Customer3Dto dto = new Customer3Dto();
            dto.setFullName(customer.getName());
            dto.setBoughtCars(customer.getSales().size());
            dto.setSpentMoney(getSpentMoney(customer));
            dtoList.add(dto);
        }
        this.parser.outputJson(dtoList, "C:\\Users\\User\\IdeaProjects\\CarDealer\\src\\main\\resources\\files\\output\\customers2.json");
    }

    private BigDecimal getSpentMoney(Customer customer) {
        BigDecimal total = new BigDecimal(0);
        for (Sale sale : customer.getSales()) {
            for (Part part : sale.getCar().getParts()) {
                total = total.add(part.getPrice());
            }
        }
        return total;
    }

    private void carsWithTheirListOfParts() throws IOException {
        List<Car> cars = this.carService.findAll();
        List<Car3Dto> car3DtoList = new ArrayList<>();
        for (Car car : cars) {
            Car3Dto dto = new Car3Dto();
            dto.setMake(car.getMake());
            dto.setModel(car.getModel());
            dto.setTravelledDistance(car.getTravelledDistance());
            for (Part part : car.getParts()) {
                Part2Dto partDto = new Part2Dto();
                partDto.setName(part.getName());
                partDto.setPrice(part.getPrice());
                dto.getParts().add(partDto);
            }
            car3DtoList.add(dto);
        }
        this.parser.outputJson(car3DtoList, "C:\\Users\\User\\IdeaProjects\\CarDealer\\src\\main\\resources\\files\\output\\cars2.json");
    }

    private void localSuppliers() throws IOException {
        List<Supplier> suppliers = this.supplierService.findAllSupplierByIsImporterFalse();
        List<Supplier2Dto> supplier2Dtos = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            Supplier2Dto dto = new Supplier2Dto();
            dto.setId(supplier.getId());
            dto.setName(supplier.getName());
            dto.setPartsCount(supplier.getParts().size());
            supplier2Dtos.add(dto);
        }
        this.parser.outputJson(supplier2Dtos, "C:\\Users\\User\\IdeaProjects\\CarDealer\\src\\main\\resources\\files\\output\\suppliers.json");
    }

    private void carsFromMakeToyota() throws IOException {
        List<Car> cars = this.carService.findAllToyotaCars();
        List<Car2Dto> car2Dtos = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Car car : cars) {
            Car2Dto dto = modelMapper.map(car, Car2Dto.class);
            car2Dtos.add(dto);
        }
        this.parser.outputJson(car2Dtos, "C:\\Users\\User\\IdeaProjects\\CarDealer\\src\\main\\resources\\files\\output\\cars.json");
    }

    private void orderedCustomers() throws IOException {
        List<Customer> customers = this.customerService.orderedCustomers();
        List<CustomerDto> dtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Customer customer : customers) {
            CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
            dtoList.add(customerDto);
        }
        CustomerDto2 customerDto2 = new CustomerDto2();
        customerDto2.setCustomersCount(customers.size());
        customerDto2.setCustomers(dtoList);
        this.parser.outputJson(customerDto2, "C:\\Users\\User\\IdeaProjects\\CarDealer\\src\\main\\resources\\files\\output\\customers.json");
    }

    private void carDealerImportData() throws IOException, ParseException {
        //importSuppliers();
        //importParts();
        //importCars();
        //importCustomers();
        //importSales();
    }

    private void importSales() {
        for (int i = 0; i < 20; i++) {
            Car car = this.carService.findById((long) this.createNumber(359));
            Customer customer = this.customerService.findById((long) this.createNumber(31));
            int discount = Discount.getRandomDiscount();
            Sale sale = new Sale();
            sale.setCar(car);
            sale.setCustomer(customer);
            sale.setDiscount(BigDecimal.valueOf(discount));
            this.saleService.save(sale);
        }
    }

    private void importCustomers() throws IOException, ParseException {
        CustomerDto[] customerDtos = this.parser.importJson(CustomerDto[].class, "/files/input/customers.json");
        List<Customer> customers = new ArrayList<>();
        for (CustomerDto dto : customerDtos) {
            Customer customer = new Customer();
            customer.setName(dto.getName());
            customer.setIsYoungDriver(dto.isYoungDriver());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
            Date date = sdf.parse(dto.getBirthDate());
            customer.setBirthDate(date);
            customers.add(customer);
        }
        this.customerService.saveList(customers);
    }

    private void importCars() throws IOException {
        CarDto[] carDtos = this.parser.importJson(CarDto[].class, "/files/input/cars.json");
        ModelMapper modelMapper = new ModelMapper();
        List<Car> cars = new ArrayList<>();
        for (CarDto dto : carDtos) {
            Car car = modelMapper.map(dto, Car.class);
            createPartSet(car);
            cars.add(car);
        }
        this.carService.saveList(cars);
    }

    private void createPartSet(Car car) {
        int num = createRandomNumber(10, 20);
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < num; i++) {
            int number = createNumber(132);
            nums.add(number);
        }
        for (Integer integer : nums) {
            Part part = this.partService.findById((long) integer);
            car.getParts().add(part);
        }
    }

    private int createNumber(int max) {
        Random random = new Random();
        int num = random.nextInt(max);
        if (num == 0) {
            num = 1;
        }
        return num;
    }

    private int createRandomNumber(int min, int max) {
        Random random = new Random();
        int num = random.nextInt(max);
        if (num < min) {
            num += min;
        }
        return num;
    }

    private void importParts() throws IOException {
        PartDto[] partDtos = this.parser.importJson(PartDto[].class, "/files/input/parts.json");
        ModelMapper modelMapper = new ModelMapper();
        List<Part> parts = new ArrayList<>();
        for (PartDto dto : partDtos) {
            Part part = modelMapper.map(dto, Part.class);
            part.setSupplier(generateRandomSupplier());
            parts.add(part);
        }
        this.partService.saveList(parts);
    }

    private Supplier generateRandomSupplier() {
        Random random = new Random();
        int i = random.nextInt(32);
        if (i == 0) {
            i = 1;
        }
        return this.supplierService.findById((long) i);
    }

    private void importSuppliers() throws IOException {
        SupplierDto[] supplierDtos = this.parser.importJson(SupplierDto[].class, "/files/input/suppliers.json");
        ModelMapper modelMapper = new ModelMapper();
        List<Supplier> suppliers = new ArrayList<>();
        for (SupplierDto dto : supplierDtos) {
            Supplier supplier = modelMapper.map(dto, Supplier.class);
            suppliers.add(supplier);
        }
        this.supplierService.saveList(suppliers);
    }
}
