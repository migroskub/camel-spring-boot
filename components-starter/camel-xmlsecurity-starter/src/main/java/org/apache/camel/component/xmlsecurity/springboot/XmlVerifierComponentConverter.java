/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.xmlsecurity.springboot;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.apache.camel.CamelContext;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

/**
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
public class XmlVerifierComponentConverter
        implements
            org.springframework.core.convert.converter.GenericConverter {

    private final CamelContext camelContext;

    public XmlVerifierComponentConverter(
            org.apache.camel.CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> answer = new LinkedHashSet<>();
        answer.add(new ConvertiblePair(String.class, javax.xml.crypto.KeySelector.class));
        answer.add(new ConvertiblePair(String.class, org.apache.camel.component.xmlsecurity.api.ValidationFailedHandler.class));
        answer.add(new ConvertiblePair(String.class, org.apache.camel.component.xmlsecurity.api.XmlSignature2Message.class));
        answer.add(new ConvertiblePair(String.class, org.apache.camel.component.xmlsecurity.api.XmlSignatureChecker.class));
        answer.add(new ConvertiblePair(String.class, javax.xml.crypto.URIDereferencer.class));
        answer.add(new ConvertiblePair(String.class, org.apache.camel.component.xmlsecurity.processor.XmlVerifierConfiguration.class));
        return answer;
    }

    public Object convert(
            Object source,
            TypeDescriptor sourceType,
            TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        String ref = source.toString();
        if (!ref.startsWith("#")) {
            return null;
        }
        ref = ref.startsWith("#bean:") ? ref.substring(6) : ref.substring(1);
        switch (targetType.getName()) {
            case "javax.xml.crypto.KeySelector": return camelContext.getRegistry().lookupByNameAndType(ref, javax.xml.crypto.KeySelector.class);
            case "org.apache.camel.component.xmlsecurity.api.ValidationFailedHandler": return camelContext.getRegistry().lookupByNameAndType(ref, org.apache.camel.component.xmlsecurity.api.ValidationFailedHandler.class);
            case "org.apache.camel.component.xmlsecurity.api.XmlSignature2Message": return camelContext.getRegistry().lookupByNameAndType(ref, org.apache.camel.component.xmlsecurity.api.XmlSignature2Message.class);
            case "org.apache.camel.component.xmlsecurity.api.XmlSignatureChecker": return camelContext.getRegistry().lookupByNameAndType(ref, org.apache.camel.component.xmlsecurity.api.XmlSignatureChecker.class);
            case "javax.xml.crypto.URIDereferencer": return camelContext.getRegistry().lookupByNameAndType(ref, javax.xml.crypto.URIDereferencer.class);
            case "org.apache.camel.component.xmlsecurity.processor.XmlVerifierConfiguration": return camelContext.getRegistry().lookupByNameAndType(ref, org.apache.camel.component.xmlsecurity.processor.XmlVerifierConfiguration.class);
        }
        return null;
    }
}