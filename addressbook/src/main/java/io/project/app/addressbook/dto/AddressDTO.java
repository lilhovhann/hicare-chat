package io.project.app.addressbook.dto;

import io.project.app.addressbook.domain.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/**
 *
 * @author lilit
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO extends DTO {

    private Long chatId;

    private Long contactId;

    private String contactName;

    private String email;

    private String phoneNumber;

    private String zoomId;

    private String gender;

    private String proffession;

    private LocalDateTime recordDate = LocalDateTime.now();

}
