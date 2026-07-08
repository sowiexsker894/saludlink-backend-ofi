package com.saludlink.ai.controller;

import com.saludlink.ai.dto.AiChatRequest;
import com.saludlink.ai.dto.AiChatResponse;
import com.saludlink.ai.dto.AiReportResponse;
import com.saludlink.ai.dto.AiScheduleResponse;
import com.saludlink.ai.service.AiAppointmentService;
import com.saludlink.ai.service.AiScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiAppointmentService aiAppointmentService;
    private final AiScheduleService aiScheduleService;

    public AiController(
            AiAppointmentService aiAppointmentService,
            AiScheduleService aiScheduleService
    ) {
        this.aiAppointmentService = aiAppointmentService;
        this.aiScheduleService = aiScheduleService;
    }

    @PostMapping("/appointment")
    public ResponseEntity<AiChatResponse> appointmentAssistant(@RequestBody AiChatRequest request) {
        return ResponseEntity.ok(aiAppointmentService.processAppointmentMessage(request));
    }

    @GetMapping("/report")
    public ResponseEntity<AiReportResponse> institutionReport(
            @RequestParam(required = false) String from,
            @RequestParam(required = false) String to
    ) {
        return ResponseEntity.ok(aiAppointmentService.generateInstitutionReport(from, to));
    }

    @PostMapping("/schedule")
    public ResponseEntity<AiChatResponse> scheduleAssistant(@RequestBody AiChatRequest request) {
        return ResponseEntity.ok(aiScheduleService.processScheduleMessage(request));
    }

    @GetMapping("/schedule/summary")
    public ResponseEntity<AiScheduleResponse> scheduleSummary() {
        return ResponseEntity.ok(aiScheduleService.generateScheduleSummary());
    }
}