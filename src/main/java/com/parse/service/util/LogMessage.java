package com.parse.service.util;

public interface LogMessage {
    String logSentMessage = "Message :: sent -> {}";
    String logReceivedMessage = "Message :: received -> {}";
    String logErrorMessage = "Error IN :: {} :: errorMessage:{} :: Time: {}";
    String logEndMessage = "End :: {} :: Time: {}";
}
