/**   
* @Title: SyncHttpInvokeClientTest.java 
* @Package com.tyyd.pay.commons.test.http.client 
* @Description: TODO
* @author joe.chen chenjun296#163.com
* @date 2013-3-19 下午9:04:05 
* @version V1.0   
*/
package com.tyyd.open.api.web.app.spring;

import com.aoyetech.fee.commons.httpclient.HttpInvokeRequest;
import com.aoyetech.fee.commons.httpclient.HttpInvokeResponse;
import com.aoyetech.fee.commons.httpclient.SyncHttpInvokeClient;

import junit.framework.TestCase;


/** 
 * @ClassName: SyncHttpInvokeClientTest 
 * @Description: TODO
 * @author joe.chen chenjun296#163.com 
 * @date 2013-3-19 下午9:04:05 
 *  
 */
public class SyncHttpInvokeClientTest extends TestCase {

	private SyncHttpInvokeClient client = null;
	public void testSyncInvoke() {
		HttpInvokeRequest request = new HttpInvokeRequest("http://www.taobao.com", "post");
		
		HttpInvokeResponse response = client.invoke(request);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getContent());
	}
	
	public void testSyncInvokeByQuery() {
		HttpInvokeRequest request = new HttpInvokeRequest("http://s.taobao.com/search", "get");
		request.addParam("q", "a");
		HttpInvokeResponse response = client.invoke(request);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getContent());
	}

	@Override
	protected void setUp() throws Exception {
		client = new SyncHttpInvokeClient();
	}
	
	
}
