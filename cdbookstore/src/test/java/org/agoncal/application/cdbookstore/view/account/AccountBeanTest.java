package org.agoncal.application.cdbookstore.view.account;

import org.agoncal.application.cdbookstore.model.User;
import org.agoncal.application.cdbookstore.model.UserRole;
import org.agoncal.application.cdbookstore.util.ResourceProducer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class AccountBeanTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private AccountBean accountBean;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap
                .create(JavaArchive.class)
                .addClass(AccountBean.class)
                .addClass(User.class)
                .addClass(UserRole.class)
                .addClass(ResourceProducer.class)
                .addAsManifestResource("META-INF/persistence-test.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void should_be_deployed() {
        Assert.assertNotNull(accountBean);
    }
}
