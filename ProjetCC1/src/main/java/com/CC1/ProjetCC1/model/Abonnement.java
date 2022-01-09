package com.CC1.ProjetCC1.model;

import java.util.Calendar;
import java.util.Date;

public final class Abonnement extends Service {
    private Date startDate;
    private Date endDate;

    public Abonnement( Service service, Date startDate, Date endDate) {
        super(service.Email, service.Name, service.Price);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean checkDate(Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            return false;
        }
        return true;
    }

    public void changeDate(Abonnement abonnement, Date now){
        if(now==abonnement.endDate){
            abonnement.startDate = now;
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, 1);
            abonnement.endDate = cal.getTime();
        }
    }


}
