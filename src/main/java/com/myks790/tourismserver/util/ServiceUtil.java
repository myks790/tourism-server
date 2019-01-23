package com.myks790.tourismserver.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Slf4j
public class ServiceUtil {
    public static Pageable makePageRequest(Integer page, Integer size, String sort) {
        String[] sortItems = sort.split(",");
        String sortField = sortItems[0];
        Sort.Direction direction = Sort.Direction.ASC;
        if (sortItems.length > 1) {
            if ("desc".equals(sortItems[1])) {
                direction = Sort.Direction.DESC;
            }
        }
        return PageRequest.of(page, size, direction, sortField);
    }
}
