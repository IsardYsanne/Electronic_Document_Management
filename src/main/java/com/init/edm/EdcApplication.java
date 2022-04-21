package com.init.edm;

import com.init.edm.database.StaffTableCreatorInitializer;
import com.init.edm.repository.staff.filler.interfaces.DepartmentStaffRepositoryFiller;
import com.init.edm.repository.staff.filler.interfaces.OrganizationStaffRepositoryFiller;
import com.init.edm.repository.staff.filler.interfaces.PersonStaffRepositoryFiller;
import com.init.edm.repository.staff.filler.interfaces.PostStaffRepositoryFiller;
import com.init.edm.storage.document.filler.interfaces.DocumentStorageFiller;
import com.init.edm.utilities.Randomizer;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

import java.sql.SQLException;

/**
 * Главный класс приложения.
 * Отображает созданные авторами документы и исполнителей.
 * Соединяет с БД и выгружает в таблицы данные из репозиториев оргштатных единиц.
 *
 * @author GKordyukova
 */
@SpringBootApplication(exclude = {DataSourceTransactionManagerAutoConfiguration.class})
public class EdcApplication implements CommandLineRunner {

    /**
     * Создает таблицы
     */
    @Autowired
    private StaffTableCreatorInitializer staffTableCreatorInitializer;

    /**
     * Заполняет документы
     */
    @Autowired
    private DocumentStorageFiller documentStorageFiller;

    /**
     * Заполняет организации
     */
    @Autowired
    private OrganizationStaffRepositoryFiller organizationStaffRepositoryFiller;

    /**
     * Заполняет подразделения
     */
    @Autowired
    private DepartmentStaffRepositoryFiller departmentStaffRepositoryFiller;

    /**
     * Заполняет сотрудников
     */
    @Autowired
    private PersonStaffRepositoryFiller personStaffRepositoryFiller;

    /**
     * Заполняет должности
     */
    @Autowired
    private PostStaffRepositoryFiller postStaffRepositoryFiller;

    /**
     * Генератор случайных чисел
     */
    @Autowired
    protected Randomizer randomizer;

    /**
     * Создать таблицы.
     */
    public void initTable() {
        staffTableCreatorInitializer.createTablesStaff();
    }

    /**
     * Заполнить репозитории и таблицы данными
     *
     * @throws JAXBException возникает в случае анмаршалинга xml данных
     * @throws SQLException  возникает в случае ошибок доступа к базе данных или других ошибок.
     */
    public void fillObjects() throws JAXBException, SQLException {
        postStaffRepositoryFiller.fillPostStaffRepository("Post.xml");
        personStaffRepositoryFiller.fillPersonStaffRepository("Persons.xml");
        departmentStaffRepositoryFiller.fillDepartmentStaffRepository("Departments.xml");
        organizationStaffRepositoryFiller.fillOrganizationStaffRepository("Organizations.xml");
        documentStorageFiller.fillDocumentStorage(randomizer.getRandomNumberBetween(5, 50));
    }

    public static void main(String[] args) {
        SpringApplication.run(EdcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initTable();
        fillObjects();
    }
}
