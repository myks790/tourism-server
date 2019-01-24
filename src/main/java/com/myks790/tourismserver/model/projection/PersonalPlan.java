package com.myks790.tourismserver.model.projection;

import com.myks790.tourismserver.model.DownloadedPlan;
import com.myks790.tourismserver.model.Plan;
import lombok.Value;

@Value
public class PersonalPlan {
    public PersonalPlan(Plan plan, DownloadedPlan downloaded){
        this.plan = plan;
        this.downloaded = downloaded != null;
    }
    private Plan plan;

    private Boolean downloaded;
}
