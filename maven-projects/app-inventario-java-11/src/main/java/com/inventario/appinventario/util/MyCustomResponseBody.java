package com.inventario.appinventario.util;

import lombok.Data;

@Data
public class MyCustomResponseBody {
    private String msg;

    private String result;

    public MyCustomResponseBody(String msg, String result) {
        this.msg = msg;
        this.result = result;
    }
}
