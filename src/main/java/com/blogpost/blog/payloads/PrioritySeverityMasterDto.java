package com.blogpost.blog.payloads;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrioritySeverityMasterDto implements Serializable {
    
    private static final long serialVersionUID = 1L;    
    private Long SRNO;
    private String company;
    private String priority;
    private String severity;

    @Override
    public String toString() {
        return "PrioritySeverityMasterDto [SRNO=" + SRNO + ", company=" + company + ", priority=" + priority
                + ", severity=" + severity + "]";
    }
}
