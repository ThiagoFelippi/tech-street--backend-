package com.praticar.webflux.services.email;

import org.springframework.stereotype.Service;

@Service
public class MessagesEmail {

    public static String welcomeMessage(){
        return "<h1> Seja bem-vindo a Street Tech! </h1>" +
                "<h4> Quem nós somos? </h4>" +
                "<p> Nós somos uma aplicação onde pessoas que trabalham com tecnologia divulgam os eventos que elas estão promovendo." +
                "Aqui você verá os mais diversos assuntos relacionados com programação, design, devops, etc." +
                "Esperamos que você goste e aproveite todos os recursos que temos, até a próxima! :) </p>";
    }

}
