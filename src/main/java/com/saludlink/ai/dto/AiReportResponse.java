package com.saludlink.ai.dto;

public record AiReportResponse(
        String title,
        String summary,
        String recommendation
) {
}