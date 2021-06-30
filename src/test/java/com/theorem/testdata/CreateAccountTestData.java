package com.theorem.testdata;

import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Data file fo CreateAccountTest
 */
public class CreateAccountTestData {

    String dateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

    /**
     * Data for creating new user account
     */
    public JSONObject userInfo = new JSONObject(
            "{"+
                    "'Gender': 'Male',"+
                    "'FirstName':'Aang'," +
                    "'LastName':'LastAirbender'," +
                    "'Email':'LastAirbender"+dateTime+"@airnomad.com'," +
                    "'Password':'AppaLovesMomo'," +
                    "'DOB_Day':'1'," +
                    "'DOB_Month':'5'," +
                    "'DOB_Year':'1900'," +
                    "'Company':'AirNomad'," +
                    "'Address':'Northern Air Temple'," +
                    "'City':'Northern Air Temple'," +
                    "'State':'Michigan'," +
                    "'ZipCode':'48002'," +
                    "'Mobile':'111-111-1111'," +
                    "'AddressAlias':'Home'" +
                    "}"
    );
}
