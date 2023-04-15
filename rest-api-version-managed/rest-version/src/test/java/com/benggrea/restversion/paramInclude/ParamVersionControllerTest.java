package com.benggrea.restversion.paramInclude;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.benggrea.restversion.mime.BengMimeType;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("API 버전을 Param으로 분기하여 서비스를 관리한다")
class ParamVersionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestFactory
    @DisplayName("버전 테스트")
    Stream<DynamicTest> apiUrlIncludeVersion() {
        return Stream.of(
                dynamicTest("API v1 - 기존 서비스", () -> {
                    String expectedResponse = "기존 서비스 입니다.";

                    // when, then
                    mockMvc.perform(MockMvcRequestBuilders.get("/api/name")
                                    .accept(BengMimeType.V1_JSON)
                                    .contentType(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk())
                            .andExpect(content().bytes(expectedResponse.getBytes(StandardCharsets.UTF_8)))
                            .andDo(print());
                }),

                dynamicTest("API v2 - 새로운 서비스", () -> {
                    String expectedResponse = "새로운 서비스 입니다.";

                    // when, then
                    mockMvc.perform(MockMvcRequestBuilders.get("/api/name")
                                    .accept(BengMimeType.V2_JSON)
                                    .contentType(MediaType.APPLICATION_JSON))
                            .andExpect(status().isOk())
                            .andExpect(content().bytes(expectedResponse.getBytes(StandardCharsets.UTF_8)))
                            .andDo(print());
                })
        );
    }
}