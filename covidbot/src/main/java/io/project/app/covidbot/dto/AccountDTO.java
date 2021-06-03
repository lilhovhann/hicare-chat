package io.project.app.covidbot.dto;

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
public class AccountDTO {
  
    private Long chatId;
    
    private String firstname;
    
    private String lastname;
    
    private LocalDateTime registerDate = LocalDateTime.now();
    
}
