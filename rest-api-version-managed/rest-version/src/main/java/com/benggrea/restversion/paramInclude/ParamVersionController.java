package com.benggrea.restversion.paramInclude;


import com.benggrea.restversion.service.NewVersionService;
import com.benggrea.restversion.service.OldVersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ParamVersionController {
    private final NewVersionService newVersionService;
    private final OldVersionService oldVersionService;
    @GetMapping("/version")
    public String api(@RequestParam String version){
        if (version.equals("V2")) {
            return newVersionService.findName();
        }
        return oldVersionService.findName();
    }

}
