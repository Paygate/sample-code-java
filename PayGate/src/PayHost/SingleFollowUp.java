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
 * @see
 * <a href="https://qa.paygate.co.za/api/?java#follow-up-request">SingleFollowUpRequest</a>
 * @version 1.0
 * @since 1.0
 */
public class SingleFollowUp extends Parent {

    /**
     * Init for SingleFollowUp
     *
     * @param payHost PayHost Primary Object
     */
    public SingleFollowUp(PayHost payHost) {
        super(payHost);
        this.util = new Utilities();
        this.payHost = payHost;

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
    public String byPayRequestID(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleFollowUpRequest>"
                + "	<ns1:QueryRequest>"
                + "		<ns1:Account>"
                + "			<ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "			<ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "		</ns1:Account>"
                + "		<ns1:PayRequestId>" + object.getProperty("PayRequestId") + "</ns1:PayRequestId>"
                + "	</ns1:QueryRequest>"
                + "</ns1:SingleFollowUpRequest>";
        return getUtil().callWebService(getPh().getUrl(), "SingleFollowUpRequest", body);
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
    public String byMerchantOrderID(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleFollowUpRequest>"
                + "	<ns1:QueryRequest>"
                + "		<ns1:Account>"
                + "			<ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "			<ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "		</ns1:Account>"
                + "		<ns1:MerchantOrderId>" + object.getProperty("MerchantOrderId") + "</ns1:MerchantOrderId>"
                + "	</ns1:QueryRequest>"
                + "</ns1:SingleFollowUpRequest>";
        return getUtil().callWebService(getPh().getUrl(), "SingleFollowUpRequest", body);
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
    public String byTransactionID(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleFollowUpRequest>"
                + "	<ns1:QueryRequest>"
                + "		<ns1:Account>"
                + "			<ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "			<ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "		</ns1:Account>"
                + "		<ns1:TransactionId>" + object.getProperty("TransactionId") + "</ns1:TransactionId>"
                + "	</ns1:QueryRequest>"
                + "</ns1:SingleFollowUpRequest>";
        return getUtil().callWebService(getPh().getUrl(), "SingleFollowUpRequest", body);
    }

    /**
     * The Query function allows you to query the final status of previously
     * processed transactions.
     *
     * The Query function will accept a PayRequestId, TransId or a Reference as
     * a search key.
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     * @see
     * <a href="https://qa.paygate.co.za/api/?java#query-2">QueryRequestType</a>
     */
    public String query(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleFollowUpRequest>"
                + "	<ns1:QueryRequest>"
                + "		<ns1:Account>"
                + "			<ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "			<ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "		</ns1:Account>"
                + "		<ns1:PayRequestId>" + object.getProperty("PayRequestId") + "</ns1:PayRequestId>"
                + "	</ns1:QueryRequest>"
                + "</ns1:SingleFollowUpRequest>";
        return getUtil().callWebService(getPh().getUrl(), "SingleFollowUpRequest", body);
    }

    /**
     * The void function allows merchants to void transactions that are not yet
     * settled or refunded. Settlements and Refunds can only be stopped using
     * the Void request if they have not yet been submitted to the acquiring
     * bank.
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     * @see
     * <a href="https://qa.paygate.co.za/api/?java#void">VoidRequestType</a>
     */
    public String voidOp(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleFollowUpRequest>"
                + "	<ns1:VoidRequest>"
                + "		<ns1:Account>"
                + "			<ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "			<ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "		</ns1:Account>"
                + "		<ns1:TransactionId>" + object.getProperty("transactionID") + "</ns1:TransactionId>"
                + "             <ns1:TransactionType>" + object.getProperty("transactionType") + "</ns1:TransactionType>"
                + "	</ns1:VoidRequest>"
                + "</ns1:SingleFollowUpRequest>";
        return getUtil().callWebService(getPh().getUrl(), "SingleFollowUpRequest", body);
    }

    /**
     * This function allows the merchant to settle an authorisation where
     * AutoSettle is turned off.
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     * @see
     * <a href="https://qa.paygate.co.za/api/?java#settlement">SettlementRequestType</a>
     */
    public String settlment(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleFollowUpRequest>"
                + "	<ns1:SettlementRequest>"
                + "		<ns1:Account>"
                + "			<ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "			<ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "		</ns1:Account>"
                + "		<ns1:TransactionId>" + object.getProperty("transactionID") + "</ns1:TransactionId>"
                + "	</ns1:SettlementRequest>"
                + "</ns1:SingleFollowUpRequest>";
        return getUtil().callWebService(getPh().getUrl(), "SingleFollowUpRequest", body);
    }

    /**
     * This function allows the merchant to refund a transaction that has
     * already been settled.
     *
     * @param object contains params for the function
     * @return Post http Response as XML String ready to Parse
     * @throws ParserConfigurationException ParserConfigurationException
     * @throws SAXException SAXException
     * @throws IOException IOException
     * @see
     * <a href="https://qa.paygate.co.za/api/?java#refund">RefundRequestType</a>
     */
    public String refund(MyObject object) throws IOException, ParserConfigurationException, SAXException {
        String body = "<ns1:SingleFollowUpRequest>"
                + "	<ns1:RefundRequest>"
                + "		<ns1:Account>"
                + "			<ns1:PayGateId>" + object.getProperty("payGateId") + "</ns1:PayGateId>"
                + "			<ns1:Password>" + object.getProperty("password") + "</ns1:Password>"
                + "		</ns1:Account>"
                + "		<ns1:TransactionId>" + object.getProperty("transactionID") + "</ns1:TransactionId>"
                + "             <ns1:Amount>" + object.getProperty("amount") + "</ns1:Amount>"
                + "	</ns1:RefundRequest>"
                + "</ns1:SingleFollowUpRequest>";
        return getUtil().callWebService(getPh().getUrl(), "SingleFollowUpRequest", body);
    }
}
