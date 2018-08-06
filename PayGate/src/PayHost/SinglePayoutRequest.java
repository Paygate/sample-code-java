/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayHost;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Payout requests allow a Merchant to process pay-outs to their customers.
 *
 * Please note that pay-outs can only be done if the functionality is supported
 * by the relevant acquirer or payment method.
 *
 * @author App Inlet (Pty) Ltd
 * @see
 * <a href="https://qa.paygate.co.za/api/?java#payout-request">SinglePayoutRequest</a>
 * @version 1.0
 * @since 1.0
 */
public class SinglePayoutRequest extends Parent {

    /**
     * Init for SinglePayoutRequest
     *
     * @param payHost PayHost Primary Object
     */
    public SinglePayoutRequest(PayHost payHost) {
        super(payHost);
    }

    /**
     * Payout Request by Card Number
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     * @see <a href="https://qa.paygate.co.za/api/?java#payout-request">Single
     * Payout Request</a>
     */
    public String cardPayoutRequest(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SinglePayoutRequest>"
                + "			<ns1:CardPayoutRequest>"
                + "				<ns1:Account>"
                + "					<ns1:PayGateId>" + object.getProperty("payGateID") + "</ns1:PayGateId>"
                + "					<ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "				</ns1:Account>"
                + "				<ns1:Customer>"
                + "					<ns1:FirstName>" + object.getProperty("firstname") + "</ns1:FirstName>"
                + "					<ns1:LastName>" + object.getProperty("lastname") + "</ns1:LastName>"
                + "					<ns1:Email>" + object.getProperty("email") + "</ns1:Email>"
                + "				</ns1:Customer>"
                + "				<ns1:CardNumber>" + object.getProperty("cardNumber") + "</ns1:CardNumber>"
                + "				<ns1:CardExpiryDate>" + object.getProperty("cardExpiryDate") + "</ns1:CardExpiryDate>"
                + "				<ns1:Order>"
                + "					<ns1:MerchantOrderId>" + object.getProperty("merchantOrderID") + "</ns1:MerchantOrderId>"
                + "					<ns1:Currency>" + object.getProperty("currency") + "</ns1:Currency>"
                + "					<ns1:Amount>" + object.getProperty("amount") + "</ns1:Amount>"
                + "				</ns1:Order>"
                + "			</ns1:CardPayoutRequest>"
                + "		</ns1:SinglePayoutRequest>";
        return util.callWebService(payHost.getUrl(), "SinglePayoutRequest", body);
    }

}
