package org.example.util;

import org.example.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAverageSalaryApp {
    public void findAverageSalary(List<Employee> employees) {
        Map<String, Map<String, Double>> avgSalForEachLocForComDes = employees.stream().collect(
                Collectors.groupingBy(Employee::getOfficeLocation, Collectors.groupingBy(Employee::getDesignation,
                        Collectors.averagingDouble(Employee::getSalary))));

        for (Map.Entry<String, Map<String, Double>> entry : avgSalForEachLocForComDes.entrySet()) {
            for (Map.Entry<String, Double> entry1 : entry.getValue().entrySet()) {
                System.out.println(entry.getKey() + " --> " + entry1.getKey() + " --> " + String.format("%.2f", entry1.getValue()));
            }
        }
    }
}
