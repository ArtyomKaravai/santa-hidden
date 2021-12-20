package com.itransition.santa.service;

import com.itransition.santa.model.Employee;
import com.itransition.santa.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private List<Employee> correctList;

    {   correctList = List.of(new Employee("Жариков Виталик"),
                              new Employee("Жалнерчик Саша"),
                              new Employee("Горбунов Роман"),
                              new Employee("Кучук Оля"),
                              new Employee("Мудрогелов Виктор"),
                              new Employee("Шепелевич Михаил"),
                              new Employee("Орленко Иван"),
                              new Employee("Савик Константин"),
                              new Employee("Петрухин Роман"),
                              new Employee("Михайлов Илья"),
                              new Employee("Шпринц Костя"),
                              new Employee("Чернухин Никита"),
                              new Employee("Куликова Маша"),
                              new Employee("Шикунец Сергей"),
                              new Employee("Капаченя Антон"),
                              new Employee("Драгун Игорь"),
                              new Employee("Шаповалов Геннадий"),
                              new Employee("Закревский Степан"),
                              new Employee("Неборский Андрей"),
                              new Employee("Лабус Слава"),
                              new Employee("Камлюк Дима"),
                              new Employee("Сидоренко Евгений"),
                              new Employee("Ковалев Евгений"),
                              new Employee("Маркова Екатерина"),
                              new Employee("Антоненко Илья"));
    }


    public List<Employee> getAllWithoutChild() {
        return employeeRepository.findAll().stream()
                                           .filter(Employee::getNotChild)
                                           .collect(Collectors.toList());
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeByFullName(String fullName) {
        return employeeRepository.findEmployeeByFullName(fullName);
    }

    public void reboot() {
        employeeRepository.deleteAll();
        employeeRepository.saveAll(correctList);
    }

    public Employee getRandomEmployee() {
        List<Employee> employeeList = employeeRepository.findAll().stream()
                                                                  .filter(Employee::getNotSanta)
                                                                  .collect(Collectors.toList());
        return employeeList.get((int) Math.ceil(Math.random() * employeeList.size()) - 1);
    }
}
