package com.oguzhan.controller.Impl;

import com.oguzhan.model.RootEntity;

public class RestBaseController {
    public <T> RootEntity<T> ok(T data){
        return RootEntity.ok(data);
    }
    public <T> RootEntity<T> error(String errorMessage) {
        return RootEntity.error(errorMessage);
    }
}
