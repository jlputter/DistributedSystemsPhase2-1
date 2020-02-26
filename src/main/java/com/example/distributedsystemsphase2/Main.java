package com.example.distributedsystemsphase2;

import io.javalin.Javalin;

public class Main {

    //Author: Trey Roche

    public static void main(String[] args){
        Javalin app = Javalin.create().start(6000);

        app.get("/", ctx -> {
            ctx.status(201);
        });

        app.get("/start", ctx -> {
            ctx.status(201);
        });

        app.get("/join", ctx ->{
            ctx.status(201);
        });

        app.get("/join/add", ctx ->{
            ctx.status(201);
        });
    }
}
