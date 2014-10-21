package com.aoyetech.fee.commons.utils;

import com.chinamobile.openmas.client.Sms;


public class OpenMasSmsTestTemp
{
      
    public String sendMsg(String message,String phone){
     try
         {
         
              Sms sms = new Sms("http://61.164.45.183:9080/SMSGateway/services/SMSGatewayService?wsdl");
              String[] destinationAddresses = new String[]{phone};
            
              String extendCode = "0"; 
              String ApplicationID= "travel";
              String Password = "vH3r|ORq64l3";
              String GateWayid = sms.SendMessage(destinationAddresses, message, extendCode, ApplicationID, Password);
              if(GateWayid!=null)
                  return GateWayid;
          }catch(Exception ex){
              return null;
          }
           return null;
        
    }
    
    public static void main(String[] args) {
        new OpenMasSmsTestTemp().sendMsg("hello","15906673934");
    }
}
