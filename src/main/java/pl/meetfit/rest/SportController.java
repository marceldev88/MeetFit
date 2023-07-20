package pl.meetfit.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.meetfit.reposytory.entity.Event;
import pl.meetfit.rest.dto.EventOA;
import pl.meetfit.rest.dto.SportOA;
import pl.meetfit.service.EventService;
import pl.meetfit.service.SportService;
import pl.meetfit.service.dto.EventDto;
import pl.meetfit.service.dto.SportDto;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/sport")
@RestController
@AllArgsConstructor
public class SportController {
    private final SportService sportService;

  //  @GetMapping
   // public List<SportDto>

    @GetMapping
    public List<SportDto> getAllSports(){
       return sportService.getAllSport();
    }

    @PostMapping
    public void save(@RequestBody SportOA sport) {
        SportDto sportDto = SportDto.builder()
                .label(sport.getLabel())
                .value(sport.getValue())
                .build();

        sportService.save(sportDto);
    }
    @GetMapping("/{sportId}")
    public SportDto get(@PathVariable Long sportId){
        return sportService.getById(sportId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        sportService.delete(id);
    }


}
