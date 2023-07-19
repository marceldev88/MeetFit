package pl.meetfit.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class EventDto {
    private Long id;
    private String eventName;
    private LocalDateTime eventFrom;
    private LocalDateTime eventDo;

}
