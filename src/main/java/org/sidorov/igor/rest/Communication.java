package org.sidorov.igor.rest;

import org.apache.log4j.Logger;
import org.sidorov.igor.rest.entity.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    private Logger logger = Logger.getLogger(Communication.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL = "http://localhost:8080/api/employees";


    public String showAllEmployees() {
        logger.info("Send message to Rabbit -> showAllEmployees");
        return (String) amqpTemplate.convertSendAndReceive("queue1", "ShowAllEmployees");
    }

    public String getEmployee(int id) {
        logger.info("Send message to Rabbit -> showAllEmployees");
        return (String) amqpTemplate.convertSendAndReceive("queue1", id);
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if(id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee,
                                                                                String.class);
            System.out.println("New employee was added to DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate. put(URL, employee);
            System.out.println(String.format("Employee with id = %d was updated", id));
        }
    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL + "/" + id);
        System.out.println(String.format("Employee with %d was deleted", id));
    }
}
