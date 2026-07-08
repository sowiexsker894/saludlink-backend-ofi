package com.saludlink.ai.service;

import com.saludlink.ai.dto.AiChatRequest;
import com.saludlink.ai.dto.AiChatResponse;
import com.saludlink.ai.dto.AiReportResponse;
import org.springframework.stereotype.Service;

@Service
public class AiAppointmentService {

    public AiChatResponse processAppointmentMessage(AiChatRequest request) {
        String message = request.message();

        if (message == null || message.isBlank()) {
            return new AiChatResponse("Por favor, ingresa un mensaje para ayudarte con tu cita médica.");
        }

        String normalizedMessage = message.toLowerCase();

        if (normalizedMessage.contains("reserva") || normalizedMessage.contains("agendar")) {
            return new AiChatResponse(
                    "He recibido tu solicitud de cita. Para completar la reserva, se validará la especialidad, fecha, hora y disponibilidad médica."
            );
        }

        if (normalizedMessage.contains("pendiente") || normalizedMessage.contains("citas")) {
            return new AiChatResponse(
                    "Puedo ayudarte a consultar tus citas pendientes y revisar el estado de tus próximas atenciones."
            );
        }

        return new AiChatResponse(
                "Puedo ayudarte con la gestión de citas médicas, reservas, consultas pendientes y orientación sobre disponibilidad."
        );
    }

    public AiReportResponse generateInstitutionReport(String from, String to) {
        return new AiReportResponse(
                "Reporte institucional de citas",
                "Durante el periodo seleccionado se analiza la gestión de citas, estados de atención y uso de la plataforma.",
                "Se recomienda monitorear citas canceladas, citas pendientes y tiempos de confirmación para mejorar la continuidad de atención."
        );
    }
}