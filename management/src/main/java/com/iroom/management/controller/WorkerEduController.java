package com.iroom.management.controller;

import com.iroom.management.dto.request.WorkerEduRequest;
import com.iroom.management.dto.response.PagedResponse;
import com.iroom.management.dto.response.WorkerEduResponse;
import com.iroom.management.service.WorkerEduService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker-education")
@RequiredArgsConstructor
public class WorkerEduController {
    private final WorkerEduService workerEduService;

    // 안전교육 이수 등록
    @PostMapping
    public ResponseEntity<WorkerEduResponse> recordEdu(@RequestBody WorkerEduRequest requestDto) {
        WorkerEduResponse response = workerEduService.recordEdu(requestDto);
        return ResponseEntity.ok(response);
    }

    // 교육 정보 조회
    @GetMapping("/workers/{workerId}")
    public ResponseEntity<PagedResponse<WorkerEduResponse>> getEduInfo(
            @PathVariable Long workerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        if (size > 50) size = 50;
        if (size < 0) size = 0;

        PagedResponse<WorkerEduResponse> response = workerEduService.getEduInfo(workerId, page, size);
        return ResponseEntity.ok(response);
    }

}
