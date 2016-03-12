package org.agoncal.application.invoice;

import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

@MessageDriven
public class InvoiceMDB implements MessageListener {

    @Override
    public void onMessage(Message message) {

    }
}
