package application.dto.export;

import application.dto.inport.CustomerDto;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class CustomerDto2 implements Serializable{
    @Expose
    private int customersCount;
    @Expose
    private List<CustomerDto> customers;

    public CustomerDto2() {
    }

    public int getCustomersCount() {
        return customersCount;
    }

    public void setCustomersCount(int customersCount) {
        this.customersCount = customersCount;
    }

    public List<CustomerDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDto> customers) {
        this.customers = customers;
    }
}
