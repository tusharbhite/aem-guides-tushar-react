package com.adobe.aem.guides.wkndspa.react.core.models;

import com.adobe.aem.guides.wkndspa.react.core.models.Author;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.wcm.api.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = {Author.class, ComponentExporter.class},
        resourceType = AuthorImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions =ExporterConstants.SLING_MODEL_EXTENSION)
@JsonRootName("author-details")
public class AuthorImpl implements Author{
    private static final Logger LOG = LoggerFactory.getLogger(AuthorImpl.class);
    final protected static String RESOURCE_TYPE="wknd-spa-react/components/author";

    @SlingObject
    ResourceResolver resourceResolver;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;

    @ValueMapValue
    private String fname;

    @ValueMapValue
    private String lname;

    @ValueMapValue
    private boolean professor;

    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public boolean getIsProfessor() {
        return professor;
    }

    @Override
    public String getExportedType() {
        // TODO Auto-generated method stub
        return AuthorImpl.RESOURCE_TYPE;
        // throw new UnsupportedOperationException("Unimplemented method 'getExportedType'");
    }
    

}
