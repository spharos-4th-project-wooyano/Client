package spharos.client.service.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDetailDto {

    private String description;
    private List<Integer> serviceAreaList;
    //↓상호명
    private String clientName;
    private String registrationNumber;
    private String cliendAddress;
}