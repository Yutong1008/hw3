package com.example.project.service;

import com.example.project.ConvertToPoJo.Response;
import com.example.project.dto.Employee;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;


@Service
public class EmployeeService {
    private final RestTemplate restTemplate;
    String url = "https://dummy.restapiexample.com/api/v1/employees";
    @Autowired
    public EmployeeService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    public List<Employee> getAll(){
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setAccept(singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(url, HttpMethod.GET, entity, Response.class).getBody().getData();
//        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,Response.class).getBody();
//                new ParameterizedTypeReference<List<Employee>>() {});
//        return responseEntity.getBody();

    }

    public List<Employee> getByAge(int age) {
        return getAll().stream().filter(emp -> emp.getEmployee_age() == age).collect(Collectors.toList());
    }
    public List<List<Employee>> getAllByAge() {
        Map<Integer, List<Employee>> empMap = getAll()
                .stream().collect(Collectors.groupingBy(Employee::getEmployee_age));//<Class name>::<method name>
        List<List<Employee>> empList = new ArrayList<>();
        for(int i : empMap.keySet()){
            empList.add(empMap.get(i));
        }
        return empList;
    }

//    Object[] objects = responseEntity.getBody();
//    ObjectMapper mapper = new ObjectMapper();
//    return Arrays.Stream(objects)
//            .map(object ->mapper.convertValue(object, Employee.class))
//            .map(Employee::getEemployee_age)
//    .collect(Collectors.toList());


//    public String savaEmployee(Employee employee){
//
////        HttpEntity<Employee> entity = new HttpEntity<>(employee);
////        return restTemplate.exchange("https://dummy.restapiexample.com/api/v1/employees", HttpMethod.GET, entity,String.class).getBody();
//    }

}
