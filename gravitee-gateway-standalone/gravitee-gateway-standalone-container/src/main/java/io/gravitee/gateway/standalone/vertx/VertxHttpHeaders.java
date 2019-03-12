/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.gateway.standalone.vertx;

import io.gravitee.common.http.HttpHeaders;
import io.vertx.core.MultiMap;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class VertxHttpHeaders implements HttpHeaders {

    private final MultiMap headers;

    public VertxHttpHeaders(MultiMap headers) {
        this.headers = headers;
    }

    @Override
    public int size() {
        return headers.size();
    }

    @Override
    public boolean isEmpty() {
        return headers.isEmpty();
    }

    @Override
    public boolean contains(String name) {
        return headers.contains(name);
    }

    @Override
    public List<String> get(String name) {
        return headers.getAll(name);
    }

    @Override
    public HttpHeaders put(String name, List<String> values) {
        headers.set(name, values);
        return this;
    }

    @Override
    public List<String> remove(String name) {
        List<String> values = headers.getAll(name);
        headers.remove(name);
        return values;
    }

    @Override
    public void clear() {
        headers.clear();
    }

    @Override
    public Set<String> names() {
        return headers.names();
    }

    @Override
    public List<Map.Entry<String, List<String>>> entries() {
        //TODO: implement it
        return null;
    }

    @Override
    public void forEach(BiConsumer<String, String> action) {
        headers.forEach(entry -> action.accept(entry.getKey(), entry.getValue()));
    }

    @Override
    public String getFirst(String name) {
        return headers.get(name);
    }

    @Override
    public HttpHeaders add(String name, String value) {
        headers.add(name, value);
        return this;
    }

    @Override
    public HttpHeaders set(String name, String value) {
        headers.set(name, value);
        return this;
    }

    @Override
    public HttpHeaders setAll(Map<String, String> headers) {
        this.headers.setAll(headers);
        return this;
    }
}
