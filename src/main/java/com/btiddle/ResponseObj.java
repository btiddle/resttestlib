package com.btiddle;

import org.json.JSONObject;

class ResponseObj {
    int statusCode;
    JSONObject body;

    ResponseObj() {
        statusCode = 0;
        body = new JSONObject("{}");
    }

    public ResponseObj(int statusCode, JSONObject jsonObject) {
        this.statusCode = statusCode;
        this.body = jsonObject;
    }
}
