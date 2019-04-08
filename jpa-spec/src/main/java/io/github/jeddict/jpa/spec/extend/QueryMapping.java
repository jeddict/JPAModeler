/**
 * Copyright 2013-2019 the original author or authors from the Jeddict project (https://jeddict.github.io/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.github.jeddict.jpa.spec.extend;

import java.util.regex.Pattern;
import javax.xml.bind.annotation.XmlElement;
import io.github.jeddict.util.StringUtils;
import io.github.jeddict.settings.diagram.ClassDiagramSettings;

/**
 *
 * @author Gaurav Gupta
 */
public abstract class QueryMapping extends DataMapping {

    @XmlElement(required = true)
    protected String query;

    public boolean refractorQuery(String prevQuery, String newQuery) {
        if (ClassDiagramSettings.isRefractorQuery() && StringUtils.containsIgnoreCase(this.getQuery(), prevQuery)) {
            this.setQuery(this.getQuery().replaceAll("\\b(?i)" + Pattern.quote(prevQuery) + "\\b", newQuery));
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the value of the query property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets the value of the query property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setQuery(String value) {
        this.query = value;
    }
}
