package com.anibalvillalva.auth.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Transfer {
    private Transaction to;
    private Transaction from;

}
