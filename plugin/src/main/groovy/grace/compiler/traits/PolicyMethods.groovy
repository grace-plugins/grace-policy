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
package grace.compiler.traits

import groovy.transform.Generated
import groovy.transform.SelfType

import grace.plugins.policy.UnauthorizedException
import grails.artefact.Controller
import grails.core.GrailsClass
import grails.web.api.WebAttributes
import org.graceframework.plugins.policy.GracePolicyArtefactHandler

/**
 * PolicyMethods trait
 *
 * @author Michael Yan
 * @since 0.1
 */
@SelfType(Controller)
trait PolicyMethods extends WebAttributes {

    @Generated
    def authorize(Object record = null, Map<String, Object> options = [:]) {
        String policyClassName = options.with?.name ?: (getControllerClass().packageName + '.' + controllerName.capitalize() + GracePolicyArtefactHandler.TYPE)
        GrailsClass policyClass = getGrailsApplication().getArtefact(GracePolicyArtefactHandler.TYPE, policyClassName)
        Object policyBean = getGrailsApplication().getMainContext().getBean(policyClassName)
        policyBean.record = record
        policyBean.user = getWebRequest().getSession().getAttribute("current_user")
        String methodName = options.to ?: actionName
        boolean result = policyBean?."$methodName"()
        if (!result) render(status: 403) // throw new UnauthorizedException()
        result
    }

}
