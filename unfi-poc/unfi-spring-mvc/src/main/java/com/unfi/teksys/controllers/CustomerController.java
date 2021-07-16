
package com.unfi.teksys.controllers;

import com.unfi.teksys.beans.Customer;
import com.unfi.teksys.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService custservice) {
        this.customerService = custservice;
    }

    /*It displays a form to input data, here "command" is a reserved request attribute
     *which is used to display object data into form
     */

    @RequestMapping("/customerform")
    public String showform(Model m){
        m.addAttribute("command", new Customer());
        return "customerform";
    }

/*It saves object into database. The @ModelAttribute puts request data
     *  into model object. You need to mention RequestMethod.POST method
     *  because default request is GET*/

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public String save(@ModelAttribute("customer") Customer custservice){
        custservice.setId(0);
        customerService.save(custservice);
        return "redirect:/viewcustomer";//will redirect to viewcustomer request mapping
    }

/* It provides list of customers in model object */

    @RequestMapping("/viewcustomer")
    public String viewcustomer(Model m){
        List<Customer> list=customerService.getCustomers();
        m.addAttribute("list",list);
        return "viewcustomer";
    }
/* It displays object data into form for the given id.
     * The @PathVariable puts URL data into variable.*/

    @RequestMapping(value="/editCustomer/{id}")
    public String edit(@PathVariable int id, Model m){
        Customer customer=customerService.getCustomerById(id);
        m.addAttribute("command",customer);
        return "customerform";
    }
/* It updates model object. */

    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public String editsave(@ModelAttribute("customer") Customer customer){
        customerService.update(customer);
        return "redirect:/viewcustomer";
    }
/* It deletes record for the given id in URL and redirects to /viewcustomer */

    @RequestMapping(value="/deletecustomer/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        customerService.delete(id);
        return "redirect:/viewcustomer";
    }
}

