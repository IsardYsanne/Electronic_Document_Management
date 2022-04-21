package com.init.edm.model.entity.document;

import com.init.edm.model.entity.staff.PersonStaff;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.text.MessageFormat;
import java.time.LocalDate;

/**
 * Описывает характеристики поручения.
 *
 * @author GKordyukova
 */
@XmlRootElement(name = "taskDocument")
public class TaskDocument extends Document {

    /**
     * Дата выдачи поручения
     */
    private LocalDate dateIssue;

    /**
     * Срок исолнения поручения
     */
    private LocalDate periodExecution;

    /**
     * Ответственный исполнитель
     */
    private PersonStaff executor;

    /**
     * Признак контрольности
     */
    private Boolean control;

    /**
     * Контроллер поручения
     */
    private PersonStaff controllerTask;

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public LocalDate getPeriodExecution() {
        return periodExecution;
    }

    public PersonStaff getExecutor() {
        return executor;
    }

    public Boolean getControl() {
        return control;
    }

    public PersonStaff getControllerTask() {
        return controllerTask;
    }

    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }

    public void setPeriodExecution(LocalDate periodExecution) {
        this.periodExecution = periodExecution;
    }

    public void setExecutor(PersonStaff executor) {
        this.executor = executor;
    }

    public void setControl(Boolean control) {
        this.control = control;
    }

    public void setControllerTask(PersonStaff controllerTask) {
        this.controllerTask = controllerTask;
    }

    @Override
    public String toString() {
        MessageFormat messageFormat = new MessageFormat("Поручение № {0} от {1} {2}");
        Object[] format = {getRegNumber(), getDate(), getName()};
        return messageFormat.format(format);
    }
}
