package com.init.edm.factory;

import com.init.edm.model.entity.staff.PersonStaff;
import org.springframework.stereotype.Component;
import com.init.edm.model.entity.document.Document;
import com.init.edm.model.entity.document.TaskDocument;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * Представляет собой фабричный метод для создания и заполнения полей Поручения случайными значениями.
 *
 * @author GKordyukova
 */
@Component("Task")
public class TaskFactory extends DocumentFactory {

    /**
     * Создать документ, заполнив поля документа {@link TaskDocument}
     *
     * @return {@link Document} документ
     */
    @Override
    public Document create() {
        TaskDocument taskDocument = new TaskDocument();
        super.generateDocumentFields(taskDocument);
        List<PersonStaff> employees = personsStaffRepository.findAll();
        Integer randomNumberOfExecutor = new Random().nextInt(employees.size());
        Integer randomNumberOfController = new Random().nextInt(employees.size());
        LocalDate dateIssue = dateCreator.getDate();
        LocalDate deadlineDate = dateCreator.setPeriodExecutionDate();
        PersonStaff executor = employees.get(randomNumberOfExecutor);
        PersonStaff controller = employees.get(randomNumberOfController);
        taskDocument.setDateIssue(dateIssue);
        taskDocument.setPeriodExecution(deadlineDate);
        taskDocument.setExecutor(executor);
        taskDocument.setControl(true);
        taskDocument.setControllerTask(controller);
        return taskDocument;
    }
}
