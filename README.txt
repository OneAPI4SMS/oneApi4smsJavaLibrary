===============================================================================
                    ONE API 4 SMS- README FILE
===============================================================================
-------------------------------------------------------------------------------
OVERVIEW
-------------------------------------------------------------------------------
OneAPI4SMS is an easy to learn and easy to use API for sending and receiving
text messages using long codes or short codes. OneAPI4SMS uses a simple REST
interface based on the GSM Association OneAPI standard for SMS. OneAPI4SMS
builds on the GSMA OneAPI standard and also provides instant long code
activation and account management in many countries serving over 1/2 billion
mobile subscribers.
-------------------------------------------------------------------------------
Base URL
-------------------------------------------------------------------------------

All URLs referenced in the documentation have the following base:

https://api.oneapi4sms.com/v1/

-------------------------------------------------------------------------------
API methods.
-------------------------------------------------------------------------------

1.findAvailableAddress => Method to find all available long codes.

2.addAddress => Method to add an address.

3.setSubscribe => Method for setSubscribe process.

4.viewSubscribe => Method for viewSubscribe process.

5.deliveryStatus => Method for checking delivery status.

6.sendSms => Function for sending a message.

7.allMessages => Function for returning all messages.

For Accessing these methods You need to call these methods,as done in OneApi4SmsResult.java File in Java PlatForm.
