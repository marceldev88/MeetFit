package pl.meetfit.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.meetfit.reposytory.entity.Event;
import pl.meetfit.rest.dto.EventOA;
import pl.meetfit.service.EventService;
import pl.meetfit.service.dto.EventDto;
import pl.meetfit.service.dto.EventMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/event")
@RestController
@AllArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;
    @GetMapping({"/"})
    public List<EventDto> getAllEvents() {

        List<Event> allEvents = eventService.getAllEvents();
        List<EventDto> response = new ArrayList<>();

        for (int i = 0; i < allEvents.size(); i++) {
            EventDto eventDto1 = new EventDto();
            eventDto1.setId(allEvents.get(i).getId());
            eventDto1.setEventName(allEvents.get(i).getEventName());
            eventDto1.setEventDo(allEvents.get(i).getEventDo());
            eventDto1.setEventFrom(allEvents.get(i).getEventFrom());

            response.add(eventDto1);
        }
        return response;
    }

    @PostMapping
    public void save(@RequestBody EventOA event) {
//        EventDto eventDto = EventDto.builder()
//                .eventName(event.getEventName())
//                .eventFrom(event.getEventFrom())
//                .eventDo(event.getEventDo())
//                .build();
//
//        eventService.save(eventDto);
           EventDto eventDto= eventMapper.map(event);
            eventService.save(eventDto);


    }


    @GetMapping("/{eventId}")
    public EventDto get(@PathVariable Long eventId){

     return eventService.getById(eventId);

    }
    @GetMapping
    public void getLiczba(@RequestParam String  eventId, @RequestParam String dupa){
        System.out.println();
    }

    @GetMapping("/{eventName}/{eventFrom}")
    public void getTime(@PathVariable String eventName, @PathVariable String eventFrom){
        System.out.println();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        eventService.delete(id);
    }

    @GetMapping("/search/{data}")
    public List<EventDto>  getDataFrom(@PathVariable LocalDate data)
    {
        return  eventService.getEventsDateFrom(data);
    }
}
