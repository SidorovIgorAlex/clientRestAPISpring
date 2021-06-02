package org.sidorov.igor.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sidorov.igor.rest.Configuration.MyConfig;
import org.sidorov.igor.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws JsonProcessingException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        ObjectMapper objectMapper = new ObjectMapper();

        Employee[] employees = objectMapper.readValue(communication.showAllEmployees(), Employee[].class);

        for (Employee element : employees) {
            System.out.println(element);
        }

        Employee employee = objectMapper.readValue(communication.getEmployee(22), Employee.class);
        System.out.println(employee);
    }
}