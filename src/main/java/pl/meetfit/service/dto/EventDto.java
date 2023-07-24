package pl.meetfit.service.dto;

import lombok.*;

import java.time.LocalDateTime;
@Data
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class EventDto {
    private Long id;
    private String eventName;
    private LocalDateTime eventFrom;
    private LocalDateTime eventDo;

}
