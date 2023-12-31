package spharos.client.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceWorkerScheduleRegisterDto {

    private Integer dayOfWeek;
    private Integer serviceStartTime;
    private Integer serviceFinishTime;

}
