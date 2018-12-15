package com.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class FieldDescription {

    private String name;
    private String displayName;
    private String width;
    private String type;
    private boolean isHidden;
    private boolean isTechnical;

}
