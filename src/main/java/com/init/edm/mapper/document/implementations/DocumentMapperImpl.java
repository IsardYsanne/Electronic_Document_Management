package com.init.edm.mapper.document.implementations;

import org.springframework.stereotype.Component;
import com.init.edm.mapper.document.interfaces.DocumentMapper;
import com.init.edm.model.dto.document.DocumentDto;
import com.init.edm.model.entity.document.Document;
import com.init.edm.model.entity.document.IncomingDocument;
import com.init.edm.model.entity.document.OutgoingDocument;
import com.init.edm.model.entity.document.TaskDocument;

import java.util.ArrayList;
import java.util.List;

/**
 * Служит для конвертации сущности документа в DTO или наоборот.
 *
 * @author GKordyukova
 */
@Component
public class DocumentMapperImpl implements DocumentMapper {

    /**
     * Конвертировать сущность документа в dto.
     * Задать тип документа, который отобразится на UI.
     *
     * @param document документ
     * @return {@link DocumentDto} Data Transfer Object документов
     */
    @Override
    public DocumentDto toDto(Document document) {
        DocumentDto documentDto = new DocumentDto();
        documentDto.setId(document.getUuid());
        Class<? extends Document> type = document.getClass();
        if (TaskDocument.class.equals(type)) {
            documentDto.setType("Task");
        } else if (IncomingDocument.class.equals(type)) {
            documentDto.setType("Incoming");
        } else if (OutgoingDocument.class.equals(type)) {
            documentDto.setType("Outgoing");
        }
        documentDto.setName(document.getName());
        documentDto.setText(document.getText());
        documentDto.setRegNumber(document.getRegNumber());
        documentDto.setDate(document.getDate());
        documentDto.setAuthor(document.getAuthor().getSurname() + " " + document.getAuthor().getName() + " " + document.getAuthor().getPatronymic());
        return documentDto;
    }

    /**
     * Конвертировать список документов в dto.
     *
     * @param documents список документов
     * @return List {@link DocumentDto} сконвертированный список в необходимое нам представление
     */
    @Override
    public List<DocumentDto> toListDto(List<Document> documents) {
        List<DocumentDto> documentsDto = new ArrayList<>();
        for (Document document : documents) {
            documentsDto.add(toDto(document));
        }
        return documentsDto;
    }
}
