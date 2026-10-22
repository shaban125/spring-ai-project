//package com.spring.ollama.spring_ai_ollama;
//
//import java.util.Map;
//
//public class PromptTemplate {
//
//    // 1. Yahan asal template store hota hai
//    private final String template;
//
//    // 2. Private constructor - bahar se direct new nahi kar sakte
//    // Sirf Builder hi isko bana sakta hai
//    private PromptTemplate(Builder builder) {
//        this.template = builder.template;
//    }
//
//    // 3. YE HAI STATIC FUNCTION - iski wajah se tum PromptTemplate.builder() likh pate ho
//    // Iske liye object banane ki zaroorat nahi, direct Class ke naam se call hota hai
//    public static Builder builder() {
//        return new Builder();
//    }
//
//    // 4. Jab object mil jaye to prompt kaise banta hai? render() se
//    public String render(Map<String, String> variables) {
//        String result = this.template;
//        // {name} ko Map ki value se replace karo
//        for (Map.Entry<String, String> entry : variables.entrySet()) {
//            result = result.replace("{" + entry.getKey() + "}", entry.getValue());
//        }
//        return result;
//    }
//
//    // 5. YE HAI BUILDER - Outer class ke andar ek static inner class
//    public static class Builder {
//        private String template;
//
//        // Ye wala hai tumhara sawal -> template builder ke andar function hai
//        public Builder template(String template) {
//            this.template = template;
//            System.out.println("template set ho gaya");
//            return this;// return this ki wajah se chain banta hai .builder().template().build()
//        }
//
//        public PromptTemplate build() {
//            return new PromptTemplate(this);
//        }
//    }
//}
