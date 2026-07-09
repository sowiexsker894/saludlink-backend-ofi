package com.saludlink.ai.service;

import com.saludlink.ai.dto.AiChatRequest;
import com.saludlink.ai.dto.AiChatResponse;
import com.saludlink.ai.dto.AiScheduleResponse;
import org.springframework.stereotype.Service;

@Service
public class AiScheduleService {

    public AiChatResponse processScheduleMessage(AiChatRequest request) {
        String message = request.message();

        if (message == null || message.isBlank()) {
            return new AiChatResponse("Por favor, ingresa una consulta sobre tu agenda médica.");
        }

        String normalizedMessage = message.toLowerCase();

        if (normalizedMessage.contains("mañana")) {
            return new AiChatResponse(
                    "Puedo ayudarte a revisar las citas programadas para mañana y resumir la carga de agenda médica."
            );
        }

        if (normalizedMessage.contains("hoy")) {
            return new AiChatResponse(
                    "Puedo ayudarte a revisar tu agenda médica del día y organizar las citas pendientes."
            );
        }

        if (normalizedMessage.contains("huecos") || normalizedMessage.contains("libres")) {
            return new AiChatResponse(
                    "Puedo ayudarte a identificar posibles espacios disponibles en la agenda médica."
            );
        }

        return new AiChatResponse(
                "Puedo ayudarte con consultas sobre agenda médica, citas del día, disponibilidad y organización de atenciones."
        );
    }

    public AiScheduleResponse generateScheduleSummary() {
        return new AiScheduleResponse(
                "Resumen general de agenda médica",
                "Se recomienda revisar las citas pendientes, confirmar las atenciones próximas y monitorear los espacios disponibles."
        );
    }
}