package com.spring.ollama.spring_ai_ollama.service;

import reactor.core.publisher.Flux;

public interface ChatService {
//    String chatTemplate(String query);

    Flux<String> streamChat(String query, String conversationId);
}
