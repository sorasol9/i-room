package com.iroom.user.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WorkerRole {
    Worker("ROLE_WORKER");

    private final String key;
}
