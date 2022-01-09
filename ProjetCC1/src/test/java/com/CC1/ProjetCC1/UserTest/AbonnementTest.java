package com.CC1.ProjetCC1.UserTest;
import com.CC1.ProjetCC1.model.Abonnement;
import com.CC1.ProjetCC1.model.Service;
import com.CC1.ProjetCC1.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AbonnementTest {
    Service service = new Service("test@test.fr","service1",50);
    Date startDate = new Date(2021,1,21);
    Date endDate = new Date(2021,2,21);
Abonnement abonnement = new Abonnement(service,startDate,endDate);

    @Test
    @org.junit.Test
    public void checkDateTestisTrue() {
        Assert.assertTrue(abonnement.checkDate(startDate,endDate));
    }
    @org.junit.Test
    public void checkDateTestisFalse() {
        Assert.assertFalse(abonnement.checkDate(endDate,startDate));
    }
}
