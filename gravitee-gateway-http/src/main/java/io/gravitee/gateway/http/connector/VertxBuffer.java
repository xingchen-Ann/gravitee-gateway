package io.gravitee.gateway.http.connector;

import io.gravitee.gateway.api.buffer.Buffer;

import java.nio.charset.Charset;

public class VertxBuffer implements Buffer {

    private final io.vertx.core.buffer.Buffer buffer;

    VertxBuffer(final io.vertx.core.buffer.Buffer buffer) {
        this.buffer = buffer;
    }

    public static Buffer of(io.vertx.core.buffer.Buffer buffer) {
        return new VertxBuffer(buffer);
    }

    @Override
    public Buffer appendBuffer(Buffer buff) {
        buffer.appendBytes(buff.getBytes());
        return this;
    }

    @Override
    public Buffer appendString(String str, String enc) {
        buffer.appendString(str, enc);
        return this;
    }

    @Override
    public Buffer appendString(String str) {
        buffer.appendString(str);
        return this;
    }

    @Override
    public String toString(String enc) {
        return buffer.toString(enc);
    }

    @Override
    public String toString(Charset enc) {
        return buffer.toString(enc);
    }

    @Override
    public byte[] getBytes() {
        return buffer.getBytes();
    }

    @Override
    public int length() {
        return buffer.length();
    }

    @Override
    public Object getNativeBuffer() {
        return buffer.getByteBuf();
    }
}
