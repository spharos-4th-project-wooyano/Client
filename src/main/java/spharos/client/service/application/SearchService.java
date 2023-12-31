package spharos.client.service.application;

import spharos.client.service.dto.SearchServiceDataListDto;
import spharos.client.service.vo.response.SearchServiceDataListResponse;
import spharos.client.service.dto.ExcellentServiceDto;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

public interface SearchService {
    List<Long> findWorkerServiceList(String type, LocalDate date, Integer region) throws ParseException;
    List<Long> findServiceList(String type, Integer region) throws ParseException;
    List<SearchServiceDataListDto> findServiceListData(List<Long> serviceIdList,String type);
    List<SearchServiceDataListDto> findServiceTypeSearch(String type);
    List<ExcellentServiceDto> findExcellentServiceList();



}
