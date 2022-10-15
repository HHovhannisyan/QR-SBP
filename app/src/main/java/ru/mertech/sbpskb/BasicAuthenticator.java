package ru.mertech.sbpskb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class BasicAuthenticator implements Authenticator {
    private final String credentials;

    public BasicAuthenticator() {
        credentials = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJNQTQ2NzY5OSIsImp0aSI6IjIxZDU0NDMwLWM1ODctNGU0MC1iNDQxLTI5ZWU2Y2QyNjMwNSJ9.-bD4cSz56DgUgM9aXp9mXAt67yfjslCVrI3KJNfhQ5U";
    }

    @Nullable
    @Override
    public Request authenticate(@Nullable Route route, @NonNull Response response) {
        Request request = response.request();
        return credentials.equals(request.header("Authorization")) ? null : request.newBuilder().header("Authorization", credentials).build();
    }
}
