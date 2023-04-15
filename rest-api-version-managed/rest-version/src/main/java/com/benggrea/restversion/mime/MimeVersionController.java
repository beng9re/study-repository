package com.benggrea.restversion.mime;


import com.benggrea.restversion.service.NewVersionService;
import com.benggrea.restversion.service.OldVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MimeVersionController {

    private final OldVersionService oldVersionService;
    private final NewVersionService newVersionService;


    @GetMapping(path = "name", produces = BengMimeType.V1_JSON)
    public String v1() {
        return oldVersionService.findName();
    }
    @GetMapping(path = "name", produces = BengMimeType.V2_JSON)
    public String v2() {
        return newVersionService.findName();
    }
}
