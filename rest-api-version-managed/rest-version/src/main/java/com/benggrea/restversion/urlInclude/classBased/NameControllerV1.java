package com.benggrea.restversion.urlInclude.classBased;

import com.benggrea.restversion.service.OldVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NameControllerV1 {
    private final OldVersionService oldVersionService;

    @GetMapping("/name")
    public String version() {
        return oldVersionService.findName();

    }
}
