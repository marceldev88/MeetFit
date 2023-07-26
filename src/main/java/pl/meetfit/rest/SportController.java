package pl.meetfit.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.meetfit.rest.dto.SportOA;
import pl.meetfit.service.SportService;
import pl.meetfit.service.dto.SportDto;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/sport")
@RestController
@AllArgsConstructor
public class SportController {
    private final SportService sportService;

    //  @GetMapping
    // public List<SportDto>

    @GetMapping
    public HashMap<String, String> getAllSports() {
        HashMap<String, String> sports = new HashMap<String, String>();

        List<SportDto> sport1 = sportService.getAllSport();

 //       sport1.stream().map(x -> sports.put(x.getLabel(), x.getValue())).collect(Collectors.toList());

        //for(int x : sport1){
//        sport1.forEach((x)->
//            sports.put(x.getLabel(), x.getValue())
//        );


//        for (SportDto sportDto : sport1) {
//            sports.put(sportDto.getLabel(), sportDto.getValue());
//        }


        return sports;
        //return sportService.getAllSport();
    }

    @PostMapping
    public void save(@RequestBody SportOA sport) {
        SportDto sportDto = SportDto.builder()
                .label(sport.getLabel())
                .build();

        sportService.save(sportDto);
    }

    @GetMapping("/{sportId}")
    public SportDto get(@PathVariable Long sportId) {
        return sportService.getById(sportId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sportService.delete(id);
    }



}
