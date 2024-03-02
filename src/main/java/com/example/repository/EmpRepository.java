package com.example.repository;

import com.example.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpRepository {
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public EmpRepository(RedisTemplate redisTemplate){
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }
    public void saveEmployee(Employee employee){
        hashOperations.put("Employee", employee.getId(), employee);
    }
    public List<Employee> findAll(){
        return hashOperations.values("Employee");
    }
    public Employee findById(Integer id){
        return (Employee) hashOperations.get("Employee", id);
    }
    public void update(Employee employee){
        saveEmployee(employee);
    }
    public void delete(Integer id){
        hashOperations.delete("Employee", id);
    }

    //Hash
    public Employee save(Employee employee){
        redisTemplate.opsForHash().put("Employee", employee.getId(), employee);
        return employee;
    }

    public List<Employee> findAlla(){
        return redisTemplate.opsForHash().values("Employee");
    }

    public Employee findByIda(Integer id){

        return (Employee) redisTemplate.opsForHash().get("Employee", id);
    }



}
