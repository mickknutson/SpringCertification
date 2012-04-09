package com.baselogic.demos.interceptors;

public class AfterThrowingInterceptor {

	/*@ExceptionHandler
	public String handleNotFoundException (NotFoundException ex, HttpServletResponse resp)
	{
		WebApiResponse webResp = ex.getWebResp ();
		if (webResp != null) {
			try {
				resp.getWriter ().print (objMapper.writeValueAsString (webResp));
				resp.setStatus (webResp.getHttpStatusCode ());
				resp.setHeader ("Content-Type", "application/json");
			} catch (Exception e) {
				e.printStackTrace ();
			}
		}
		return null;
	}*/
}
