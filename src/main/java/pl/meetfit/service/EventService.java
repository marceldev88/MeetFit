package pl.meetfit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.meetfit.reposytory.entity.Event;
import pl.meetfit.reposytory.entity.EventRepository;
import pl.meetfit.reposytory.entity.Sport;
import pl.meetfit.reposytory.entity.SportRepository;
import pl.meetfit.rest.dto.EventSaveOA;
import pl.meetfit.rest.dto.SportOA;
import pl.meetfit.service.dto.EventDto;
import pl.meetfit.service.dto.EventMapper;
import pl.meetfit.service.dto.SportDto;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    private final SportRepository sportRepository;
    public void save(EventSaveOA event) {
        Sport sport= sportRepository.getById(event.getTypSport());
        Event entity = Event.builder()
                .eventFrom(event.getEventFrom())
                .eventName(event.getEventName())
                .sport(sport)
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
        Sport sport = event.getSport();

        SportDto sportDto = new SportDto();
        sportDto.setLabel(sport.getLabel());
        sportDto.setId(sport.getId());

        response.setSport(sportDto);


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

    public List<EventDto> getEventsForSport(Long sportId){
        List<Event> events = eventRepository.findBySport_Id(sportId);
        List<EventDto> eventDto= eventMapper.map(events);
        return eventDto;
    }
}
