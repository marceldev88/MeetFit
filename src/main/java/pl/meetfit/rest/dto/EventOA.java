package pl.meetfit.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventOA {
    private Long id;
    private String eventName;
    private LocalDateTime eventFrom;
    private LocalDateTime eventDo;

}
