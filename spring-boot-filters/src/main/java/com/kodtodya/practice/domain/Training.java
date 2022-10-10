package com.kodtodya.practice.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Training {

    private int id;
    private String name;
    private int duration;
    private String prerequisite;

    public Training(String name, int duration, String prerequisite) {
        this.name = name;
        this.duration = duration;
        this.prerequisite = prerequisite;
    }
}
