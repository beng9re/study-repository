package com.benggrea.restversion.headerInclude;

import com.benggrea.restversion.service.NewVersionService;
import com.benggrea.restversion.service.OldVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class HarderVersionController {

    private final OldVersionService oldVersionService;
    private final NewVersionService newVersionService;

    @GetMapping(path = "header", headers = {"X-API-VERSION=V1"})
    public String v1() {
        return oldVersionService.findName();
    }
    @GetMapping(path = "header", headers = {"X-API-VERSION=V2"})
    public String v2() {
        return newVersionService.findName();
    }
}
