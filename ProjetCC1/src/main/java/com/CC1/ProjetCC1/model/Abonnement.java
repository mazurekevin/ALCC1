package com.CC1.ProjetCC1.model;

import java.time.LocalDate;
import java.util.Date;

public final class Abonnement extends Service {
    private final Date startDate;
    private final Date endDate;

    public Abonnement( Service service, Date startDate, Date endDate) {
        super(service.Email, service.Name, service.Price);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private void checkDate(Date startDate, Date endDate) {
        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("La date de début ne peut pas être après la date de fin.");
        }
    }
    


}
