package com.kodtodya.practice.student.management.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public record StudentUpdate(
        @JsonInclude(JsonInclude.Include.NON_EMPTY) String name,
        @JsonInclude(JsonInclude.Include.NON_EMPTY)double percentage) {
}