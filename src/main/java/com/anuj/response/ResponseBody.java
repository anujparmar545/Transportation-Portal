package com.anuj.response;

/**
 * Response body for requests with data and metadata
 * @author anuj.parmar
 *
 * @param <D> Data class
 * @param <M> Metadata class
 */
public class ResponseBody<D, M> {
	
	private D data;
	private M metadata;
	
	public ResponseBody(final D data, final M metadata) {
		this.data = data;
		this.metadata = metadata;
	}
	
	public void setMetadata(final M metadata) {
		this.metadata = metadata;
	}
	
	public M getMetadata() {
		return metadata;
	}
	
	public void setData(final D data) {
		this.data = data;
	}
	
	public D getData() {
		return data;
	}

}