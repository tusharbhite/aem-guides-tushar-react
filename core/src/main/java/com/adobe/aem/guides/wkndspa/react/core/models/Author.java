package com.adobe.aem.guides.wkndspa.react.core.models;

import java.util.List;
import java.util.Map;

import com.adobe.cq.export.json.ComponentExporter;

public interface Author extends ComponentExporter {
    String getFirstName();
    String getLastName();
    boolean getIsProfessor();
}
