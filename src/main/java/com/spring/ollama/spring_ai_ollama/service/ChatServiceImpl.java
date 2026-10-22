package com.spring.ollama.spring_ai_ollama.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService{
    @Value("classpath:prompt/system-message.st")
    private Resource systemMessage;
    @Value("classpath:prompt/user-message.st")
    private Resource userMessage;
    private ChatClient chatClient;



    public ChatServiceImpl(ChatClient.Builder builder){
        this.chatClient=builder.build();
    }

    @Override
    public String chatTemplate(String query){

        PromptTemplate strTemplate = PromptTemplate.builder().template("What is {techName}? tell me example {exampeName}").build();

        String renderMessage = strTemplate.render(Map.of(
                "techName", "Spring",
                "exampleName", "Spring Boot"
        ));

        Prompt prompt = new Prompt(renderMessage);

        return this.chatClient.prompt(prompt).call().content();
    }

    @Override
    public Flux<String> streamChat(String query) {



        return this.chatClient
                .prompt()
                .system(system -> system.text(this.systemMessage))
                .user(user-> user.text(this.userMessage).param("concept", query))
                .stream().content();
    }


}
