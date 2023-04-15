package com.benggrea.restversion.urlInclude.methodBased;

import com.benggrea.restversion.service.NewVersionService;
import com.benggrea.restversion.service.OldVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HelloController {

    private final NewVersionService newVersionService;
    private final OldVersionService oldVersionService;

    @GetMapping("v1/version")
    public String version() {
        return oldVersionService.findName();

    }

    @GetMapping("v2/version")
    public String version2() {
        return newVersionService.findName();
    }
}
