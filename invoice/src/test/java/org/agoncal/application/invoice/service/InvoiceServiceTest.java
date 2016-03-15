package org.agoncal.application.invoice.service;

import org.agoncal.application.invoice.model.Invoice;
import org.agoncal.application.invoice.model.InvoiceLine;
import org.agoncal.application.invoice.service.InvoiceService;
import org.agoncal.application.invoice.util.ResourceProducer;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Arquillian.class)
public class InvoiceServiceTest {

    // ======================================
    // =          Injection Points          =
    // ======================================

    @Inject
    private InvoiceService invoiceService;

    // ======================================
    // =         Deployment methods         =
    // ======================================

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Invoice.class)
                .addClass(InvoiceLine.class)
                .addClass(InvoiceService.class)
                .addPackage(ResourceProducer.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    // ======================================
    // =            Test methods            =
    // ======================================

    @Test
    public void should_be_deployed() {
        Assert.assertNotNull(invoiceService);
    }

    @Test
    public void should_crud() {
        // Gets all the objects
        int initialSize = invoiceService.listAll().size();
        assertEquals(initialSize, invoiceService.listAll(0, 10).size());

        // Creates an object
        Invoice invoice = new Invoice("First name", "Last name", "email", "street1", "city", "zipcode", "country");
        InvoiceLine line1 = new InvoiceLine(1, "item1", 2.25F);
        InvoiceLine line2 = new InvoiceLine(3, "item2", 12.5F);
        invoice.addInvoiceLine(line1);
        invoice.addInvoiceLine(line2);

        // Inserts the object into the database
        invoice = invoiceService.persist(invoice);
        assertNotNull(invoice.getId());
        assertEquals(initialSize + 1, invoiceService.listAll().size());
        assertEquals(initialSize + 1, invoiceService.listAll(0, 10).size());

        // Finds the object from the database and checks it's the right one
        invoice = invoiceService.findById(invoice.getId());
        assertEquals(2, invoice.getInvoiceLines().size());
        assertEquals("First name", invoice.getFirstName());

        // Updates the object
        invoice.setFirstName("A new first name");
        invoice = invoiceService.merge(invoice);

        // Finds the object from the database and checks it has been updated
        invoice = invoiceService.findById(invoice.getId());
        assertEquals("A new first name", invoice.getFirstName());

        // Deletes the object from the database and checks it's not there anymore
        invoiceService.remove(invoice);
        assertEquals(initialSize, invoiceService.listAll().size());
    }

    @Test
    public void should_create_an_invoice() {

        // Creates an object
        Invoice invoice = new Invoice("First name", "Last name", "email", "street1", "city", "zipcode", "country");
        InvoiceLine line1 = new InvoiceLine(1, "item1", 25.25F);
        InvoiceLine line2 = new InvoiceLine(3, "item2", 33.75F);
        invoice.addInvoiceLine(line1);
        invoice.addInvoiceLine(line2);

        // Inserts the object into the database
        invoice = invoiceService.persist(invoice);
        assertNotNull(invoice.getId());

        // Finds the object from the database and checks it's the right one
        invoice = invoiceService.findById(invoice.getId());
        assertEquals(2, invoice.getInvoiceLines().size());
        assertEquals("First name", invoice.getFirstName());
        assertEquals(new Float(5.5), invoice.getVatRate());
        assertEquals(new Float(12.5), invoice.getDiscountRate());

        assertEquals(new Float(126.5), invoice.getTotalBeforeDiscount());
        assertEquals(new Float(15.81), invoice.getDiscount());
        assertEquals(new Float(110.69), invoice.getTotalAfterDiscount());
        assertEquals(new Float(6.09), invoice.getVat());
        assertEquals(new Float(116.78), invoice.getTotalAfterVat());
    }
}
