package com.spring.ollama.spring_ai_ollama.controller;


import com.spring.ollama.spring_ai_ollama.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping
public class ChatController {


    private ChatClient chatClient;

    private ChatService chatService;

//    public ChatController(ChatClient.Builder builder){
//        this.chatClient = builder.build();
//    }
    private ChatController(ChatService chatService){
        this.chatService = chatService;
    }

//    @GetMapping("/chat")
//    public ResponseEntity<String> chat(@RequestParam(value = "q") String q){
//        return ResponseEntity.ok(chatService.chatTemplate(q));
//    }


    @GetMapping("/stream-chat")
    public ResponseEntity<Flux<String>> streamChat(@RequestParam("q") String query,@RequestParam(defaultValue = "default") String conversationId){
        return ResponseEntity.ok(this.chatService.streamChat(query, conversationId));
    }

}
