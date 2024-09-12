package com.henryrauch.shellApplication.model;

public record ActivityResponse(String activity,
                               Float availability,
                               String type,
                               Integer participants,
                               Float price,
                               String accessibility,
                               String duration,
                               Boolean kidFriendly,
                               String link, String key ) {
}
