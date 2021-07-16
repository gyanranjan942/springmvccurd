package com.unfi.teksys.service;

import com.unfi.teksys.beans.Customer;
import com.unfi.teksys.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerDao customerDao;//will inject dao

    public int save(Customer p){
        return customerDao.save(p);
    }
    public int update(Customer p){
        return customerDao.update(p);
    }
    public int delete(int id){
        return customerDao.delete(id);
    }
    public Customer getCustomerById(int id)
    {
        return customerDao.getCustomerById(id);
    }

    public List<Customer> getCustomers()
    {
        return customerDao.getCustomer();
    }
}
