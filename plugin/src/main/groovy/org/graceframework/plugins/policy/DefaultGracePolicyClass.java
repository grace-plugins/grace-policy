/*
 * Copyright 2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.graceframework.plugins.policy;

import grace.plugins.policy.GracePolicyClass;

import org.grails.core.AbstractInjectableGrailsClass;

/**
 * DefaultGracePolicyClass
 *
 * @author Michael Yan
 * @since 0.1
 */
public class DefaultGracePolicyClass extends AbstractInjectableGrailsClass implements GracePolicyClass {

    public static final String POLICY = "Policy";

    private Object record;
    private Object user;

    public DefaultGracePolicyClass(Class<?> clazz) {
        super(clazz, POLICY);
    }

    @Override
    public Object getRecord() {
        return this.record;
    }

    public void setRecord(Object record) {
        this.record = record;
    }

    @Override
    public Object getUser() {
        return this.user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

}
