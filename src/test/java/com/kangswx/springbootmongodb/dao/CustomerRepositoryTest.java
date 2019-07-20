package com.kangswx.springbootmongodb.dao;

import com.kangswx.springbootmongodb.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository repository;

    /**
     * 新添加数据
     */
    @Test
    public void addTest(){
        Customer customer = repository.save(new Customer("Bob", "Smith"));
        System.out.println("保存结果"+customer);
    }

    /**
     * 查询所有的数据
     */
    @Test
    public void findAllTest(){
        List<Customer> list = repository.findAll();
        for(int i = 0; i < list.size(); i++){
            System.out.println("i: " + list.get(i));
        }
    }

    /**
     * 根据FirstName查询数据
     */
    @Test
    public void findByFirstNameTest(){
        Customer customer = repository.findByFirstName("Alice");
        System.out.println("=============="+customer);
    }

    /**
     * 根据LastName查询数据
     */
    @Test
    public void findByLastNameTest(){
        List<Customer> list = repository.findByLastName("Smith");
        for(int i = 0; i < list.size(); i++){
            System.out.println("i: " + list.get(i));
        }
    }

    /**
     * 根据id查询数据
     */
    @Test
    public void findById(){
        Optional<Customer> customer = repository.findById("5d32760ae044c50370e61b58");
        System.out.println("======================" + customer.get());
    }

    /**
     * 根据id删除数据
     */
    @Test
    public void deleteTest(){
        repository.deleteById("5d32760ae044c50370e61b58");
    }
}