package pl.meetfit.service.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import pl.meetfit.reposytory.entity.Event;
import pl.meetfit.rest.dto.EventOA;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {


    EventDto eventToEventDto(Event event);
    EventDto map(EventOA eventOA);
    List<EventDto> map(List<Event> events);
}
