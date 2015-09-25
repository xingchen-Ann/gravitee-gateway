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
package io.gravitee.gateway.core.definition.validator;

import io.gravitee.gateway.core.definition.ApiDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author David BRASSELY (brasseld at gmail.com)
 */
public class ValidatorImpl implements Validator {

    private final Logger logger = LoggerFactory.getLogger(ValidatorImpl.class);

    private static final Validator [] VALIDATORS = {
            new ApiValidator(),
            new ProxyValidator(),
            new PathValidator(),
            new HttpClientValidator()
    };

    @Override
    public void validate(ApiDefinition definition) throws ValidationException {
        logger.debug("Validate API Definition for API: {}", definition.getName());

        for (Validator validator : VALIDATORS) {
            validator.validate(definition);
        }
    }
}
