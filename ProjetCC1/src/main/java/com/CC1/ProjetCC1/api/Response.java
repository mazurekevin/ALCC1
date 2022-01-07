package com.CC1.ProjetCC1.api;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
 public final class Response {
    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract(pure = true)
    public final String notFound(String value) {
        return value + " n'a pas été trouvé.";
    }

    public final String created(String value) {
        return value + " a bien été créé.";
    }

    public final String updated(String value) {
        return value + " a bien été mis à jour.";
    }

    public final String deleted(String value) {
        return value + " a bien été supprimé.";
    }
}
