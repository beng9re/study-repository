package com.benggrea.restversion.service;

import org.springframework.stereotype.Service;

@Service
public class OldVersionService {

    public String findName() {
        return "기존 서비스 입니다.";
    }
}
