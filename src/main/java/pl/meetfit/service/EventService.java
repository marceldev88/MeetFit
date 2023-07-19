package pl.meetfit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.meetfit.reposytory.entity.Event;
import pl.meetfit.reposytory.entity.EventRepository;
import pl.meetfit.service.dto.EventDto;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;

    public void save(EventDto event) {
        Event entity = Event.builder()
                .eventFrom(event.getEventFrom())
                .eventName(event.getEventName())
                .eventDo(event.getEventDo()).build();
        eventRepository.save(entity);
    }
}
