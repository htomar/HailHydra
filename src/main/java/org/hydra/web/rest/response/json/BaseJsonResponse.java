package org.hydra.web.rest.response.json;

public class BaseJsonResponse {
	public static String DEFAULT_ERROR_MSG = "An error occured while processing the request."
			+ "Please try after some time.";

	private String status;
	private String message;

	public static enum ResponseStatus {
		OK("ok"), ERROR("error");

		private String responseStatus;

		private ResponseStatus(String responseStatus) {
			this.responseStatus = responseStatus;
		}

		public String getStatus() {
			return this.responseStatus;
		}
	}

	public BaseJsonResponse() {
	}

	public BaseJsonResponse(ResponseStatus responseStatus) {
		this.setStatus(responseStatus);
	}

	public void setStatus(ResponseStatus responseStatus) {
		this.status = responseStatus.responseStatus;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
