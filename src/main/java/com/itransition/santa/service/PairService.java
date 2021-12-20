package com.itransition.santa.service;

import com.itransition.santa.model.Employee;
import com.itransition.santa.model.Pair;
import com.itransition.santa.repository.PairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PairService {

    private final PairRepository pairRepository;
    private final EmployeeService employeeService;

    public String createPair(String name) {
        Optional<Employee> optionalEmployee = employeeService.findEmployeeByFullName(name);
        if(optionalEmployee.isPresent()) {
            if (optionalEmployee.get().getNotChild()) {
                Employee santa = optionalEmployee.get();
                Employee child;
                while (true) {
                    child = employeeService.getRandomEmployee();
                    if(!child.getFullName().equalsIgnoreCase(santa.getFullName())) {break;}
                }
                child.setNotSanta(false);
                santa.setNotChild(false);
                employeeService.save(santa);
                employeeService.save(child);
                pairRepository.save(new Pair(santa, child));
                return "Поздравляем! Подарите подарок : (" + child.getFullName() + ")";
            } else {
                return "Вы уже получили свою пару. Обратитесь к Виталику, если вы забыли имя.";
            }
        } else {
            return "Ошибка! Вы нерпавильно скопировали имя. Попробуйте ещё раз, либо обратитесь к Виталику.";
        }
    }

    public void reboot() {
        pairRepository.deleteAll();
    }

    public List<Pair> getAll() {
         return pairRepository.findAll();
    }
}
