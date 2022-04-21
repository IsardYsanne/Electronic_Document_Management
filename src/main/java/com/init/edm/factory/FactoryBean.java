package com.init.edm.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.init.edm.enums.DocumentsType;
import com.init.edm.utilities.Randomizer;

import java.util.Map;

/**
 * Класс для настройки фабричного компонента для получения фабрик документа.
 *
 * @author GKordyukova
 */
@Component
public class FactoryBean implements org.springframework.beans.factory.FactoryBean<DocumentFactory> {

    /**
     * Ассоциативный массив с фабриками документа
     */
    @Autowired
    private Map<String, DocumentFactory> documentFactories;

    /**
     * Генератор случайных значений
     */
    @Autowired
    private Randomizer randomizer;

    /**
     * Указать, является ли объект, созданный FactoryBean, одноэлементным.
     *
     * @return boolean
     */
    @Override
    public boolean isSingleton() {
        return Boolean.TRUE;
    }

    /**
     * Вернуть объект, созданный фабрикой, по ключу и объект, который будет использоваться контейнером Spring.
     *
     * @return фабрика документов
     * @throws Exception проверенное исключение
     */
    @Override
    public DocumentFactory getObject() throws Exception {
        DocumentsType documentsType = randomizer.getRandomEnumeration(DocumentsType.class);
        String type = documentsType.getType();
        return documentFactories.get(type);
    }

    /**
     * Вернуть тип объекта, который создает FactoryBean.
     *
     * @return тип объекта
     */
    @Override
    public Class<?> getObjectType() {
        return DocumentFactory.class;
    }
}
