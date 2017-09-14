package com.btiddle;

import org.json.JSONObject;

public  class ResponseObj {
    public int statusCode;
    public JSONObject body;

    public ResponseObj() {
        statusCode = 0;
        body = new JSONObject("{}");
    }

    public ResponseObj(ResponseObj r) {
        this.statusCode = r.statusCode;
        this.body = r.body;
    }
}
