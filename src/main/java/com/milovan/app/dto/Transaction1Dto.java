package com.milovan.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction1Dto {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
