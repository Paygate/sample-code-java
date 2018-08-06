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
 * Follow up requests allow a Merchant multiple options after processing has
 * taken place.
 * <p>
 * These can be either Settling a transaction (if a merchant is not setup for
 * AutoSettle), refunding a transaction, querying a transaction status, etc.
 *
 * @author App Inlet (Pty) Ltd
 *
 * @version 1.0
 * @since 1.0
 */
public class SinglePayment extends Parent {

    /**
     * Init for SingleVault
     *
     * @param payHost PayHost Primary Object
     */
    public SinglePayment(PayHost payHost) {
        super(payHost);
        this.util = new Utilities();
        this.payHost = payHost;
    }

    /**
     * Card Payment Request
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     */
    public String cardPayment(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SinglePaymentRequest>"
                + "    <ns1:CardPaymentRequest>"
                + "        <ns1:Account>"
                + "            <ns1:PayGateId>" + object.getProperty("payGateID") + "</ns1:PayGateId>"
                + "            <ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "        </ns1:Account>"
                + "        <ns1:Customer>"
                + "            <ns1:Title>" + object.getProperty("title") + "</ns1:Title>"
                + "            <ns1:FirstName>" + object.getProperty("firstname") + "</ns1:FirstName>"
                + "            <ns1:LastName>" + object.getProperty("lastname") + "</ns1:LastName>"
                + "            <ns1:Telephone>" + object.getProperty("phone") + "</ns1:Telephone>"
                + "            <ns1:Mobile>" + object.getProperty("mobile") + "</ns1:Mobile>"
                + "            <ns1:Email>" + object.getProperty("email") + "</ns1:Email>"
                + "        </ns1:Customer>"
                + "        <ns1:CardNumber>" + object.getProperty("cardNumber") + "</ns1:CardNumber>"
                + "        <ns1:CardExpiryDate>" + object.getProperty("cardExpiryDate") + "</ns1:CardExpiryDate>"
                + "        <ns1:CVV>" + object.getProperty("cvv") + "</ns1:CVV>"
                + "        <ns1:BudgetPeriod>" + object.getProperty("budgetPeriod") + "</ns1:BudgetPeriod>"
                + "        <ns1:Redirect>"
                + "            <ns1:NotifyUrl>" + object.getProperty("notifyUrl") + "</ns1:NotifyUrl>"
                + "            <ns1:ReturnUrl>" + object.getProperty("returnUrl") + "</ns1:ReturnUrl>"
                + "        </ns1:Redirect>"
                + "        <ns1:Order>"
                + "            <ns1:MerchantOrderId>" + object.getProperty("merchantOrderID") + "</ns1:MerchantOrderId>"
                + "            <ns1:Currency>" + object.getProperty("currency") + "</ns1:Currency>"
                + "            <ns1:Amount>" + object.getProperty("amount") + "</ns1:Amount>"
                + "        </ns1:Order>"
                + "    </ns1:CardPaymentRequest>"
                + "</ns1:SinglePaymentRequest>";
        return util.callWebService(payHost.getUrl(), "SinglePayment", body);
    }

    /**
     * Web Payment Request
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     */
    public String webPayment(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SinglePaymentRequest>"
                + "    <ns1:WebPaymentRequest>"
                + "        <ns1:Account>"
                + "            <ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "            <ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "        </ns1:Account>"
                + "        <ns1:Customer>"
                + "            <ns1:Title>" + object.getProperty("title") + "</ns1:Title>"
                + "            <ns1:FirstName>" + object.getProperty("firstname") + "</ns1:FirstName>"
                + "            <ns1:LastName>" + object.getProperty("lastname") + "</ns1:LastName>"
                + "            <ns1:Email>" + object.getProperty("email") + "</ns1:Email>"
                + "        </ns1:Customer>"
                + "        <ns1:Redirect>"
                + "            <ns1:NotifyUrl>" + object.getProperty("notifyUrl") + "</ns1:NotifyUrl>"
                + "            <ns1:ReturnUrl>" + object.getProperty("returnUrl") + "</ns1:ReturnUrl>"
                + "        </ns1:Redirect>"
                + "        <ns1:Order>"
                + "            <ns1:MerchantOrderId>" + object.getProperty("merchantOrderID") + "</ns1:MerchantOrderId>"
                + "            <ns1:Currency>" + object.getProperty("currency") + "</ns1:Currency>"
                + "            <ns1:Amount>" + object.getProperty("amount") + "</ns1:Amount>"
                + "            <ns1:TransactionDate>" + object.getProperty("transactionDate") + "</ns1:TransactionDate>"
                + "            <ns1:BillingDetails>"
                + "                 <ns1:Customer>"
                + "                     <ns1:Title>" + object.getProperty("title") + "</ns1:Title>"
                + "                     <ns1:FirstName>" + object.getProperty("firstname") + "</ns1:FirstName>"
                + "                     <ns1:LastName>" + object.getProperty("lastname") + "</ns1:LastName>"
                + "                     <ns1:Email>" + object.getProperty("email") + "</ns1:Email>"
                + "                  </ns1:Customer>"
                + "             <ns1:Address>"
                + "                 <ns1:AddressLine>Apartment 2A</ns1:AddressLine>"
                + "                 <ns1:City>Cape Town</ns1:City>"
                + "                 <ns1:Country>ZAF</ns1:Country>"
                + "                 <ns1:State>Western Cape</ns1:State>"
                + "                 <ns1:Zip>7700</ns1:Zip>"
                + "             </ns1:Address>"
                + "             </ns1:BillingDetails>"
                + "        </ns1:Order>"
                + "    </ns1:WebPaymentRequest>"
                + "</ns1:SinglePaymentRequest>";
        return util.callWebService(payHost.getUrl(), "SinglePayment", body);
    }

    /**
     * Token Payment Request
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     */
    public String tokenPayment(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SinglePaymentRequest>"
                + "    <ns1:TokenPaymentRequest>"
                + "        <ns1:Account>"
                + "            <ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "            <ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "        </ns1:Account>"
                + "        <ns1:Token>" + object.getProperty("token") + "</ns1:Token>"
                + "        <ns1:TokenDetail>" + object.getProperty("tokenDetail") + "</ns1:TokenDetail>"
                + "        <ns1:Order>"
                + "            <ns1:MerchantOrderId>" + object.getProperty("merchantOrderID") + "</ns1:MerchantOrderId>"
                + "            <ns1:Currency>" + object.getProperty("currency") + "</ns1:Currency>"
                + "            <ns1:Amount>" + object.getProperty("amount") + "</ns1:Amount>"
                + "        </ns1:Order>"
                + "    </ns1:TokenPaymentRequest>"
                + "</ns1:SinglePaymentRequest>";
        return util.callWebService(payHost.getUrl(), "SinglePayment", body);
    }

}
