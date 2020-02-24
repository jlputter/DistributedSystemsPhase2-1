package com.example.distributedsystemsphase2;

import io.javalin.Javalin;

public class Main {

    public static void main(String[] args){
        Javalin app = Javalin.create().start(6000);

        app.get("/", ctx -> {
            ctx.status(201);
        });
    }
}
