package pl.meetfit.service.dto;

import  lombok.*;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportDto {
    private Long id;
    private String label;
    private String value;
}
