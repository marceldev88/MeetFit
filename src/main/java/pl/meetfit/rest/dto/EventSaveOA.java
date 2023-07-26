package pl.meetfit.rest.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EventSaveOA {
    private Long id;
    private String eventName;
    private LocalDateTime eventFrom;
    private LocalDateTime eventDo;
    private Long typSport;

}
