package application.console;

import application.dto.EmployeeDto;
import application.dto.ManagerDto;
import application.models.Address;
import application.models.City;
import application.models.Employee;
import application.services.address.AddressServiceImpl;
import application.services.city.CityServiceImpl;
import application.services.employee.EmployeeServiceImpl;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class ConsoleRunner implements CommandLineRunner{
    private EmployeeServiceImpl employeeService;
    private AddressServiceImpl addressService;
    private CityServiceImpl cityService;

    @Autowired
    public ConsoleRunner(EmployeeServiceImpl employeeService, AddressServiceImpl addressService, CityServiceImpl cityService) {
        this.employeeService = employeeService;
        this.addressService = addressService;
        this.cityService = cityService;
    }

    @Override
    public void run(String... strings) throws Exception {

        //task1SimpleMapping();
        //task2AdvancedMapping();
        task3Projection();
    }

    private void task3Projection() {
        List<Employee> employees = this.employeeService.findAll();

        for (Employee employee : employees) {

            /*
            ModelMapper modelMapper = new ModelMapper();
            TypeMap<EmployeeDto, Employee> typeMap = modelMapper.createTypeMap(EmployeeDto.class, Employee.class);
            typeMap.addMappings(m -> m.map(EmployeeDto::getManagerLastName, Employee::setLastName));

            EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
            typeMap.map(employeeDto);
            */


            ModelMapper modelMapper = new ModelMapper();
            PropertyMap<Employee, EmployeeDto> propertyMap = new PropertyMap<Employee, EmployeeDto>() {
                @Override
                protected void configure() {
                    map().setManagerLastName(source.getManager().getLastName());
                }
            };
            modelMapper.addMappings(propertyMap);
            EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);

            System.out.printf("%s %s %s", employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getSalary());
            if (employeeDto.getManagerLastName() == null) {
                System.out.printf(" [no manager]%n");
            } else {
                System.out.printf(" - Manager: %s%n", employeeDto.getManagerLastName());
            }
        }
    }

    private void task2AdvancedMapping() {
        City city = new City();
        city.setName("Sofia");
        this.cityService.save(city);

        Address address = new Address();
        address.setStreet("Rakovska 1");
        address.setCity(city);
        this.addressService.save(address);

        Employee manager = new Employee();
        manager.setFirstName("Georgi");
        manager.setLastName("Stalev");
        manager.setSalary(new BigDecimal(50000));
        manager.setBirthDate(new Date());
        manager.setOnHoliday(false);
        manager.setAddress(address);
        this.employeeService.save(manager);

        Employee ivan = new Employee();
        ivan.setAddress(address);
        ivan.setOnHoliday(false);
        ivan.setBirthDate(new Date());
        ivan.setSalary(new BigDecimal(50000));
        ivan.setLastName("Stalev");
        ivan.setFirstName("Ivan");
        ivan.setManager(manager);
        this.employeeService.save(ivan);

        Employee aneta = new Employee();
        aneta.setAddress(address);
        aneta.setOnHoliday(false);
        aneta.setBirthDate(new Date());
        aneta.setSalary(new BigDecimal(50000));
        aneta.setLastName("Moleva");
        aneta.setFirstName("Aneta");
        aneta.setManager(manager);
        this.employeeService.save(aneta);

        manager.setEmployees(new HashSet<Employee>() {{
            add(ivan);
            add(aneta);
        }});
        this.employeeService.save(manager);

        ModelMapper modelMapper = new ModelMapper();
        ManagerDto managerDto = modelMapper.map(manager, ManagerDto.class);

        System.out.printf("%s %s | Employees: %d%n", managerDto.getFirstName(), managerDto.getLastName(), managerDto.getEmployees().size());
        for (EmployeeDto employeeDto : managerDto.getEmployees()) {
            System.out.printf("   - %s %s %s%n", employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getSalary());
        }

    }

    private void task1SimpleMapping() throws ParseException {
        City city = new City();
        city.setName("Haskovo");
        this.cityService.save(city);

        Address address = new Address();
        address.setStreet("Orfei 32");
        address.setCity(city);
        this.addressService.save(address);

        Employee employee = new Employee();
        employee.setFirstName("Georgi");
        employee.setLastName("Stalev");
        employee.setSalary(new BigDecimal(10000));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse("08-02-1984");
        employee.setBirthDate(date);
        employee.setAddress(address);
        this.employeeService.save(employee);

        ModelMapper modelMapper = new ModelMapper();
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        System.out.printf("%s %s %s%n", employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getSalary());
    }
}
