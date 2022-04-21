package com.init.edm.service.document;

import com.init.edm.factory.FactoryBean;
import com.init.edm.mapper.document.interfaces.DocumentMapper;
import com.init.edm.model.dto.document.DocumentDto;
import com.init.edm.model.entity.document.Document;
import com.init.edm.storage.document.DocumentsStorageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Сервис для работы с документами.
 * Создает и заполняет коллекцию документов.
 *
 * @author GKordyukova
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    /**
     * Маппер для сущности документов
     */
    @Autowired
    private DocumentMapper documentMapper;

    /**
     * Хранилище документов
     */
    @Autowired
    private DocumentsStorageImpl documentsStorage;

    /**
     * Настройка фабричного компонента
     */
    @Autowired
    private FactoryBean factoryBean;

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * Создать и заполнить список документов.
     *
     * @param documentCount рандомное количество докуметов
     * @return List {@link Document} список документов
     */
    @Override
    public List<Document> generateDocumentsCollection(int documentCount) {
        List<Document> documents = new ArrayList<>();
        for (int i = 0; i < documentCount; i++) {
            try {
                documents.add(Objects.requireNonNull(factoryBean.getObject()).create());
            } catch (Exception e) {
                throw new RuntimeException("Документы не были сгенерированы.");
            }
        }
        return documents;
    }

    /**
     * Получить список документов, созданных автором.
     *
     * @param authorId идентификатор автора документа
     * @return List {@link Document} список документов
     */
    @Override
    public List<Document> findAllByAuthorId(UUID authorId) {
        return documentsStorage.getDocuments().stream().filter(document -> document.getAuthor().getUuid().equals(authorId)).collect(Collectors.toList());
    }

    /**
     * Найти документ по идентификатору.
     *
     * @param uuid идентификатор документа
     * @return {@link DocumentDto} найденный документ
     */
    @Override
    public DocumentDto findById(UUID uuid) {
        return documentMapper.toDto(documentsStorage.getDocuments().stream().filter(document -> document.getUuid().equals(uuid)).findFirst().orElse(null));
    }

    /**
     * Получить список документов.
     *
     * @return List {@link DocumentDto} dto списка документов
     */
    @Override
    public List<DocumentDto> findAll() {
        return documentMapper.toListDto(documentsStorage.getDocuments());
    }
}
