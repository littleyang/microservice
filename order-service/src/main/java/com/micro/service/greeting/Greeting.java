package com.micro.service.greeting;

/**
 * @description:
 * @author: yang.zhou
 * @version: 1.0.0
 * @since: 2016-09-28 5:20 PM
 */

public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}