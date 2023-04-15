package com.benggrea.restversion.urlInclude.classBased;

import com.benggrea.restversion.service.NewVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2")
@RequiredArgsConstructor
public class NameControllerV2 {
    private final NewVersionService newVersionService;

    @GetMapping("name")
    public String version() {
        return newVersionService.findName();

    }

}
