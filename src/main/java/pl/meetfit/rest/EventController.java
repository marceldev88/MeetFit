package pl.meetfit.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.meetfit.rest.dto.EventOA;
import pl.meetfit.service.EventService;
import pl.meetfit.service.dto.EventDto;

@RequestMapping( "/api/event")
@RestController
@AllArgsConstructor
public class EventController {

    private final EventService eventService;

    @GetMapping
    public void getAllEvents(){
        System.out.println("dupa");
    }
    @PostMapping
    public void save(@RequestBody EventOA event){
        EventDto eventDto = EventDto.builder()
                .eventName(event.getEventName())
                .eventFrom(event.getEventFrom())
                .eventDo(event.getEventDo())
                .build();

        eventService.save(eventDto);
    }
}
