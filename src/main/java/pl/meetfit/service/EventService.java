package pl.meetfit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.meetfit.reposytory.entity.Event;
import pl.meetfit.reposytory.entity.EventRepository;
import pl.meetfit.service.dto.EventDto;
import pl.meetfit.service.dto.EventMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    public void save(EventDto event) {
        Event entity = Event.builder()
                .eventFrom(event.getEventFrom())
                .eventName(event.getEventName())
                .eventDo(event.getEventDo()).build();
        eventRepository.save(entity);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();

    }

    public EventDto getById(Long id) {
        EventDto response = new EventDto();

        Event event = eventRepository.getById(id);
        response.setId(event.getId());
        response.setEventDo(event.getEventDo());
        response.setEventFrom(event.getEventFrom());
        response.setEventName(event.getEventName());


        return response;
    }

    public void delete(Long id) {
        EventDto eventdto = getById(id);
        eventRepository.deleteById(id);

    }
    public List<EventDto> getEventsDateFrom(LocalDate dattaFrom){
       List<Event> events= eventRepository.findByEventFromBetween(dattaFrom.atStartOfDay(),dattaFrom.atTime(23, 59));
       List <EventDto> eventDto2= eventMapper.map(events);
        return eventDto2;

    }
}
