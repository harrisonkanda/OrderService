package com.amson.threadExecutorService.genericDto;

public class ResponseData<T>{

    private T data;

    public ResponseData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
