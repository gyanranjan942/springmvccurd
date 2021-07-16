package com.unfi.teksys.dao;

import com.unfi.teksys.beans.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Customer p) {
        String sql = "insert into customer(id,name,email,address) values('" + p.getId() + "','" + p.getName() + "'," + p.getEmail() + ",'" + p.getAddress() + "')";
        return template.update(sql);
    }

    public int update(Customer p) {
        String sql = "update customer set id='" +p.getId() + "', name='" + p.getName() + "', email=" + p.getEmail() + ",address='" + p.getAddress() + "' where id=" + p.getId() + "";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from Customer where id=" + id + "";
        return template.update(sql);
    }

    public Customer getCustomerById(int id) {
        String sql = "select * from Customer where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    public List<Customer> getCustomer() {
        return template.query("select * from Customer", new RowMapper<Customer>() {
            public Customer mapRow(ResultSet rs, int row) throws SQLException {
                Customer customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setName(rs.getString(2));
                customer.setEmail(rs.getString(3));
                customer.setAddress(rs.getString(4));
                return customer;
            }
        });
    }
}
